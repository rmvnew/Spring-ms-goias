package com.company.mscompanies.service;

import com.company.mscompanies.model.Company;
import com.company.mscompanies.resource.dto.request.CompanyRequestDto;
import com.company.mscompanies.resource.dto.response.CompanyResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService {

    Company save(CompanyRequestDto requestDto);


    Page<CompanyResponseDto> getAllCompanies(String name, String cnpj, Pageable pageable);

}
