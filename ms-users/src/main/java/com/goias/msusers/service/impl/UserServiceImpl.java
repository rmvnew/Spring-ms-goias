package com.goias.msusers.service.impl;

import com.goias.msusers.enums.ErrorCode;
import com.goias.msusers.exceptions.CustomException;
import com.goias.msusers.model.User;
import com.goias.msusers.repository.ProfileRepository;
import com.goias.msusers.repository.UserRepository;
import com.goias.msusers.resources.dto.mapper.UserMapper;
import com.goias.msusers.resources.dto.request.UserCreateRequestDto;
import com.goias.msusers.resources.dto.request.UserUpdateRequestDto;
import com.goias.msusers.resources.dto.response.UserResponseDto;
import com.goias.msusers.schedule.updateCode;
import com.goias.msusers.service.MailService;
import com.goias.msusers.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Timer;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailService mailService;

    @Override
    public UserResponseDto save(UserCreateRequestDto requestDto) {

        var currentPass = BCrypt.hashpw(requestDto.getUserPassword(), BCrypt.gensalt(8));
        var profile = this.profileRepository.findById(requestDto.getProfileId()).get();
        var isRegistered = this.userRepository.findByUserName(requestDto.getUserName().toUpperCase());
        if (isRegistered.isPresent()) {
            throw new CustomException(ErrorCode.USER_ALREADY_REGISTERED);
        }

        User user = new User(
                requestDto.getUserName().trim().toUpperCase(),
                requestDto.getUserEmail(),
                currentPass, profile,
                true);

        var saved = this.userRepository.save(user);

        return userMapper.toDto(saved);
    }

    @Override
    public Page<UserResponseDto> getAll(Pageable page) {
        return this.userRepository.findAll(page).map(userMapper::toDto);

    }

    @Override
    public UserResponseDto findById(Long id) {
        return userMapper.toDto(this.userRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND)));
    }

    @Override
    public UserResponseDto updateUser(UserUpdateRequestDto requestDto, Long id) {

        var itsSaved = this.userRepository.findById(id);
        var profile = this.profileRepository.findById(requestDto.getProfileId()).get();

        if (itsSaved.isEmpty()) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        var userSaved = itsSaved.get();
        userSaved.setUserName(requestDto.getUserName());
        userSaved.setUserEmail(requestDto.getUserEmail());
        userSaved.setProfile(profile);

        var saveDone = this.userRepository.save(userSaved);

        return userMapper.toDto(saveDone);
    }

    @Override
    public UserResponseDto changeStatus(Long id) {

        var itsSaved = this.userRepository.findById(id);

        if (itsSaved.isEmpty()) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        var userSaved = itsSaved.get();

        userSaved.setActive(!userSaved.isActive());

        var result = this.userRepository.save(userSaved);

        return userMapper.toDto(result);
    }

    @Override
    public void recoverCode(String email) {

        Random random = new Random();

        int ramdomNumber = random.nextInt(900000)+100000;

        var code = Integer.toString(ramdomNumber);

        var user = this.userRepository.findByUserEmail(email)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        user.setRecoverCode(code);

        userRepository.save(user);

        try{
            mailService.sendEmail(email,"Code to recover password","Seu código: "+code);
        }catch (Exception ex){
            ex.getMessage();
        }

        Timer timer = new Timer();
        long delay = 5*60*1000; // 5 minutos em milissegundos
        updateCode task = new updateCode(email, userRepository);
        timer.schedule(task, delay);


    }

    @Override
    public void recoverPass(String email, String code, String pass) {

      var user = this.userRepository.findByUserEmailAndRecoverCode(email,code)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

      var newPassHash = BCrypt.hashpw(pass, BCrypt.gensalt(8));

      user.setUserPassword(newPassHash);
      user.setRecoverCode("");

      this.userRepository.save(user);

    }


}
