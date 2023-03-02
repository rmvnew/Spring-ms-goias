package com.company.mscompanies.resource.dto;

import com.company.mscompanies.enums.ErrorCode;
import com.company.mscompanies.exceptions.CustomException;
import com.company.mscompanies.utils.CnpjValidator;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;


public class CompanyRequestDto {
    @NotBlank(message = "O nome da empresa não pode estar em branco")
    @Pattern(regexp = "^(?!\\s{2,})[a-zA-Z]+(\\s[a-zA-Z]+)*$",
            message = "O nome da empresa não pode conter dois ou mais espaços em branco consecutivos, números ou caracteres especiais")
    @Column(name = "company_name")
    private String companyName;

    @Pattern(regexp = "^\\d{14}$", message = "O campo deve conter 14 dígitos numéricos")
    @Column(name = "company_cnpj")
    private String companyCnpj;

    @Column(name = "company_payment")
    private BigDecimal companyPayment;

    public CompanyRequestDto(String companyName, String companyCnpj, BigDecimal companyPayment) {
        this.companyName = companyName;
        this.companyCnpj = companyCnpj;
        this.companyPayment = companyPayment;
    }

    public CompanyRequestDto() {

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCnpj() {
        return companyCnpj;
    }

    public void setCompanyCnpj(String companyCnpj) {

        if (CnpjValidator.isValid(companyCnpj)) {
            this.companyCnpj = companyCnpj;
        } else {
            throw new CustomException(ErrorCode.INVALID_CNPJ);
        }
    }

    public BigDecimal getCompanyPayment() {
        return companyPayment;
    }

    public void setCompanyPayment(BigDecimal companyPayment) {
        this.companyPayment = companyPayment;
    }
}
