package com.thulani.repository;

import com.thulani.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 *  @Author : Thulani Kula
 *  * Date : 25 August 2020
 * */

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
