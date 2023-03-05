package com.company.mscompanies.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "update_at")
    private Timestamp updateAt;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "contract_id", referencedColumnName = "contract_id")
    private Contract contract;

    public Company() {
    }

    public Company(String companyName, String companyCnpj,Contract contract,
                   boolean isActive, Timestamp createAt,
                   Timestamp updateAt) {

        this.companyName = companyName;
        this.companyCnpj = companyCnpj;
        this.contract = contract;
        this.isActive = isActive;
        this.createAt = createAt;
        this.updateAt = updateAt;

    }
}
