package com.limasoft.repo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.limasoft.model.Student;


@Repository
public class StudentRepo {
	
	    @Autowired
	    JdbcTemplate jdbcTemplate;

		/*
		 * public StudentRepo(JdbcTemplate jdbcTemplate) { this.jdbcTemplate =
		 * jdbcTemplate; }
		 */

	    public int save(Student student) {
	        String sql = "INSERT INTO student (sdt_id,sdt_name,sdt_fname,sdt_age,sdt_gender,sdt_branch,sdt_addres) VALUES (?,?,?,?,?,?,?)";
	        return jdbcTemplate.update(sql, student.getSdt_Id(),student.getSdt_name(), student.getSdt_fname(), student.getSdt_age(),
	                student.getSdt_gender(), student.getSdt_branch(), student.getSdt_addres());
	    }

	    public List<Student> findAll() {
	        String sql = "SELECT * FROM student";
	        return jdbcTemplate.query(sql, (rs, rowNum) -> {
	            Student student = new Student();
	            student.setSdt_Id(rs.getInt("sdt_Id"));
	            student.setSdt_name(rs.getString("sdt_name"));
	            student.setSdt_fname(rs.getString("sdt_fname"));
	            student.setSdt_age(rs.getInt("sdt_age"));
	            student.setSdt_gender(rs.getString("sdt_gender"));
	            student.setSdt_branch(rs.getString("sdt_branch"));
	            student.setSdt_addres(rs.getString("sdt_addres"));
	            return student;
	        });
	    }

		/*
		 * public Student findById(int id) { String sql =
		 * "SELECT * FROM student WHERE sdt_Id = ?"; return
		 * jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> { Student
		 * student = new Student(); student.setSdt_Id(rs.getInt("sdt_Id"));
		 * student.setSdt_name(rs.getString("sdt_name"));
		 * student.setSdt_fname(rs.getString("sdt_fname"));
		 * student.setSdt_age(rs.getInt("std_age"));
		 * student.setSdt_gender(rs.getString("sdt_sex"));
		 * student.setSdt_branch(rs.getString("sdt_branch"));
		 * student.setSdt_addres(rs.getString("sdt_addres")); return student; }); }
		 */
	    
	    public Student findById(int id) {
	        String sql = "SELECT * FROM student WHERE sdt_Id = ?";
	        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
	            Student student = new Student();
	            student.setSdt_Id(rs.getInt("sdt_Id")); // Correct column name
	            student.setSdt_name(rs.getString("sdt_name")); // Correct column name
	            student.setSdt_fname(rs.getString("sdt_fname")); // Correct column name
	            student.setSdt_age(rs.getInt("sdt_age")); // Corrected column name
	            student.setSdt_gender(rs.getString("sdt_gender")); // Corrected column name
	            student.setSdt_branch(rs.getString("sdt_branch")); // Correct column name
	            student.setSdt_addres(rs.getString("sdt_addres")); // Correct column name
	            return student;
	        });
	    }

	    
	    
	    
	    
	    public int update(Student student) {
	        String sql = "update student SET sdt_name = ?, sdt_fname = ?, sdt_age = ?, sdt_gender = ?, sdt_branch = ?, sdt_addres = ? WHERE sdt_Id = ?";
	        return jdbcTemplate.update(sql, student.getSdt_name(), 
	        		student.getSdt_fname(), student.getSdt_age(),
	                student.getSdt_gender(), student.getSdt_branch(), 
	                student.getSdt_addres(), student.getSdt_Id());
	    }

	    public int delete(int id) {
	        String sql = "DELETE FROM student WHERE sdt_Id = ?";
	        return jdbcTemplate.update(sql, id);
	         
	    }
	}
