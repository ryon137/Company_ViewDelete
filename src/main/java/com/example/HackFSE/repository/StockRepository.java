package com.example.HackFSE.repository;

import main.java.com.example.HackFSE.model.Company;
import com.example.HackFSE.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends MongoRepository<Stock, String> {
    public List<Stock> findByRelatedCompany(Optional<Company> company);
}
