package com.bridge.crude.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bridge.crude.model.Employee;


public class ConnectionDao {
	/**
	 * @return connection
	 */
	public static Connection connection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/program1", "root", "101023");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @param e
	 * @return
	 */
	public static int save(Employee e) {
		int status = 0;
		Connection connection = ConnectionDao.connection();
		PreparedStatement preparedStatement = null;
		
		try {
		//	String query="insert into program1.employee values(?,?,?)"
			preparedStatement = connection.prepareStatement("insert into employee values(?,?,?)");
			preparedStatement.setInt(1, e.getEmpId());
			preparedStatement.setString(2, e.getEmpName());
			preparedStatement.setString(3, e.getEmpEmail());
			status = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return status;
	}

	/**
	 * @param id
	 * @return
	 */
	public static int delete(int id) {
		int status = 0;
		Connection connection = ConnectionDao.connection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from program1.employee where empId=?");
			preparedStatement.setInt(1, id);
			status = preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}

	/**
	 * @param emp
	 * @return
	 */
	public static int update(Employee emp, int id) {
		int status = 0;
		Connection connection = ConnectionDao.connection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update program1.employee set empId=?,empName=?,empEmail=? where empId=?");
			preparedStatement.setInt(1, emp.getEmpId());
			preparedStatement.setString(2, emp.getEmpName());
			preparedStatement.setString(3, emp.getEmpEmail());
			preparedStatement.setInt(4, id);
			status = preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}

	/**
	 * @param id
	 * @return
	 */
	public static Employee getEmployee(int id) {
		Employee emp = new Employee();
		int status = 0;
		Connection connection = ConnectionDao.connection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("select * from program1.employee where empId=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				emp.setEmpId(resultSet.getInt(1));
				emp.setEmpName(resultSet.getString(2));
				emp.setEmpEmail(resultSet.getString(3));
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;

	}
	public static java.util.List<Employee> getAllEmp()
	{
		java.util.List<Employee> list=new ArrayList<Employee>();
		Connection connection=ConnectionDao.connection();
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement("select * from program.employee");
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) 
			{
				Employee emp=new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpEmail(rs.getString(3));
				list.add(emp);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
