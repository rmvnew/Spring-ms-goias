package com.company.mscompanies.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "product_name")
@Entity(name = "Company")
@Table(name = "tb_company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

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

    public Company() {
    }

    public Company(String companyName, String companyCnpj, BigDecimal companyPayment, boolean isActive, Timestamp createAt, Timestamp updateAt) {
        this.companyName = companyName;
        this.companyCnpj = companyCnpj;
        this.companyPayment = companyPayment;
        this.isActive = isActive;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
