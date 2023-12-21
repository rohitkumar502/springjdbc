package org.ms.spring_jdbc;

import org.ms.spring_jdbc.dao.StudentDao;
import org.ms.spring_jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.*;

public class App
{
    public static void main( String[] args ) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_jdbcConf.xml");
        StudentDao studentDao = (StudentDao) context.getBean("studDaoImpl");

        while (true)
        {
            System.out.println("Select an operation:");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Select single object");
            System.out.println("5. Select multiple objects");
            System.out.println("0. Exit");

            int id;
            String name;
            String city;
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Adding a new student
                    Student s1 = new Student();
                    System.out.println("Enter id ");
                     id = sc.nextInt();
                     sc.nextLine(); // to capture \n from the previous input
                    //If we use br.readLine() method then this skipping issue automatically solved
                    System.out.println("Enter name ");
                     name = sc.nextLine();
                    System.out.println("Enter city: ");
                     city = sc.nextLine();
                    s1.setId(id);
                    s1.setName(name);
                    s1.setCity(city);
                    int res1 = studentDao.insert(s1);
                    System.out.println("Student added: "+res1);
                    break;

                case 2:
                    // updating an existing student
                    Student s2 = new Student();
                    System.out.println("Enter studentId: ");
                    s2.setId(Integer.parseInt(br.readLine()));
                    System.out.println("Enter studentName  ");
                    s2.setName(br.readLine());
                    System.out.println("Enter studentCity ");
                    s2.setCity(br.readLine());
                    int res2 = studentDao.change(s2);
                    System.out.println("Student data changed: "+res2);
                    break;

                case 3:
                    // deleting an existing student
                    System.out.println("Enter studentId to be deleted: ");
                    int res3 = studentDao.delete(sc.nextInt());
                    System.out.println("Student deleted: "+res3);
                    break;

                case 4:
                    // Selecting single object
                    System.out.println("Enter studentId to be retrieved: ");
                    Student student = studentDao.getStudent(sc.nextInt());
                    System.out.println(student);
                    break;

                case 5:
                    // Selecting multiple object
                    List<Student> students = studentDao.getAllStudents();
                    for(Student s: students)
                    {
                        System.out.println(s);
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
                    break;
            }

            System.out.println(); // Empty line for separation


        }

    }
}
