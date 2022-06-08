package com.example.bank.com.example.bank.repository;

import com.example.bank.com.example.bank.model.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankRepository extends MongoRepository<Bank,String> {
}
