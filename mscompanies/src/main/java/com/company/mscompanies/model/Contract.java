package com.company.mscompanies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long contractId;

    @Column(name = "contract_number",unique = true)
    private String contractNumber;

    @Column(name = "contract_value")
    private BigDecimal contractValue;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "update_at")
    private Timestamp updateAt;

    @OneToOne(mappedBy = "contract",fetch = FetchType.LAZY)
    @JsonIgnore
    private Company company;


    public Contract(String contractNumber,
                    BigDecimal contractValue,
                    boolean isActive,
                    Timestamp createAt,
                    Timestamp updateAt) {

        this.contractNumber = contractNumber;
        this.contractValue = contractValue;
        this.isActive = isActive;
        this.createAt = createAt;
        this.updateAt = updateAt;

    }
}
