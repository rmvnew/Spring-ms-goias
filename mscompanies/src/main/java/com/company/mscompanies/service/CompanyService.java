package com.company.mscompanies.service;

import com.company.mscompanies.model.Company;
import com.company.mscompanies.resource.dto.CompanyRequestDto;

public interface CompanyService {

    Company save(CompanyRequestDto requestDto);



}
