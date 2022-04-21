package com.example.Company_ViewDelete.service;

import com.example.Company_ViewDelete.model.Company;
import com.example.Company_ViewDelete.repository.CompanyRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies(){
        //also return stock price of each company
        return companyRepository.findAll();
    }

    public Optional<Company> getCompany(ObjectId companyCode){
        //also return stock price of this company
        return companyRepository.findById(String.valueOf(companyCode));
    }

    public Optional<Company> deleteCompany(ObjectId companyCode){
        Optional<Company> company = companyRepository.findById(String.valueOf(companyCode));
        companyRepository.deleteById(String.valueOf(companyCode));
        System.out.println("Company " + company + " deleted");
        //delete all stock price associate with it- call stock service
        return company;
    }
}
