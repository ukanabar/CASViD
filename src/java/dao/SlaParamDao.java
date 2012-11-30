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
import model.SlaParam;
import util.DbUtil;

/**
 *
 * @author Utkarsh
 */
public class SlaParamDao {
    
     private Connection connection;  
  
  
  
    
    public SlaParamDao() {  
  
        connection = DbUtil.getConnection();      
        
  
    }  
  
  
  
    public void addSlaParam(SlaParam slaParam) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("insert into casvid_slaparameters(slaparam_name,slaparam_unit,slaparam_description) values (?, ?, ?)");  
  
            
  
            preparedStatement.setString(1, slaParam.getSlaParamName());  
  
            preparedStatement.setString(2, slaParam.getSlaParamUnit());   
            
            preparedStatement.setString(3, slaParam.getSlaParamDesc()); 
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void deleteSlaParam(int slaParamId) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("delete from casvid_slaparameters where slaparam_id=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setInt(1, slaParamId);  
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void updateSlaParam(SlaParam slaParam) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("update casvid_slaparameters set slaparam_name=?, slaparam_unit=?, slaparam_description=?" +  
  
                            "where slaparam_id=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setString(1, slaParam.getSlaParamName());  
  
            preparedStatement.setString(2, slaParam.getSlaParamUnit());
      
            preparedStatement.setString(3, slaParam.getSlaParamDesc());  
            
            preparedStatement.setInt(4, slaParam.getSlaParamId());  
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
  
  
    public List<SlaParam> getAllSlaParams(String search) {  
  
        List<SlaParam> slaParams = new ArrayList<SlaParam>();  
  
        try {  
  
            Statement statement = connection.createStatement(); 
            
            String strSql = "select * from casvid_slaparameters";
            
            if(!search.isEmpty()){
                strSql = strSql + " where slaparam_name like'%" +search+"%'";
            }
  
            ResultSet rs = statement.executeQuery(strSql);  
  
            while (rs.next()) {  
  
                SlaParam slaParam = new SlaParam();  
  
                slaParam.setSlaParamId(rs.getInt("slaparam_id"));  
  
                slaParam.setSlaParamName(rs.getString("slaparam_name"));  
  
                slaParam.setSlaParamUnit(rs.getString("slaparam_unit"));
                
                slaParam.setSlaParamDesc(rs.getString("slaparam_description"));
  
                slaParams.add(slaParam);  
  
            }  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return slaParams;  
  
    }  
  
  
  
    public SlaParam getSlaParamById(int slaParamId) {  
  
        SlaParam slaParam = new SlaParam();  
  
        try {  
  
            PreparedStatement preparedStatement = connection.  
  
                    prepareStatement("select *  from casvid_slaparameters where slaparam_id =?");  
  
            preparedStatement.setInt(1, slaParamId);  
  
            ResultSet rs = preparedStatement.executeQuery();  
  
  
  
            if (rs.next()) {  
  
                slaParam.setSlaParamId(rs.getInt("slaparam_id"));  
  
                slaParam.setSlaParamName(rs.getString("slaparam_name"));  
  
                slaParam.setSlaParamUnit(rs.getString("slaparam_unit"));
                
                slaParam.setSlaParamDesc(rs.getString("slaparam_description"));  
  
            }  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return slaParam;  
  
    }  
    
}
