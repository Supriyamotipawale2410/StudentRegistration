package com.miniproject;
import java.sql.*;
import java.util.Scanner;
public class main{

public static void  main(String[] args)throws ClassNotFoundException, SQLException { 
	System.out.println("User Oprations:" + "\n 1)Student Registration \n 2) Student login"+"\n 3) display list of questions \n 4) Store result into db"+ "5) display quiz result :");
	System.out.println("Admin Operation : \n 6)Display all students score as per ascending order\r\n" + " \n 7)Fetch student score by using id\r\n" + " \n 8)Add question with 4 options into database \n");
	System.out.println("Enter :");
	Scanner myobj = new Scanner(System.in);
	int userChoice= myobj.nextInt();
	System.out.println(userChoice);
switch(userChoice) {
case 1:
	Scanner obj = new Scanner(System.in);
	System.out.println("Enter the first name");
	String firstName=obj.nextLine();
	
	System.out.println("Enter the last name");
	String lastName = obj.nextLine();

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
	System.out.println(firstName);
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
	}catch(Exception e) {
		System.out.println(e);
	}
	break;
case 2:
Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter Username");
	String user_name= scanner.nextLine();
	System.out.println("Enter Password");
	String pass_word= scanner.nextLine();
	
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection  connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/demos","root","root");  
    Statement stmt = connect.createStatement();
    ResultSet rs = stmt.executeQuery("select * from demotable2");

    while (rs.next()) { 
        String user = rs.getString("userName");
        String pass = rs.getString("password");        
    
	}
	if ((user_name==  rs.getString("userName")) && (pass_word==rs.getString("password"))) {
		System.out.println("Login Successfully....");
	}
	else {
		System.out.println("Login Failed....");
	}
	}catch(Exception e) {
		System.out.println(e);
	}
}
}
}