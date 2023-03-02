package com.company.mscompanies.mapper;

import com.company.mscompanies.model.Company;
import com.company.mscompanies.resource.dto.CompanyResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyResponseDto toDto(Company company);

}
