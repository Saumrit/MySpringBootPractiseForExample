package com.saumrit.MySpringBootPractiseWithMongoDB.service;

import com.saumrit.MySpringBootPractiseWithMongoDB.model.StudentDTO;
import com.saumrit.MySpringBootPractiseWithMongoDB.repository.MyStudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyStudentService {

    public final MyStudentRepository myStudentRepository ;

    public MyStudentService( MyStudentRepository myStudentRepository) {
        this.myStudentRepository=myStudentRepository;
    }

    public List<StudentDTO> fetchAllStudent(){
        return myStudentRepository.findAll();
    }

    public List<StudentDTO> fetchAllStudentSortedBy(String sort_property_name){
        Sort sort= Sort.by(sort_property_name);
        return myStudentRepository.findAll(sort);
    }

    public void deleteStudent(String id){
         myStudentRepository.deleteById(id);
    }

    public void addSingleStudent(StudentDTO studentDTO){
        myStudentRepository.insert(studentDTO);
    }

    public StudentDTO updateSingleStudent(StudentDTO studentDTO){
        return myStudentRepository.save(studentDTO);
    }


}
