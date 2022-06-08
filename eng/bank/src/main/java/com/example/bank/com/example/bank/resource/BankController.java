package com.example.bank.com.example.bank.resource;

import com.example.bank.com.example.bank.model.Bank;
import com.example.bank.com.example.bank.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BankController {

    @Autowired
    private BankRepository repository;

    @GetMapping("/bank")
    public List<Bank> getBankData(){
        return repository.findAll();
    }

    @PostMapping("/bank")
    public String saveBank(@RequestBody Bank bank) {
        repository.save(bank);
        return "Added bank data";
    }

    @GetMapping("/bank/{id}")
    public Optional<Bank> getBank(@PathVariable String id) {
        return repository.findById(id);
    }

    @DeleteMapping("/bank/{id}")
    public String deleteBank(@PathVariable String id) {
        repository.deleteById(id);
        return "bank deleted with id : " + id;
    }

    @PutMapping("/bank/{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable String id, @RequestBody Bank bank) {
        Optional<Bank> bankData = repository.findById(id);
        if (bankData.isPresent()) {
            Bank _bank = bankData.get();
            _bank.setCustomer_name(bank.getCustomer_name());
            _bank.setAccount_no(bank.getAccount_no());
            _bank.setEmail(bank.getEmail());
            _bank.setPhone(bank.getPhone());
            _bank.setBalance(bank.getBalance());
            
            return new ResponseEntity<>(repository.save(_bank), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
