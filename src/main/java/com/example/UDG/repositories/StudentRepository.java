package com.example.UDG.repositories;

import com.example.UDG.Models.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel, Long> {

    public Optional<StudentModel> findByCode(String code);

    public Optional<StudentModel> findByName(String name);
}
