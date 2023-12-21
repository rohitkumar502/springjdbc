package org.ms.spjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "------------Welcome to Spring JDBC----------------" );

        // Spring Jdbc => JdbcTemplate
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplate temp = (JdbcTemplate) context.getBean("jdbcTemp");

        // insert query
        String query="insert into student(id,name,city) values(?,?,?)";

        // fire query
        int res = temp.update(query,512,"Nancy Rani","Patna" );

        System.out.println("No. of record inserted: "+res);


    }
}
