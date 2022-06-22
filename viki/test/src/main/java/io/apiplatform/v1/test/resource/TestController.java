package io.apiplatform.v1.test.io.apiplatform.v1.test.resource;

import io.apiplatform.v1.test.io.apiplatform.v1.test.model.Test;
import io.apiplatform.v1.test.io.apiplatform.v1.test.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    private TestRepository repository;

    @GetMapping("/test")
    public List<Test> getTestData(){
        return repository.findAll();
    }

    @PostMapping("/test")
    public String saveTest(@RequestBody Test test) {
        repository.save(test);
        return "Added test data";
    }

    @GetMapping("/test/{id}")
    public Optional<Test> getTest(@PathVariable String id) {
        return repository.findById(id);
    }

    @DeleteMapping("/test/{id}")
    public String deleteTest(@PathVariable String id) {
        repository.deleteById(id);
        return "test deleted with id : " + id;
    }

    @PutMapping("/test/{id}")
    public ResponseEntity<Test> updateTest(@PathVariable String id, @RequestBody Test test) {
        Optional<Test> testData = repository.findById(id);
        if (testData.isPresent()) {
            Test _test = testData.get();
            _test.setEId(test.getEId());
            _test.setEName(test.getEName());
            _test.setEmail(test.getEmail());
            _test.setDOJ(test.getDOJ());
            _test.setTime(test.getTime());
            
            return new ResponseEntity<>(repository.save(_test), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
