package com.saumrit.MySpringBootPractiseWithMongoDB.controller;

import com.saumrit.MySpringBootPractiseWithMongoDB.model.StudentDTO;
import com.saumrit.MySpringBootPractiseWithMongoDB.service.MyStudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/students")
public class MyStudentController {
    public MyStudentService myStudentService;

    public MyStudentController(MyStudentService myStudentService) {
        this.myStudentService = myStudentService;
    }

    @GetMapping("/getAllStudents")
    public List<StudentDTO> getAllStudents(){
        return myStudentService.fetchAllStudent();
    }

    @GetMapping("/getAllStudentsSortedBy")
    public List<StudentDTO> getAllStudentsSortedBy(@RequestParam String sortPropertyName){
        return myStudentService.fetchAllStudentSortedBy(sortPropertyName);
    }

    @PostMapping("/addSingleStudent")
    public void addSingleStudent(@RequestBody StudentDTO studentDTO){
        myStudentService.addSingleStudent(studentDTO);
    }

    @DeleteMapping("/{id}/removeStudent")
    public void deleteSingleStudent(@PathVariable String id){
        myStudentService.deleteStudent(id);
    }

    @PutMapping("/updateStudent")
    public StudentDTO updateSingleStudent(@RequestBody StudentDTO studentDTO){
        return myStudentService.updateSingleStudent(studentDTO);
    }

    @PatchMapping("/patchStudentInformation")
    public StudentDTO patchUpdateSingleStudent(@RequestBody StudentDTO studentDTO){
        return myStudentService.updateSingleStudent(studentDTO);
    }





}
