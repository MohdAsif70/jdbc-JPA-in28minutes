package com.in28minutes.learning.course.JDBC;

import com.in28minutes.learning.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class courseJDBCRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static String INSERT_QUERY =
            """
            insert into course (id,name,author) 
            values (?,?,?);
            """;
    private static String DELETE_QUERY =
            """
            delete from course where id = ?;
            """;

    private static String SELECT_QUERY=
            """
                    select * from course where id= ?
                    """;
    public void insert(Course course)
    {
        jdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }
    public void delete(long id)
    {
        jdbcTemplate.update(DELETE_QUERY,id);
    }

    public Course findbyId(long id){
        return jdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
        //Result Set ->Bean =>Row Mapper => id
    }
}
