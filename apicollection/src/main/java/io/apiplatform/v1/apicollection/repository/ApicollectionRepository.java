package io.apiplatform.v1.apicollection.repository;

import io.apiplatform.v1.apicollection.model.Apicollection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApicollectionRepository extends MongoRepository<Apicollection,String> {
}
