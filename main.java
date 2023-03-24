package com.miniproject;
import java.sql.*;
import java.util.Scanner;
public class main{

public static void  main(String[] args)throws ClassNotFoundException, SQLException { 
	System.out.println("User Oprations:" + "\n 1)Student Registration \n 2) Student login"+"\n 3) display list of questions \n 4) Store result into db"+ "\n 25) display quiz result :");
	System.out.println("Admin Operation : \n 6)Display all students score as per ascending order" + " \n 7)Fetch student score by using id" + " \n 8)Add question with 4 options into database \n");
	System.out.println("Enter :");
	Scanner myobj = new Scanner(System.in);
	int userChoice= myobj.nextInt();
	System.out.println(userChoice);
	StudRegistration studRegistration = new StudRegistration();

switch(userChoice) {
case 1:
	studRegistration.studReg();
	
	break;
case 2:
	studRegistration.studLogin();
}
}
}