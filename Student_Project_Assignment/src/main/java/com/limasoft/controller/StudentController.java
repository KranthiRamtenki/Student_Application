package com.limasoft.controller;
import org.springframework.web.bind.annotation.*;


import com.limasoft.model.Student;
import com.limasoft.service.StudentService;

import java.util.List;

@RestController


public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student/insert")
    
    //@RequestBody annotation is Used for to convert the json object into the java object
    //Spring takes the incoming JSON data, converts it into 
    // a Student object, and passes it to the save() method
    public String save(@RequestBody Student student) {
        studentService.save(student);
        return "Student added successfully!";
    }

    @GetMapping("/student/getdata")
    public List<Student> findAll() {
        return studentService.findAll();
    }
    

    @GetMapping("/{id}")
    // @PathVariable annotation is used to retrieve data from the URL path.
    public Student findById(@PathVariable int id) {
        return studentService.findById(id);
    }

    
    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Student student) {
        student.setSdt_Id(id);
        studentService.update(student);
        return "Student updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        studentService.delete(id);
        return "Student deleted successfully!";
    }
}
