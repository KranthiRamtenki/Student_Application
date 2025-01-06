package com.limasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limasoft.model.Student;
import com.limasoft.repo.StudentRepo;

import java.util.List;

@Service
public class StudentService {
	
	
    private final StudentRepo studrepo;
    
    //Constructor injection helps to make the class immutable 
    //(since the dependencies are set once and can't be changed).

    public StudentService(StudentRepo studrepo) {
        this.studrepo = studrepo;
    }

    public int save(Student student) {
        return studrepo.save(student);
    }

    public List<Student> findAll() {
        return studrepo.findAll();
    }
    //The findById method in the StudentService class receives the id and calls the findById 
    //method in the StudentRepository class, passing along the same id
    public Student findById(int id) {
        return studrepo.findById(id);
    }

    public int update(Student student) {
        return studrepo.update(student);
    }

    public int delete(int id) {
        return studrepo.delete(id);
    }
}
