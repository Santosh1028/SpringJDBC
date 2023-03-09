package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.entities.Student;


@Component("studentDao")
public class StudetnDaoImpl implements StudentDao {

	
	@Autowired
	private JdbcTemplate template;

	public int insert(Student student) {

		String query = "insert into student(id, name, address) values(?,?,?)";

		int r = this.template.update(query, student.getId(), student.getName(), student.getAddress());
		return r;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int change(Student student) {
		String query = "update student set name=?, address=? where id=?";

		int r = this.template.update(query, student.getName(), student.getAddress(), student.getId());
		return r;
	}

	public int delete(int studentId) {
		String query = "delete from student where id=?";

		int r = this.template.update(query, studentId);
		return r;
	}

	public Student getStudent(int id) {
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.template.queryForObject(query, rowMapper, id);
		return student;
	}

	public List<Student> getAllStudent() {
		
		String query="select * from student";
		List<Student> students = this.template.query(query, new RowMapperImpl());
		
		return students;
	}
	
	

}
