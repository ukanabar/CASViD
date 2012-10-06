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
import model.Sla;
import util.DbUtil;

/**
 *
 * @author Utkarsh
 */
public class SlaDao {
    
    private Connection connection;  
  
  
  
    
    public SlaDao() {  
  
        connection = DbUtil.getConnection();      
        
  
    }  
  
  
  
    public void addSla(Sla sla) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("insert into casvid_slas (app_id,slaparam_id,sla_threatvalue,sla_violationvalue,cust_id,sla_type,sla_createddate,sla_modifieddate,sla_expirydate) values (?, ?, ?, ?, ?, ?,now(),now(), ?)");  
  
            preparedStatement.setInt(1, sla.getApplicationId());  
  
            preparedStatement.setInt(2, sla.getSlaParamId());
            
            preparedStatement.setString(3, sla.getThreatValue());
            
            preparedStatement.setString(4, sla.getViolationValue());
            
            preparedStatement.setInt(5, sla.getCustomerId());
            
            preparedStatement.setString(6, sla.getSlaType());
            
            preparedStatement.setDate(7, new java.sql.Date(sla.getExpiryDate().getTime()));        
            
            
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void deleteSla(int slaId) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("delete from casvid_slas where sla_id=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setInt(1, slaId);  
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void updateSla(Sla sla) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("update casvid_slas set app_id=?,slaparam_id=?,sla_threatvalue=?,sla_violationvalue=?,cust_id=?,sla_type=?,sla_modifieddate=now(),sla_expirydate=?" +  
  
                            "where sla_id=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setInt(1, sla.getApplicationId());  
  
            preparedStatement.setInt(2, sla.getSlaParamId());
            
            preparedStatement.setString(3, sla.getThreatValue());
            
            preparedStatement.setString(4, sla.getViolationValue());
            
            preparedStatement.setInt(5, sla.getCustomerId());
            
            preparedStatement.setString(6, sla.getSlaType());
            
            preparedStatement.setDate(7, new java.sql.Date(sla.getExpiryDate().getTime()));
            
            preparedStatement.setInt(8,sla.getSlaId());
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
  
  
    public List<Sla> getAllSlas() {  
  
        List<Sla> slas = new ArrayList<Sla>();  
  
        try {  
  
            Statement statement = connection.createStatement();  
  
            ResultSet rs = statement.executeQuery("select cs.sla_id,cs.app_id,cs.slaparam_id,cs.cust_id,cs.sla_type,cs.sla_threatvalue,cs.sla_violationvalue,cs.sla_createddate,cs.sla_expirydate,ca.app_name,cc.cust_firstname,cc.cust_lastname,csp.slaparam_name,csp.slaparam_unit from casvid_slas cs,casvid_applications ca,casvid_customers cc,casvid_slaparameters csp where cs.cust_id=cc.cust_id and cs.app_id=ca.app_id and cs.slaparam_id=csp.slaparam_id");  
  
            while (rs.next()) {  
  
                Sla sla = new Sla();  
  
                sla.setSlaId(rs.getInt("sla_id"));
                
                sla.setApplicationId(rs.getInt("app_id"));
                
                sla.setApplicationName(rs.getString("app_name"));
                
                sla.setSlaParamId(rs.getInt("slaparam_id"));
                
                sla.setSlaParamName(rs.getString("slaparam_name"));
                
                sla.setCustomerId(rs.getInt("cust_id")); 
                
                sla.setCustomerName(rs.getString("cust_firstname")+" "+rs.getString("cust_lastname"));
  
                sla.setThreatValue(rs.getString("sla_threatvalue"));                 
                
                sla.setViolationValue(rs.getString("sla_violationvalue"));
                
                sla.setSlaType(rs.getString("sla_type"));               
                
                sla.setCreatedDate(rs.getDate("sla_createddate"));
                
                sla.setExpiryDate(rs.getDate("sla_expirydate"));
                
                slas.add(sla);  
  
            }  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return slas;  
  
    }  
  
  
  
    public Sla getSlaById(int slaId) {  
  
        Sla sla = new Sla();  
  
        try {  
  
            PreparedStatement preparedStatement = connection.  
  
                    prepareStatement("select cs.sla_id,cs.app_id,cs.slaparam_id,cs.cust_id,cs.sla_type,cs.sla_threatvalue,cs.sla_violationvalue,cs.sla_createddate,cs.sla_expirydate,ca.app_name,cc.cust_firstname,cc.cust_lastname,csp.slaparam_name,csp.slaparam_unit from casvid_slas cs,casvid_applications ca,casvid_customers cc,casvid_slaparameters csp where cs.cust_id=cc.cust_id and cs.app_id=ca.app_id and cs.slaparam_id=csp.slaparam_id and cs.sla_id =?");  
  
            preparedStatement.setInt(1, slaId);  
  
            ResultSet rs = preparedStatement.executeQuery();  
  
  
  
            if (rs.next()) {  
  
                sla.setSlaId(rs.getInt("sla_id"));
                
                sla.setApplicationId(rs.getInt("app_id"));
                
                sla.setApplicationName(rs.getString("app_name"));
                
                sla.setSlaParamId(rs.getInt("slaparam_id"));
                
                sla.setSlaParamName("slaparam_name");
                
                sla.setCustomerId(rs.getInt("cust_id")); 
                
                sla.setCustomerName(rs.getString("cust_firstname")+" "+rs.getString("cust_lastname"));
  
                sla.setThreatValue(rs.getString("sla_threatvalue"));                 
                
                sla.setViolationValue(rs.getString("sla_violationvalue"));
                
                sla.setSlaType(rs.getString("sla_type"));               
                
                sla.setCreatedDate(rs.getDate("sla_createddate"));
                
                sla.setExpiryDate(rs.getDate("sla_expirydate"));
  
            }  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return sla;  
  
    }  
    
}
