package com.ba.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ba.DBConnect;
import com.ba.model.Customer;
	

public class CustomerController extends DBConnect {
	
	Connection con=null;
	
	PreparedStatement ps=null;
	
	ResultSet rs=null;
	
	
	public List<Customer> findAll() throws SQLException{
		try {
			String sql="Select * from customerdb.Customers";
			
			List<Customer> findAll=new ArrayList<>();
			con=serverConnect();
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Customer cst=new Customer(rs.getInt(1),
						rs.getNString(2),rs.getNString(3),rs.getNString(4),rs.getNString(5)
						,rs.getNString(6));
			
				findAll.add(cst);
				
			}
	
			
			return findAll;
			
		}catch(SQLException e) {
			Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE,null,e);
			return null;
		}
		finally{
			rs.close();
			ps.close();
			con.close();
		}
		
	}
	
	
	public Customer findById(int id) throws SQLException {
		
		
		try {
			
			String sql="Select * from customerdb.Customers where id="+id+"";
			
			Customer customer=null;
			
			con=serverConnect();
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				customer=new Customer(rs.getInt(1),rs.getString(2),rs.getNString(3),rs.getNString(4),rs.getNString(5)
						,rs.getNString(6));
				
				
			}
			
			return customer;
		}catch(SQLException e) {
			Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE,null,e);
			return null;
		}
		finally{
			rs.close();
			ps.close();
			con.close();
		}
		
	}
	
	public Boolean create(Customer customer) throws SQLException {
		
		
		try {
			
			String sql="insert into customerdb.Customers values(null,?,?,?,?,?)";
			
			boolean result=false;
			
						
			con=serverConnect();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getCity());
			ps.setString(4, customer.getAddress());
			ps.setString(5, customer.getPhoneNumber());

			
			if(ps.executeUpdate()==1) {
				
				result=true;
			}
			
			return result;
		}catch(SQLException e) {
			Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE,null,e);
			return false;
		}
		finally{
			ps.close();
			con.close();
		}
		
	}
	
	public Boolean update(Customer customer) throws SQLException {
		
		
		try {
			
			String sql="UPDATE customerdb.Customers  SET name=?, lastname=?, city=?, address=?, phoneNumber=? where id=?";
			
			boolean result=false;
			
						
			con=serverConnect();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getCity());
			ps.setString(4, customer.getAddress());
			ps.setString(5, customer.getPhoneNumber());
			ps.setInt(6, customer.getId());
			
			if(ps.executeUpdate()==1) {
				
				result=true;
			}
			
			return result;
		}catch(SQLException e) {
			Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE,null,e);
			return false;
		}
		finally{
			ps.close();
			con.close();
		}
		
	}
	
	public Boolean delete(int id) throws SQLException {
		
		
		try {
			
			String sql="Delete from customerdb.Customers where id= "+id+"";
			
			boolean result=false;
			
						
			con=serverConnect();
			ps=con.prepareStatement(sql);
			
		
			
			if(ps.executeUpdate()==1) {
				
				result=true;
			}
			
			return result;
		}catch(SQLException e) {
			Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE,null,e);
			return false;
		}
		finally{
			ps.close();
			con.close();
		}
		
	}
	
	
	
	
	
	

}
