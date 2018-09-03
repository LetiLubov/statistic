package com.spring.app.controllers;

import com.spring.app.domain.Company;
import com.spring.app.repos.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CompanyContoller {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("companies")
    public String main(Map<String, Object> model) {
        Iterable<Company> messages = companyRepository.findAll();

        model.put("companies", messages);

        return "company";
    }

    @PostMapping("companies")
    public String add(@RequestParam String name, Map<String, Object> model) {

        Company company = new Company(name);
        companyRepository.save(company);

        Iterable<Company> companies = companyRepository.findAll();

        model.put("companies", companies);

        return "company";
    }

}
