/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Vm;
import util.DbUtil;

/**
 *
 * @author Utkarsh
 */
public class VmDao {
    
    private Connection connection;  
  
  
  
    
    public VmDao() {  
  
        connection = DbUtil.getConnection();      
        
  
    }  
  
  
  
    public void addVm(Vm vm) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("insert into casvid_vms (cust_id,vm_name,vm_desc,vm_ip,vm_host,vm_port,vm_macaddress,vm_createddate,vm_modifieddate) values (?, ?, ?, ?, ?, ?, ?,now(),now())");  
  
            preparedStatement.setInt(1, vm.getCustomerId());  
  
            preparedStatement.setString(2, vm.getVmName());
            
            preparedStatement.setString(3, vm.getVmDesc());
            
            preparedStatement.setString(4, vm.getIp());
            
            preparedStatement.setString(5, vm.getHost());
            
            preparedStatement.setInt(6, vm.getPort());
            
            preparedStatement.setString(7, vm.getMacAddress());    
            
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void deleteVm(int vmId) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("delete from casvid_vms where vm_id=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setInt(1, vmId);  
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
    public void updateVm(Vm vm) {  
  
        try {  
  
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement("update casvid_vms set cust_id=?,vm_name=?,vm_desc=?,vm_ip=?,vm_host=?,vm_port=?,vm_macaddress=?,vm_modifieddate=now()" +  
  
                            "where vm_id=?");  
  
            // Parameters start with 1  
  
            preparedStatement.setInt(1, vm.getCustomerId());  
  
            preparedStatement.setString(2, vm.getVmName());
            
            preparedStatement.setString(3, vm.getVmDesc());
            
            preparedStatement.setString(4, vm.getIp());
            
            preparedStatement.setString(5, vm.getHost());
            
            preparedStatement.setInt(6, vm.getPort());
            
            preparedStatement.setString(7, vm.getMacAddress());
            
            preparedStatement.setInt(8,vm.getVmId()); 
  
            preparedStatement.executeUpdate();  
  
  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
    }  
  
  
  
  
  
    public List<Vm> getAllVms(int intCustId,String search) {  
  
        List<Vm> vms = new ArrayList<Vm>();  
  
        try {  
            
            String strSql = "select cv.*,cc.cust_firstname,cc.cust_lastname from casvid_vms cv,casvid_customers cc where cv.cust_id=cc.cust_id and cv.cust_id=?";
            
            if(!search.isEmpty()){
                strSql = strSql + " where vm_name like'%" +search+"%'";
            }
            
            PreparedStatement preparedStatement = connection  
  
                    .prepareStatement(strSql);  
            preparedStatement.setInt(1,intCustId);  
            ResultSet rs = preparedStatement.executeQuery();  
  
            while (rs.next()) {  
  
                Vm vm = new Vm();  
  
                vm.setVmId(rs.getInt("vm_id"));                  
  
                vm.setVmName(rs.getString("vm_name"));                 
                
                vm.setCustomerId(rs.getInt("cust_id"));
                
                vm.setVmDesc(rs.getString("vm_desc"));
                
                vm.setIp(rs.getString("vm_ip"));
                
                vm.setHost(rs.getString("vm_host")); 
                
                vm.setMacAddress(rs.getString("vm_macaddress"));
                
                vm.setPort(rs.getInt("vm_port"));
                
                vm.setCreatedDate(rs.getDate("vm_createddate"));
                
                vm.setFirstName(rs.getString("cust_firstname"));
                
                vm.setLastName(rs.getString("cust_lastname"));
                
                vms.add(vm);  
  
            }  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return vms;  
  
    }  
  
  
  
    public Vm getVmById(int vmId) {  
  
        Vm vm = new Vm();  
  
        try {  
  
            PreparedStatement preparedStatement = connection.  
  
                    prepareStatement("select * from casvid_vms where vm_id =?");  
  
            preparedStatement.setInt(1, vmId);  
  
            ResultSet rs = preparedStatement.executeQuery();  
  
  
  
            if (rs.next()) {  
  
                vm.setVmId(rs.getInt("vm_id"));                  
  
                vm.setVmName(rs.getString("vm_name"));                 
                
                vm.setCustomerId(rs.getInt("cust_id"));
                
                vm.setVmDesc(rs.getString("vm_desc"));
                
                vm.setIp(rs.getString("vm_ip"));
                
                vm.setHost(rs.getString("vm_host")); 
                
                vm.setMacAddress(rs.getString("vm_macaddress"));
                
                vm.setPort(rs.getInt("vm_port"));
                
                vm.setCreatedDate(rs.getDate("vm_createddate"));
                
  
            }  
  
        } catch (SQLException e) {  
  
            e.printStackTrace();  
  
        }  
  
  
  
        return vm;  
  
    }  
      
    
}
