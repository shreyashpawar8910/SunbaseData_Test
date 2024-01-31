package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.CustomerEntity;
import com.mysql.cj.xdevapi.Result;

public class CustomerDao {
	private Connection conn;

	public CustomerDao(Connection conn) {
		super();
		this.conn = conn;
	}
		
	
	//*****************************************
	//******** DAO For INsert Customer ********
	//*****************************************
	
	public boolean InsertCustomer(CustomerEntity cust) {

		boolean temp = false;

		try {

			String sql = "insert into crudeapplication.customer (first_name, last_name, street, address, city, state, email, phone ) "
					+ "values(?,?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, cust.getFirstName());
			ps.setString(2, cust.getLastName());
			ps.setString(3, cust.getStreet());
			ps.setString(4, cust.getAddress());
			ps.setString(5, cust.getCity());
			ps.setString(6, cust.getState());
			ps.setString(7, cust.getEmail());
			ps.setString(8, cust.getPhone());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				temp = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return temp;
	}

	
	

	//*****************************************
	//******** DAO For Display Customer ********
	//*****************************************
	
	
	public List<CustomerEntity> DisplayCustomer(){
		
		List<CustomerEntity> list = new ArrayList<CustomerEntity>();
		CustomerEntity cust = null;
		
		try {
			String sql = "select * from crudeapplication.customer order by id asc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cust = new CustomerEntity();
				cust.setId(rs.getString(1));
				cust.setFirstName(rs.getString(2));
				cust.setLastName(rs.getString(3));
				cust.setStreet(rs.getString(4));
				cust.setAddress(rs.getString(5));
				cust.setCity(rs.getString(6));
				cust.setState(rs.getString(7));
				cust.setEmail(rs.getString(8));
				cust.setPhone(rs.getString(9));
				
				list.add(cust);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	

	//*****************************************
	//******** DAO For Update Customer ********
	//*****************************************
	
	
	public boolean UpdateCustomer(CustomerEntity cust) {
		
		boolean temp = false;
		
		try {
			
			String sql = "update crudeapplication.customer set first_name=?, last_name=?, street=?, address=?, city=?, state=?, email=?, phone=? where id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, cust.getFirstName());
			ps.setString(2, cust.getLastName());
			ps.setString(3, cust.getStreet());
			ps.setString(4, cust.getAddress());
			ps.setString(5, cust.getCity());
			ps.setString(6, cust.getState());
			ps.setString(7, cust.getEmail());
			ps.setString(8, cust.getPhone());
			ps.setString(9, cust.getId());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				temp=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return temp;
	}
	
	
	
		//*****************************************
		//******** DAO For Delete Customer ********
		//*****************************************
	
	
	public boolean DeleteCustomer(CustomerEntity cust) {
		
		boolean temp = false;
		
		try {
			
			String sql = "delete from crudeapplication.customer where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, cust.getId());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				temp = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	
	
		//*****************************************
		//******** DAO For Display Customer ********
		//*****************************************
		
		
		public List<CustomerEntity> SearchCustomer(String tableName, String content){
			
			List<CustomerEntity> list = new ArrayList<CustomerEntity>();
			CustomerEntity cust = null;
		
			try {
				
				System.out.println("Table Name : "+tableName);
				System.out.println("Content : "+content);
				
				if(tableName.equals("firstname")) {
					
					
					
					String sql = "select * from crudeapplication.customer where first_name LIKE '%"+content+"'";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						cust = new CustomerEntity();
						
						cust.setId(rs.getString(1));
						cust.setFirstName(rs.getString(2));
						cust.setLastName(rs.getString(3));
						cust.setStreet(rs.getString(4));
						cust.setAddress(rs.getString(5));
						cust.setCity(rs.getString(6));
						cust.setState(rs.getString(7));
						cust.setEmail(rs.getString(8));
						cust.setPhone(rs.getString(9));
						
						list.add(cust);						
					}
					
				}else if (tableName.equals("city")) {
					String sql = "select * from crudeapplication.customer where city LIKE '%"+content+"'";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					
					System.out.println("Hello");
					
					while(rs.next()) {
						
						cust = new CustomerEntity();
						
						cust.setId(rs.getString(1));
						cust.setFirstName(rs.getString(2));
						cust.setLastName(rs.getString(3));
						cust.setStreet(rs.getString(4));
						cust.setAddress(rs.getString(5));
						cust.setCity(rs.getString(6));
						cust.setState(rs.getString(7));
						cust.setEmail(rs.getString(8));
						cust.setPhone(rs.getString(9));
						
						list.add(cust);						
					}
				}else if (tableName.equals("email")) {
					String sql = "select * from crudeapplication.customer where email LIKE '%"+content+"'";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					
					System.out.println("Hello Email");
					
					while(rs.next()) {
						
						cust = new CustomerEntity();
						
						cust.setId(rs.getString(1));
						cust.setFirstName(rs.getString(2));
						cust.setLastName(rs.getString(3));
						cust.setStreet(rs.getString(4));
						cust.setAddress(rs.getString(5));
						cust.setCity(rs.getString(6));
						cust.setState(rs.getString(7));
						cust.setEmail(rs.getString(8));
						cust.setPhone(rs.getString(9));
						
						list.add(cust);						
					}
				}else if (tableName.equals("phone")) {
					String sql = "select * from crudeapplication.customer where phone LIKE '%"+content+"'";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					
					System.out.println("Hello");
					
					while(rs.next()) {
						
						cust = new CustomerEntity();
						
						cust.setId(rs.getString(1));
						cust.setFirstName(rs.getString(2));
						cust.setLastName(rs.getString(3));
						cust.setStreet(rs.getString(4));
						cust.setAddress(rs.getString(5));
						cust.setCity(rs.getString(6));
						cust.setState(rs.getString(7));
						cust.setEmail(rs.getString(8));
						cust.setPhone(rs.getString(9));
						
						list.add(cust);						
					}
				}					
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return list;
		}
	
	
}
