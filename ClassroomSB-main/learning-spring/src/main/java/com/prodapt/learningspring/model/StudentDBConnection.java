package com.prodapt.learningspring.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDBConnection {
	
	private Connection cnx = null;
	
	public StudentDBConnection() {
		try {
			this.cnx= DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","fawwazuddin", "fawwaz@123");

			System.out.println("Connected Successfully");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(int studentID, String studentName, int studentRank, int studentScore)  {
				
		String insertQuery = "INSERT INTO Student (studentID, studentName, studentScore, studentRank) VALUES(?,?,?,?)";
	
		try (PreparedStatement statement = cnx.prepareStatement(insertQuery)) {

		statement.setInt(1, studentID);
		statement.setString(2,studentName);
		statement.setInt(3,studentRank);
		statement.setInt(4,studentScore);
		
		statement.executeUpdate();
	} catch (SQLException e)
		{
		e.printStackTrace();
	}
}
	
	public void remove(int studentID, String studentName, int studentRank, int studentScore)  {
		
		String deleteQuery = "DELETE FROM Student WHERE ";
}