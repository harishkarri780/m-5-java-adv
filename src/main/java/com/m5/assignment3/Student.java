package com.m5.assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("org.postgresql.Driver");
			String url= "jdbc:postgresql://localhost:5432/m5_jdbc";
			String username= "postgres";
			String password = "KARRIHARISHRAO@780";
			
			Connection connection = DriverManager.getConnection(url,username,password);
			String query="";
			Statement s = connection.createStatement();
			
			while(true) {
				
				System.out.println("1.add data");
				System.out.println("2.update data");
				System.out.println("3.delete data");
				System.out.println("Enter Your choice");
				int choice = sc.nextInt();
				
				switch(choice) {
				
				case 1:
					query = "insert into students (first_name, last_name, date_of_birth, email, phone_number) values('Harish', 'Karri', '2004-05-15', 'Harish.karri09@example.com', '9090903210')";
					s.execute(query);
					System.out.println("Data is inserted succesfully....");
					System.out.println();
					break;
				case 2:
					query = "delete from students where first_name='Harish'";
					s.execute(query);
					System.out.println("Data is deleted succesfully....");
					System.out.println();
					break;
				case 3:
					query = "update students set email='rohan@gmail.com' where first_name='Harish'";
					s.execute(query);
					System.out.println("Data is update succesfully....");
					System.out.println();
					break;
					
				
				}
				s.close();
				connection.close();
				
				
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
