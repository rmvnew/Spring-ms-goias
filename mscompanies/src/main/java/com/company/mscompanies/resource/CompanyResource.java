package com.company.mscompanies.resource;

import com.company.mscompanies.mapper.CompanyMapper;
import com.company.mscompanies.resource.dto.CompanyRequestDto;
import com.company.mscompanies.resource.dto.CompanyResponseDto;
import com.company.mscompanies.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "companies")
public class CompanyResource {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello world!";
    }

    @PostMapping
    public ResponseEntity<CompanyResponseDto> save(@RequestBody CompanyRequestDto dto){
        return  ResponseEntity.ok(companyMapper.toDto(this.companyService.save(dto)));
    }

}
