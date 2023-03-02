package com.company.mscompanies.repository;

import com.company.mscompanies.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {


    Optional<Company> findByCompanyCnpj(String companyCnpj);
}
