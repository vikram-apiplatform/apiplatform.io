package io.apiplatform.v1.test.io.apiplatform.v1.test.repository;

import io.apiplatform.v1.test.io.apiplatform.v1.test.model.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<Test,String> {
}
