package com.company.mscompanies.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "product_name")
@Entity(name = "Company")
@Table(name = "tb_company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    @NotBlank(message = "O nome da empresa não pode estar em branco")
    @Pattern(regexp = "^(?!\\s{2,})[a-zA-Z]+(\\s[a-zA-Z]+)*$",
            message = "O nome da empresa não pode conter dois ou mais espaços em branco consecutivos, números ou caracteres especiais")
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_cnpj")
    private String companyCnpj;

    @Column(name = "company_payment")
    private BigDecimal companyPayment;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "update_at")
    private Timestamp updateAt;

}
