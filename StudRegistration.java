package com.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudRegistration {
	public void studReg() {
		Scanner obj = new Scanner(System.in);
		boolean valid;
		System.out.println("Enter the first name");
		String firstName=obj.nextLine();
		 valid = firstName.matches("(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$");
		if(valid == false) {
		    System.out.println("Please enter the correct firstname");
		    System.out.println("Firstname should contain character[A-Z] only");

		}

		
		System.out.println("Enter the last name");
		String lastName = obj.nextLine();
		 valid = firstName.matches("(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$");
		if(valid == false) {
		    System.out.println("Please enter the correct firstname");
		    System.out.println("Firstname should contain character[A-Z] only");

		System.out.println("Enter the username");
		String userName=obj.nextLine();

		System.out.println("Enter the password");
		String password =obj.nextLine();

		System.out.println("Enter the city");
		String city = obj.nextLine();

		System.out.println("Enter the mail id");
		String mailId = obj.nextLine();

		System.out.println("Enter the mobile no.");
		long mobNo = obj.nextLong();
		System.out.println("Firstname : "+firstName+"\n Lastname : " +lastName+"\n Username : "+userName+"\n Password : "+password+""
				+ "\n City : "+city+"\n Mail Id : "+mailId+"\n Mobile No : "+mobNo);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demos","root","root");
			Statement st = con.createStatement();
			String sql=("INSERT INTO demotable2(firstName,lastName,userName,password,city,mailId,mobNo) VALUES (?,?,?,?,?,?,?)");
		PreparedStatement prep = con.prepareStatement(sql);
		prep.setString(1,firstName );
		prep.setString(2, lastName);
		prep.setString(3, userName);
		prep.setString(4, password);
		prep.setString(5, city);
		prep.setString(6, mailId);
		prep.setLong(7, mobNo);
		int a = prep.executeUpdate();
		System.out.println(a);
		if (a == 1) {
			System.out.println("Registration Successful...");
		}
		else {
			System.out.println("Registration Unsuccessful...");

		}
		}catch(Exception e) {
			System.out.println(e);
		}	
		}
}

	public void studLogin(){
Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter Username");
	String user_name= scanner.nextLine();
	System.out.println("Enter Password");
	String pass_word= scanner.nextLine();
	
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demos","root","root"); 
	Statement st = con.createStatement();

	PreparedStatement prep = con.prepareStatement("select userName from demotable2 where userName= ?");

	prep.setString(1,  user_name);
	   ResultSet rs = prep.executeQuery();
	   
	   

	   if(rs.next()) {
		   System.out.println("successful");
	   }
	   else {
		   System.out.println("unsuccessful");

	   }


	}catch(Exception e) {
		System.out.println(e);
	}
	}
}

