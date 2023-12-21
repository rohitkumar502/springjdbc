package org.ms.spring_jdbc_noXml;

import org.ms.spring_jdbc_noXml.dao.StudentDao;
import org.ms.spring_jdbc_noXml.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.util.*;
public class App
{
    public static void main( String[] args ) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao sd = (StudentDao) context.getBean("studDaoImpl");

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
                    System.out.println("Enter id: ");
                    s1.setId(Integer.parseInt(br.readLine()));
                    System.out.println("Enter name ");
                    s1.setName(br.readLine());
                    System.out.println("Enter city: ");
                    s1.setCity(br.readLine());
                    int res1 = sd.insert(s1);
                    System.out.println("Student added: "+res1);
                    break;

                case 2:
                    // updating an existing student
                    Student s2 = new Student();
                    System.out.println("Enter Id: ");
                    s2.setId(Integer.parseInt(br.readLine()));
                    System.out.println("Enter Name  ");
                    s2.setName(br.readLine());
                    System.out.println("Enter City ");
                    s2.setCity(br.readLine());
                    int res2 = sd.change(s2);
                    System.out.println("Student data changed: "+res2);
                    break;

                case 3:
                    // deleting an existing student
                    System.out.println("Enter studentId to be deleted: ");
                    int res3 = sd.delete(sc.nextInt());
                    System.out.println("Student deleted: "+res3);
                    break;

                case 4:
                    // Selecting single object
                    System.out.println("Enter studentId to be retrieved: ");
                    Student student = sd.getStudent(sc.nextInt());
                    System.out.println(student);
                    break;

                case 5:
                    // Selecting multiple object
                    List<Student> students = sd.getAllStudents();
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
