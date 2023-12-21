package org.ms.spring_jdbc_noXml.dao;

import org.ms.spring_jdbc_noXml.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.List;

public class StudentDaoImpl implements StudentDao
{
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        // insert query
        String query1="insert into student(id,name,city) values(?,?,?)";

        int res1 = jdbcTemplate.update(query1, student.getId(), student.getName(), student.getCity());
        return res1;
    }

    @Override
    public int change(Student student) {
        // updating data
        String query2 = "update student set name=? , city=? where id=?" ;
        int res2 = jdbcTemplate.update(query2, student.getName(), student.getCity(), student.getId());
        return res2;

    }

    @Override
    public int delete(int studentId) {
        // deleting a student record
        String query3 = "delete from student where id = ?";
       int res3 = jdbcTemplate.update(query3, studentId);
       return res3;

    }

    @Override
    public Student getStudent(int studentId)  {
        // select single student data
        String query4 = "select * from student where id = ?";
        // Method 1: To implement RowMapper interface method "mapRow()" using implementing class
        RowMapper<Student> rowMapper = new RowMapperImpl();

        Student student = null;
        try {

             student = jdbcTemplate.queryForObject(query4, rowMapper, studentId);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        //Selecting multiple student
        String query5 = "select * from student";
        List<Student> students = jdbcTemplate.query(query5, new RowMapperImpl() );
        return students;
    }


}



