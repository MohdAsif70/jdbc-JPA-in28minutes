package com.in28minutes.learning.course;

import com.in28minutes.learning.course.SpingDataJPA.springDataJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class courseCommandLineRunner implements CommandLineRunner {

    //////Below codes for JDBC and JPA// Autowire JPA/JDBC when it is used///
//    @Autowired
//    private com.in28minutes.learning.course.JDBC.courseJDBCRepository repository;

//    @Autowired
//    private courseJPARepository repository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        repository.insert(new Course(1,"Learn AWS","in28minutes"));
//        repository.insert(new Course(2,"Learn DevOps","Udemy"));
//        repository.delete(1);
//        System.out.println(repository.findbyID(2));
//    }



    //////below codes for Spring Data JPA////
    @Autowired
    private springDataJPARepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1,"Learn AWS","in28minutes"));
        repository.save(new Course(2,"Learn DevOps","Udemy"));
        repository.deleteById(1l);
        System.out.println(repository.findById(2l));
        System.out.println(repository.findAll());
        //custom querying for author
        System.out.println(repository.findByAuthor("in28minutes"));
    }
}
