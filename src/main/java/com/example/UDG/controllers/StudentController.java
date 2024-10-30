package com.example.UDG.controllers;

import com.example.UDG.Models.StudentModel;
import com.example.UDG.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

    //get
    @GetMapping() 
    public ArrayList<StudentModel> findAllStudents(){
        return studentService.findAllStudents();
    }

    //findByCode
    @CrossOrigin
    @GetMapping("/findByCode={code}")
    public Optional<StudentModel> findStudentByCode(@PathVariable("code") String code){
        return studentService.findStudentByCode(code);
    }

    //findByName
    @GetMapping("/findByName={name}")
    public Optional<StudentModel> findStudentByName(@PathVariable("name") String name){
        return studentService.findStudentByName(name);
    }

    @CrossOrigin
    @DeleteMapping("/deleteByCode={code}") //localhost:8080/student/deleteByCode=123
    public String deleteStudent(@PathVariable("code") String code){
        return studentService.deleteStudent(code);
    }

    //editar
    @PutMapping()
    public StudentModel updateStudent(@RequestBody StudentModel student){
        return studentService.saveStudent(student);
    }

    //post
    @PostMapping()
    public StudentModel saveStudent(@RequestBody StudentModel student) {
        return studentService.saveStudent(student);
    }






}
