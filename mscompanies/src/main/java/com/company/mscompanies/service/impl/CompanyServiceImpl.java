package com.company.mscompanies.service.impl;

import com.company.mscompanies.enums.ErrorCode;
import com.company.mscompanies.exceptions.CustomException;
import com.company.mscompanies.mapper.CompanyMapper;
import com.company.mscompanies.model.Company;
import com.company.mscompanies.model.Contract;
import com.company.mscompanies.repository.CompanyRepository;
import com.company.mscompanies.resource.dto.request.CompanyRequestDto;
import com.company.mscompanies.resource.dto.response.CompanyResponseDto;
import com.company.mscompanies.service.CompanyService;
import com.company.mscompanies.utils.CnpjValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public Company save(CompanyRequestDto requestDto) {

        if (!CnpjValidator.isValid(requestDto.getCompanyCnpj())) {
            throw new CustomException(ErrorCode.INVALID_CNPJ);
        }

        var saved = this.companyRepository.findByCompanyCnpj(requestDto.getCompanyCnpj());

        if (saved.isPresent()) {
            throw new CustomException(ErrorCode.COMPANY_ALREADY_REGISTERED);
        }

        var contractNumber = UUID.randomUUID().toString();

        var contract = new Contract(
                contractNumber,
                requestDto.getContract().getContractValue(),
                true,
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()));


        var company = new Company(
                requestDto.getCompanyName(),
                requestDto.getCompanyCnpj(),
                contract,
                true,
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()));

        return this.companyRepository.save(company);
    }

    @Override
    public Page<CompanyResponseDto> getAllCompanies(String name, String cnpj, Pageable pageable) {
        return this.companyRepository.getAllCompanies(name, cnpj, pageable).map(companyMapper::toDto);
    }

//    @Scheduled(fixedRate = 10000)
//    private void teste() {
//        var date = LocalDateTime.now();
//        System.out.println(date);
//    }


}
