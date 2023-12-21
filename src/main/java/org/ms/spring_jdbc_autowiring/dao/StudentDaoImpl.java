package org.ms.spring_jdbc_autowiring.dao;

import org.ms.spring_jdbc_autowiring.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("studDaoImpl")
public class StudentDaoImpl implements StudentDao
{
//	@Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insert(Student student) {
        // insert query
        String query1="insert into student(id,name,city) values(?,?,?)";

        int res1 = jdbcTemplate.update(query1, student.getId(), student.getName(), student.getCity());
        return res1;
    }

    public int change(Student student) {
        // updating data
        String query2 = "update student set name=? , city=? where id=?" ;
        int res2 = jdbcTemplate.update(query2, student.getName(), student.getCity(), student.getId());
        return res2;

    }

    public int delete(int studentId) {
        // deleting a student record
        String query3 = "delete from student where id = ?";
       int res3 = jdbcTemplate.update(query3, studentId);
       return res3;

    }

    public Student getStudent(int studentId)  {
        // select single student data
        String query4 = "select * from student where id = ?";
        // Method 1: To implement RowMapper interface method "mapRow()" using implementing class
        RowMapper<Student> rowMapper = new RowMapperImpl();

        Student student = jdbcTemplate.queryForObject(query4, rowMapper, studentId);
        return student;
    }

    public List<Student> getAllStudents() {
        //Selecting multiple student
        String query5 = "select * from student";
        List<Student> students = jdbcTemplate.query(query5, new RowMapperImpl() );
        return students;
    }


}
