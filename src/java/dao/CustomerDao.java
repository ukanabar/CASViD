/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import util.DbUtil;

/**
 *
 * @author Utkarsh
 */
public class CustomerDao {
     private Connection connection;  
  
  
  
    
    public CustomerDao() {  
  
        connection = DbUtil.getConnection();      
        
  
    }  
  
  
  
    public void addCustomer(Customer customer) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("insert into casvid_customers (cust_firstname,cust_lastname,cust_email,cust_createddate,cust_modifieddate) values (?, ?, ?,now(),now())");  
  
            preparedStatement.setString(1, customer.getFirstName());  
  
            preparedStatement.setString(2, customer.getLastName());
            
            preparedStatement.setString(3, customer.getEmail());
            
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void deleteCustomer(int customerId) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("delete from casvid_customers where cust_id=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setInt(1, customerId);  
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void updateCustomer(Customer customer) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("update casvid_customers set cust_firstname=?,cust_lastname=?,cust_email=?,cust_modifieddate=now()" +  
  
                            "where cust_id=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setString(1, customer.getFirstName());  
  
            preparedStatement.setString(2, customer.getLastName());
      
            preparedStatement.setString(3,customer.getEmail());             
           
            preparedStatement.setInt(4, customer.getCustomerId());  
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
  
  
    public List<Customer> getAllCustomers(String search) {  
  
        List<Customer> customers = new ArrayList<Customer>();  
  
        try {  
  
            Statement statement = connection.createStatement();  
            
            String strSql = "select * from casvid_customers";
            
            if(!search.isEmpty()){
                strSql = strSql + " where cust_firstname like'%" +search+"%' or cust_lastname like'%"+search+"%'";
            }
            
            ResultSet rs = statement.executeQuery(strSql);  
  
            while (rs.next()) {  
  
                Customer customer = new Customer();  
  
                customer.setCustomerId(rs.getInt("cust_id"));                  
  
                customer.setFirstName(rs.getString("cust_firstname"));                 
                
                customer.setLastName(rs.getString("cust_lastname"));
                
                customer.setEmail(rs.getString("cust_email"));                
                
                customer.setCreatedDate(rs.getDate("cust_createddate"));
                
                customers.add(customer);  
  
            }  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return customers;  
  
    }  
  
  
  
    public Customer getCustomerById(int customerId) {  
  
        Customer customer = new Customer();  
  
        try {  
  
            PreparedStatement preparedStatement = connection.  
  
                    prepareStatement("select * from casvid_customers where cust_id =?");  
  
            preparedStatement.setInt(1, customerId);  
  
            ResultSet rs = preparedStatement.executeQuery();  
  
  
  
            if (rs.next()) {  
  
                customer.setCustomerId(rs.getInt("cust_id"));                  
  
                customer.setFirstName(rs.getString("cust_firstname"));                 
                
                customer.setLastName(rs.getString("cust_lastname"));
                
                customer.setEmail(rs.getString("cust_email"));
                
                customer.setCreatedDate(rs.getDate("cust_createddate")); 
  
            }  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return customer;  
  
    }  
}
