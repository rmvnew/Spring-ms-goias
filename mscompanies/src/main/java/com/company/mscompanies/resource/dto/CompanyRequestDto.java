package com.company.mscompanies.resource.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CompanyRequestDto {
    @NotBlank(message = "O nome da empresa não pode estar em branco")
    @Pattern.List({
            @Pattern(regexp = "^(?!\\s{2,})[a-zA-Z]+(\\s[a-zA-Z]+)*$", message = "O nome da empresa não pode conter dois ou mais espaços em branco consecutivos, números ou caracteres especiais"),
            @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "O nome da empresa não pode conter caracteres especiais!")
    })
    @Column(name = "company_name")
    private String companyName;

    @Size(min = 18,max = 18)
    @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$", message = "O CNPJ deve estar no formato XX.XXX.XXX/XXXX-XX")
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

}
