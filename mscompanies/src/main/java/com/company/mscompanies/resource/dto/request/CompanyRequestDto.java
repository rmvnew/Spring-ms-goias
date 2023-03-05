package com.company.mscompanies.resource.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequestDto {
    @NotBlank(message = "O nome da empresa não pode estar em branco")
    @Pattern.List({
            @Pattern(regexp = "^(?!\\s{2,})[a-zA-Z]+(\\s[a-zA-Z]+)*$", message = "O nome da empresa não pode conter dois ou mais espaços em branco consecutivos, números ou caracteres especiais"),
            @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "O nome da empresa não pode conter caracteres especiais!")
    })
    private String companyName;

    @Size(min = 18,max = 18)
    @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$", message = "O CNPJ deve estar no formato XX.XXX.XXX/XXXX-XX")
    private String companyCnpj;

    private ContractRequestDto contract;

    public CompanyRequestDto(String companyName, String companyCnpj, ContractRequestDto contract) {
        this.companyName = companyName;
        this.companyCnpj = companyCnpj;
        this.contract = contract;
    }

    public CompanyRequestDto() {

    }

}
