package com.in28minutes.learning.course.SpingDataJPA;

import com.in28minutes.learning.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface springDataJPARepository extends JpaRepository<Course,Long> {

    List<Course> findByAuthor(String author);
}
