package com.example.Company_ViewDelete.repository;

import com.example.Company_ViewDelete.model.Stock;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<Stock, String> {
    void deleteAllBycompanyCode(ObjectId companyCode);
}
