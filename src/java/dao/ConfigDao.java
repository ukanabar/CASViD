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
import model.Config;
import util.DbUtil;

/**
 *
 * @author Utkarsh
 */
public class ConfigDao {
    
    private Connection connection;  
  
  
  
    
    public ConfigDao() {  
  
        connection = DbUtil.getConnection();      
        
  
    }  
  
  
  
    public void addConfig(Config config) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("insert into casvid_config(config_paramname,config_paramvalue) values (?, ?)");  
  
            
  
            preparedStatement.setString(1, config.getConfigParamName());  
  
            preparedStatement.setString(2, config.getConfigParamValue());            
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void deleteConfig(int configId) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("delete from casvid_config where config_id=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setInt(1, configId);  
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void updateConfig(Config config) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("update casvid_config set config_paramname=?, config_paramvalue=?" +  
  
                            "where config_id=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setString(1, config.getConfigParamName());  
  
            preparedStatement.setString(2, config.getConfigParamValue());
      
            preparedStatement.setInt(3, config.getConfigId());  
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
  
  
    public List<Config> getAllConfigs() {  
  
        List<Config> configs = new ArrayList<Config>();  
  
        try {  
  
            Statement statement = connection.createStatement();  
  
            ResultSet rs = statement.executeQuery("select * from casvid_config");  
  
            while (rs.next()) {  
  
                Config config = new Config();  
  
                config.setConfigId(rs.getInt("config_id"));  
  
                config.setConfigParamName(rs.getString("config_paramname"));  
  
                config.setConfigParamValue(rs.getString("config_paramvalue"));                 
  
                configs.add(config);  
  
            }  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return configs;  
  
    }  
  
  
  
    public Config getConfigById(int configId) {  
  
        Config config = new Config();  
  
        try {  
  
            PreparedStatement preparedStatement = connection.  
  
                    prepareStatement("select *  from casvid_config where config_id =?");  
  
            preparedStatement.setInt(1, configId);  
  
            ResultSet rs = preparedStatement.executeQuery();  
  
  
  
            if (rs.next()) {  
  
                config.setConfigId(rs.getInt("config_id"));  
  
                config.setConfigParamName(rs.getString("config_paramname"));  
  
                config.setConfigParamValue(rs.getString("config_paramvalue"));  
  
            }  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return config;  
  
    }  
  
}  
    

