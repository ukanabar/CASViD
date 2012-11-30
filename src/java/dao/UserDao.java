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
import model.User;
import util.DbUtil;

/**
 *
 * @author Utkarsh
 */
public class UserDao {
    
    private Connection connection;  
  
  
  
    
    public UserDao() {  
  
        connection = DbUtil.getConnection();      
        
  
    }  
  
  
  
    public void addUser(User user) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("insert into casvid_users (user_name,user_password,user_email,user_role,user_createddate,user_modifieddate) values (?, ?, ?, ?,now(),now())");  
  
            preparedStatement.setString(1, user.getUserName());  
  
            preparedStatement.setString(2, user.getUserPassword());
            
            preparedStatement.setString(3, user.getEmail());
            
            preparedStatement.setString(4, user.getRole());
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void deleteUser(int userId) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("delete from casvid_users where user_id=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setInt(1, userId);  
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void updateUser(User user) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("update casvid_users set user_name=?,user_password=?,user_email=?,user_role=?,user_modifieddate=now()" +  
  
                            "where user_id=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setString(1, user.getUserName());  
  
            preparedStatement.setString(2, user.getUserPassword());
      
            preparedStatement.setString(3,user.getEmail());  
            
            preparedStatement.setString(4, user.getRole());
      
            preparedStatement.setInt(5, user.getUserId());  
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
  
  
    public List<User> getAllUsers(String search) {  
  
        List<User> users = new ArrayList<User>();  
  
        try {  
  
            Statement statement = connection.createStatement();
            
            String strSql = "select * from casvid_users";
            
            if(!search.isEmpty()){
                strSql = strSql + " where user_name like'%" +search+"%' or user_email like'%"+search+"%'";
            }
            
            ResultSet rs = statement.executeQuery(strSql);
  
            
  
            while (rs.next()) {  
  
                User user = new User();  
  
                user.setUserId(rs.getInt("user_id"));                  
  
                user.setUserName(rs.getString("user_name"));                 
                
                user.setUserPassword(rs.getString("user_password"));
                
                user.setEmail(rs.getString("user_email"));
                
                user.setRole(rs.getString("user_role"));
                
                user.setCreatedDate(rs.getDate("user_createddate"));
                
                users.add(user);  
  
            }  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return users;  
  
    }  
  
  
  
    public User getUserById(int userId) {  
  
        User user = new User();  
  
        try {  
  
            PreparedStatement preparedStatement = connection.  
  
                    prepareStatement("select * from casvid_users where user_id =?");  
  
            preparedStatement.setInt(1, userId);  
  
            ResultSet rs = preparedStatement.executeQuery();  
  
  
  
            if (rs.next()) {  
  
                user.setUserId(rs.getInt("user_id"));                  
  
                user.setUserName(rs.getString("user_name"));                 
                
                user.setUserPassword(rs.getString("user_password"));
                
                user.setEmail(rs.getString("user_email"));
                
                user.setRole(rs.getString("user_role"));
                
                user.setCreatedDate(rs.getDate("user_createddate"));
                
                user.setCreatedDate(rs.getDate("user_modifieddate")); 
  
            }  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return user;  
  
    }  
    
    public User validateUser(String strUserName,String strPassword) {  
  
        User user = new User();  
  
        try {  
  
            PreparedStatement preparedStatement = connection.  
  
                    prepareStatement("select user_id,user_name,user_email,user_role from casvid_users where user_name =? AND user_password=?");  
  
            preparedStatement.setString(1, strUserName);  
            
            preparedStatement.setString(2, strPassword);
  
            ResultSet rs = preparedStatement.executeQuery();
            
            boolean blnCheck = rs.next();
  
            if (!blnCheck) {  
                
                    user.setActive(false);
                        
                
               } else {
                
                    user.setUserId(rs.getInt("user_id"));                  

                    user.setUserName(rs.getString("user_name"));           

                    user.setEmail(rs.getString("user_email"));

                    user.setRole(rs.getString("user_role"));
                    
                    user.setActive(true);
                
              }  
            
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
        return user;
         
  
    }  
}
