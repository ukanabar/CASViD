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
import model.Application;
import util.DbUtil;

/**
 *
 * @author Utkarsh
 */
public class ApplicationDao {
    
    private Connection connection;  
  
  
  
    
    public ApplicationDao() {  
  
        connection = DbUtil.getConnection();      
        
  
    }  
  
  
  
    public void addApplication(Application application) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("insert into casvid_applications(app_name,app_description) values (?, ?)");  
  
            
  
            preparedStatement.setString(1, application.getApplicationName());  
  
            preparedStatement.setString(2, application.getApplicationDesc());            
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void deleteApplication(int applicationId) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("delete from casvid_applications where app_id=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setInt(1, applicationId);  
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void updateApplication(Application application) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("update casvid_applications set app_name=?, app_description=?" +  
  
                            "where app_id=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setString(1, application.getApplicationName());  
  
            preparedStatement.setString(2, application.getApplicationDesc());
      
            preparedStatement.setInt(3, application.getApplicationId());  
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
  
  
    public List<Application> getAllApplications() {  
  
        List<Application> applications = new ArrayList<Application>();  
  
        try {  
  
            Statement statement = connection.createStatement();  
  
            ResultSet rs = statement.executeQuery("select * from casvid_applications");  
  
            while (rs.next()) {  
  
                Application application = new Application();  
  
                application.setApplicationId(rs.getInt("app_id"));  
  
                application.setApplicatioName(rs.getString("app_name"));  
  
                application.setApplicationDesc(rs.getString("app_description"));                 
  
                applications.add(application);  
  
            }  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return applications;  
  
    }  
  
  
  
    public Application getApplicationById(int applicationId) {  
  
        Application application = new Application();  
  
        try {  
  
            PreparedStatement preparedStatement = connection.  
  
                    prepareStatement("select *  from casvid_applications where app_id =?");  
  
            preparedStatement.setInt(1, applicationId);  
  
            ResultSet rs = preparedStatement.executeQuery();  
  
  
  
            if (rs.next()) {  
  
                application.setApplicationId(rs.getInt("app_id"));  
  
                application.setApplicatioName(rs.getString("app_name"));  
  
                application.setApplicationDesc(rs.getString("app_description"));  
  
            }  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return application;  
  
    }  
}
