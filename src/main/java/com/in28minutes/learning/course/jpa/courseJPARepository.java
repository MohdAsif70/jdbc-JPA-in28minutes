package com.in28minutes.learning.course.jpa;

import com.in28minutes.learning.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class courseJPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course){
        entityManager.merge(course);
    }
    public Course findbyID(long id){
        return entityManager.find(Course.class,id);
    }

    public void delete (long id){
        Course course=entityManager.find(Course.class,id);
        entityManager.remove(course);
    }
}
