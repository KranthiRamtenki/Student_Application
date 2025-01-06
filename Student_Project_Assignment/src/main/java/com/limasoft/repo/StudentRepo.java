package com.limasoft.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.limasoft.model.Student;


@Repository
public class StudentRepo {
	
	 @Autowired   
	 private   JdbcTemplate jdbcTemplate;

	    public int save(Student student) {
	        String sql = "INSERT INTO student (sdt_id,sdt_name,sdt_fname,sdt_age,sdt_gender,sdt_branch,sdt_addres) VALUES (?,?,?,?,?,?,?)";
	        return jdbcTemplate.update(sql, student.getSdt_Id(),student.getSdt_name(), student.getSdt_fname(), student.getSdt_age(),
	                student.getSdt_gender(), student.getSdt_branch(), student.getSdt_addres());
	    }

	    public List<Student> findAll() {
	        String sql = "SELECT * FROM student";
	        
	    //The query() method in JdbcTemplate is used to execute 
	    //a SQL query and map the result set to Java objects.    
	        return jdbcTemplate.query(sql, 
	        		(rs, rowNum) -> {
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

		
	    
	    public Student findById(int id) {
	        String sql = "SELECT * FROM student WHERE sdt_Id = ?";
	       
	        
	        
	        //inside the queryForObject() call, the RowMapper is responsible for mapping the result 
            //of the query (the database row) to a Student object.
	        // rowmapper{ class  object mapping (e.g., using RowMapper to convert query results into Java objects).
	        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Student>() {
	            @Override
	            //The ResultSet (rs): is used to extract the data returned by the SQL query.
	            //The mapRow(): method is executed for the row returned by the query:
	            //student.setSdt_Id(rs.getInt("sdt_Id")): Extracts the value 
	            //from the sdt_Id column and sets it to the Student object.
	           
	            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	        
	            Student student = new Student();
	            student.setSdt_Id(rs.getInt("sdt_Id")); // Correct column name
	            student.setSdt_name(rs.getString("sdt_name")); // Correct column name
	            student.setSdt_fname(rs.getString("sdt_fname")); // Correct column name
	            student.setSdt_age(rs.getInt("sdt_age")); // Corrected column name
	            student.setSdt_gender(rs.getString("sdt_gender")); // Corrected column name
	            student.setSdt_branch(rs.getString("sdt_branch")); // Correct column name
	            student.setSdt_addres(rs.getString("sdt_addres")); // Correct column name
	            return student;
	       
	            }
	         
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
	    
