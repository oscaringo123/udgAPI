package com.example.UDG.services;

import com.example.UDG.Models.StudentModel;
import com.example.UDG.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.io.Serial;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //Obtener todos los estudiantes registrados
    public ArrayList<StudentModel> findAllStudents(){
        return (ArrayList<StudentModel>)  studentRepository.findAll();
    }

    //guardar un estudiante
    public StudentModel saveStudent(StudentModel student){
        return studentRepository.save(student);
    }

    //findStudent by code
    public Optional<StudentModel> findStudentByCode(String code){
        return studentRepository.findByCode(code);
    }

    // findByName
    public Optional<StudentModel> findStudentByName(String name){
        return studentRepository.findByName(name);
    }

    //Delete
    public String deleteStudent(String code){
        String response = "";
        Optional<StudentModel> studentFound = studentRepository.findByCode(code);
        if(studentFound.isPresent()){
            studentRepository.delete(studentFound.get());
            response = "Student deleted successfully";
        }else{
            response = "student not found";
        }
        return response;
    }

}
