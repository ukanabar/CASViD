/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date; 

/**
 *
 * @author Utkarsh
 */
public class Vm {
    
    private int vmId;
    
    private int customerId;  
  
    private String vmName;  
  
    private String vmDesc;
    
    private String firstName;  
  
    private String lastName; 
    
    private int port;
    
    private String macAddress;
    
    private String ip;
    
    private String host;
    
    private Date createdDate;
  
      
    public int getVmId() {  
  
        return vmId;  
  
    }  
  
    public void setVmId(int vmId) {  
  
        this.vmId = vmId;  
  
    }  
    
    
    
    public int getCustomerId() {  
  
        return customerId;  
  
    }  
  
    public void setCustomerId(int customerId) {  
  
        this.customerId = customerId;  
  
    }  
  
    public String getVmName() {  
  
        return vmName;  
  
    }  
  
    public void setVmName(String vmName) {  
  
        this.vmName = vmName;  
  
    } 
    
    public String getVmDesc() {  
  
        return vmDesc;  
  
    }  
  
    public void setVmDesc(String vmDesc) {  
  
        this.vmDesc = vmDesc;  
  
    }
    
     public String getFirstName() {  
  
        return firstName;  
  
    }  
  
    public void setFirstName(String firstName) {  
  
        this.firstName = firstName;  
  
    } 
    
    public String getLastName() {  
  
        return lastName;  
  
    }  
  
    public void setLastName(String lastName) {  
  
        this.lastName = lastName;  
  
    }
    
    public int getPort() {  
  
        return port;  
  
    }  
  
    public void setPort(int port) {  
  
        this.port = port;  
  
    }  
    
    public void setHost(String host){
        this.host = host;
    }
    
    public String getHost(){
        return host;
    }
  
    public String getMacAddress() {  
  
        return macAddress;  
  
    }  
  
    public void setMacAddress(String macAddress) {  
  
        this.macAddress = macAddress;  
  
    }  
  
    public String getIp() {  
  
        return ip; 
  
    }  
  
    public void setIp(String ip) {  
  
        this.ip = ip;  
  
    }   
   
    public Date getCreatedDate() {  
  
        return createdDate; 
  
    }  
  
    public void setCreatedDate(Date createdDate) {  
  
        this.createdDate = createdDate;  
  
    }   
   
  
  
    @Override  
  
    public String toString() {  
  
        return "Vm [vmId="+ vmId +",customerId=" + customerId + ", vmName=" + vmName  
  
                + ", vmDesc=" + vmDesc + ",port="+ port +", macAddress=" + macAddress+ ", ip=" + ip + "host="+ host +", createdDate=" + createdDate + "]";  
  
    }     
    
    
}
