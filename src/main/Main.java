package main;

import java.sql.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost:3306/JDBCdemo";

		String username = "root";

		String password = "root";
		
		String getallemployeesquery = "Select * from employees";
		
		String insertEmployee = "insert into employees values(105,'Vijay Diwan','Cloud Enginner',55000),(106,'Mahesh Jadhav','Legal',50000)";
		
		
// DEPRICATED PRACTISE
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("Driver loaded Successfully");
//		}catch (ClassNotFoundException e) {	
//			System.out.println(e.getMessage());
//		}
		
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			
			System.out.println("Connected to database");
			Statement statement=connection.createStatement();
			statement.executeUpdate(insertEmployee);
			ResultSet resultset=statement.executeQuery(getallemployeesquery);
			
			
			
			System.out.println();
			System.out.println("List of all Employees from database ");
			System.out.println("+------+-----------------+---------------------+-------------+");
			System.out.println("|  id  |    Name         |    Job_Tittle       |   Salary    |");
			System.out.println("+------+-----------------+---------------------+-------------+");			
			
			while(resultset.next()) {
				int id=resultset.getInt("id");
				String name=resultset.getString("name");
				String job_tittle=resultset.getString("job_tittle");
				double salary= resultset.getDouble("salary");
				
				
				System.out.print("|  "+id+" |"+name);
				
				int nsp=17- (name.length());
				for(int i=1;i<=nsp;i++) {
					System.out.print(" ");
				}
				System.out.print("|"+job_tittle);
				
				
				int jsp=21- (job_tittle.length());
				for(int i=1;i<=jsp;i++) {
					System.out.print(" ");
				}
				System.out.print("|"+salary+"      |");
				
				//              "+salary);

				System.out.println();
			}
			System.out.println("+------+-----------------+---------------------+-------------+");
			
			resultset.close();
			statement.close();
			connection.close();
			System.out.println();
			System.out.println("Connection closed successfully...");
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		

	}

}
