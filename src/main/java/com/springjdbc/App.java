package com.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("My Program Started");
		// Spring Jdbc=> JdbcTemplate

		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("com/springjdbc/config.xml");
		 */
		
		ApplicationContext context= new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		/*
		 * Student st=new Student(); st.setId(224); st.setName("Anees");
		 * st.setAddress("Larkana");
		 * 
		 * int result = studentDao.insert(st);
		 * 
		 * System.out.println("Student Added"+result);
		 */

		/*
		 * Student st1=new Student(); st1.setId(224); st1.setName("Sanees");
		 * st1.setAddress("Mithi");
		 * 
		 * int result1 = studentDao.change(st1);
		 * 
		 * System.out.println("Student Changed"+result1);
		 */

		/*
		 * int result1 = studentDao.delete(223); System.out.println("Student deleted" +
		 * result1);
		 */
		
		/*
		 * Student student= studentDao.getStudent(224); System.out.println(student);
		 */
		
		List<Student> student= studentDao.getAllStudent();
		
		for(Student s: student) {
			System.out.println(s);
		}

	}
}
