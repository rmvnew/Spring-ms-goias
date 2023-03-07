package com.goias.msusers.resources;

import com.goias.msusers.model.User;
import com.goias.msusers.resources.dto.request.RecoverPassRequestDto;
import com.goias.msusers.resources.dto.request.UserCreateRequestDto;
import com.goias.msusers.resources.dto.request.UserUpdateRequestDto;
import com.goias.msusers.resources.dto.response.UserResponseDto;
import com.goias.msusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users")
public class UserResources {

    @Autowired
    private UserService userService;

//    @Autowired
//    private MailService mailService;

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserCreateRequestDto user) {
        return ResponseEntity.ok(this.userService.save(user));
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> getAll(Pageable page) {
        return ResponseEntity.ok(this.userService.getAll(page));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userService.findById(id));
    }

    @GetMapping(value = "/email",params = "email")
    public ResponseEntity<User> findByUserEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(this.userService.findByUserEmail(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable("id") Long id,
            @RequestBody UserUpdateRequestDto requestDto) {
        return ResponseEntity.ok(this.userService.updateUser(requestDto, id));
    }

    @PatchMapping("/change-status/{id}")
    public ResponseEntity<UserResponseDto> changeStatus(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userService.changeStatus(id));
    }


    @PostMapping("/recover-code")
    public void recoverCode(@RequestParam String email) {
        this.userService.recoverCode(email);
    }

    @PostMapping("/recover-pass")
    public void recoverPas(@ModelAttribute("recover") RecoverPassRequestDto recover) {
        this.userService.recoverPass(recover.getEmail(), recover.getCode(), recover.getPass());
    }
}
