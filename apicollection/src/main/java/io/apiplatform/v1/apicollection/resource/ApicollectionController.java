package io.apiplatform.v1.apicollection.resource;

import io.apiplatform.v1.apicollection.model.Apicollection;
import io.apiplatform.v1.apicollection.repository.ApicollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApicollectionController {

    @Autowired
    private ApicollectionRepository repository;

    @GetMapping("/apicollection")
    public List<Apicollection> getApicollectionData(){
        return repository.findAll();
    }

    @PostMapping("/apicollection")
    public String saveApicollection(@RequestBody Apicollection apicollection) {
        repository.save(apicollection);
        return "Added apicollection data";
    }

    @GetMapping("/apicollection/{id}")
    public Optional<Apicollection> getApicollection(@PathVariable String id) {
        return repository.findById(id);
    }

    @DeleteMapping("/apicollection/{id}")
    public String deleteApicollection(@PathVariable String id) {
        repository.deleteById(id);
        return "apicollection deleted with id : " + id;
    }

    @PutMapping("/apicollection/{id}")
    public ResponseEntity<Apicollection> updateApicollection(@PathVariable String id, @RequestBody Apicollection apicollection) {
        Optional<Apicollection> apicollectionData = repository.findById(id);
        if (apicollectionData.isPresent()) {
            Apicollection _apicollection = apicollectionData.get();
            _apicollection.setName(apicollection.getName());
            _apicollection.setDescription(apicollection.getDescription());
            _apicollection.setPartner(apicollection.getPartner());
            _apicollection.setAccount(apicollection.getAccount());
            _apicollection.setAuthModel(apicollection.getAuthModel());
            _apicollection.setApiExecutors(apicollection.getApiExecutors());
            _apicollection.setCreatedAt(apicollection.getCreatedAt());
            _apicollection.setLastUpdatedAt(apicollection.getLastUpdatedAt());
            _apicollection.setExecutorsOrder(apicollection.getExecutorsOrder());
            _apicollection.setCollectionScope(apicollection.getCollectionScope());
            _apicollection.setHeaders(apicollection.getHeaders());
            _apicollection.setQueryParams(apicollection.getQueryParams());
            _apicollection.setPathParams(apicollection.getPathParams());
            _apicollection.setCreatedBy(apicollection.getCreatedBy());
            _apicollection.setUpdatedBy(apicollection.getUpdatedBy());
            _apicollection.setDisplayname(apicollection.getDisplayname());
            _apicollection.setCategory(apicollection.getCategory());
            _apicollection.setVersion(apicollection.getVersion());
            
            return new ResponseEntity<>(repository.save(_apicollection), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
