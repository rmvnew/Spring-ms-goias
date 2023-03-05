package com.company.mscompanies.resource.dto.response;

import com.company.mscompanies.model.Contract;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CompanyResponseDto {

    private Long companyId;

    private String companyName;

    private String companyCnpj;

    private Contract contract;

}
