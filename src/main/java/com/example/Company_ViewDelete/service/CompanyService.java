package com.example.Company_ViewDelete.service;

import com.example.Company_ViewDelete.model.Company;
import com.example.Company_ViewDelete.repository.CompanyRepository;
import com.example.Company_ViewDelete.repository.StockRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private final CompanyRepository companyRepository;
    private StockRepository stockRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

    public Optional<Company> getCompany(ObjectId companyCode){
        return companyRepository.findById(String.valueOf(companyCode));
    }

    public Optional<Company> deleteCompany(ObjectId companyCode){
        Optional<Company> company = companyRepository.findById(String.valueOf(companyCode));
        companyRepository.deleteById(String.valueOf(companyCode));
        System.out.println("Company " + company + " deleted");
        //delete all stock price associate with it- call stock service
        stockRepository.deleteAllBycompanyCode(companyCode);
        return company;
    }
}
