package com.saumrit.MySpringBootPractiseWithMongoDB.repository;

import com.saumrit.MySpringBootPractiseWithMongoDB.model.StudentDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyStudentRepository extends MongoRepository<StudentDTO, String> {

    List<StudentDTO> findByName(String name);
}
