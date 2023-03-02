package com.company.mscompanies.service.impl;

import com.company.mscompanies.enums.ErrorCode;
import com.company.mscompanies.exceptions.CustomException;
import com.company.mscompanies.model.Company;
import com.company.mscompanies.repository.CompanyRepository;
import com.company.mscompanies.resource.dto.CompanyRequestDto;
import com.company.mscompanies.service.CompanyService;
import com.company.mscompanies.utils.CnpjValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CompanyServiceImpl implements CompanyService {

        @Autowired
        private CompanyRepository companyRepository;

    @Override
    public Company save(CompanyRequestDto requestDto) {

        if(!CnpjValidator.isValid(requestDto.getCompanyCnpj())){
            throw new CustomException(ErrorCode.INVALID_CNPJ);
        }

        var saved = this.companyRepository.findByCompanyCnpj(requestDto.getCompanyCnpj());

        if(saved.isPresent()){
            throw  new CustomException(ErrorCode.COMPANY_ALREADY_REGISTERED);
        }

        var company = new Company(
                requestDto.getCompanyName(),
                requestDto.getCompanyCnpj(),
                requestDto.getCompanyPayment(),
                true,
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()));

        return this.companyRepository.save(company);
    }



}
