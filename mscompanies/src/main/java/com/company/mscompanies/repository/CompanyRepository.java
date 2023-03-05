package com.company.mscompanies.repository;

import com.company.mscompanies.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {


    Optional<Company> findByCompanyCnpj(String companyCnpj);

    @Query("SELECT c FROM Company c WHERE c.companyName like %:name% OR c.companyCnpj = :cnpj AND c.isActive != false ")
    Page<Company> getAllCompanies(@Param("name") String name, @Param("cnpj") String cnpj, Pageable pageable);
}
