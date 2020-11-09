package com.thulani.repository;
/**
 *Author: Anastasia Abrahams
 *  * Date 25 November 2020
 *  Modify to JpaRepository: 27 October 2020
 */

import com.thulani.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

}
