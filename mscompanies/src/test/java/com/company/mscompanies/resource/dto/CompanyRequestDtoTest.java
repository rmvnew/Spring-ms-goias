package com.company.mscompanies.resource.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CompanyRequestDtoTest {

    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();



    @Test
    void testValidCompanyName(){
        try{
            CompanyRequestDto dto = new CompanyRequestDto();
            dto.setCompanyName("Acme Inc");

            assertTrue(validator.validate(dto).isEmpty());
        }catch (Exception ex){
            ex.getMessage();
        }
    }

    @Test
    void testCompanyNameWithMultipleSpaces(){
        CompanyRequestDto dto = new CompanyRequestDto();
        dto.setCompanyName("Acme  Inc");

        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    void testCompanyNameWithSpecialCharacter() {
        CompanyRequestDto dto = new CompanyRequestDto();
        dto.setCompanyName("Acme Inc4");

        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    void testCompanyNameWithNumber() {
        CompanyRequestDto dto = new CompanyRequestDto();
        dto.setCompanyName("Acme Inc4");

        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    void testCompanyCnpjInvalid() {
        CompanyRequestDto dto = new CompanyRequestDto();
        dto.setCompanyName("Acme Inc");
        dto.setCompanyCnpj("12.345.678/9012-3");

        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    void testCompanyCnpjValid() {
        CompanyRequestDto dto = new CompanyRequestDto();
        dto.setCompanyName("Acme Inc");
        dto.setCompanyCnpj("12.345.678/9012-34");

        assertTrue(validator.validate(dto).isEmpty());
    }



    @Test
    void testCompanyCnpj() {

        CompanyRequestDto dto = new CompanyRequestDto();
        dto.setCompanyName("Acme");
        dto.setCompanyCnpj("12.345.678/9012-34");
        Set<ConstraintViolation<CompanyRequestDto>> violations = validator.validate(dto);
        violations.forEach(data ->{
            System.out.println("########################");
            System.out.println(data.getMessage());
            System.out.println("########################");
        });


        assertTrue(violations.size() == 0);

    }


    @Test
    void testCompanyPaymentWithInteger() {
        CompanyRequestDto dto = new CompanyRequestDto();
        dto.setCompanyName("Acme Inc");
        dto.setCompanyCnpj("12.345.678/9012-34");

        assertTrue(validator.validate(dto).isEmpty());
    }




}