package org.ms.spring_jdbc_noXml;

import org.ms.spring_jdbc_noXml.dao.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

//    @Bean("ds")
    public DataSource getDataSource()
    {
        // Here DataSource is the ancestor parent class of the DriverManagerDataSource class
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        ds.setUsername("root");
        ds.setPassword("Rohit@8433");
        return ds;
    }

//    @Bean("jdbcTemp")
    public JdbcTemplate getTemplate()
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }

    @Bean("studDaoImpl")
    public StudentDao getStudentDao()
    {
        StudentDaoImpl studDaoImpl = new StudentDaoImpl();
        studDaoImpl.setJdbcTemplate(getTemplate());
        return studDaoImpl;
    }

}


