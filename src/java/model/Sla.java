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
public class Sla {
    
    private int slaId;
    
    private int applicationId;
    
    private String applicationName;
    
    private int slaParamId;
    
    private String slaParamName;  
    
    private int customerId;
    
    private String customerName;
  
    private String threatValue;  
  
    private String violationValue; 
    
    private String slaType;
    
    private Date expiryDate;
     
    private Date createdDate;
  
      
  
    public int getSlaId() {  
  
        return slaId;  
  
    }  
  
    public void setSlaId(int slaId) {  
  
        this.slaId = slaId;  
  
    }  
  
    public int getApplicationId() {  
  
        return applicationId;  
  
    }  
  
    public void setApplicationId(int applicationId) {  
  
        this.applicationId = applicationId;  
  
    } 
    
     public String getApplicationName() {  
  
        return applicationName;  
  
    }  
  
    public void setApplicationName(String applicationName) {  
  
        this.applicationName = applicationName;  
  
    } 
    
    public int getSlaParamId() {  
  
        return slaParamId;  
  
    }  
  
    public void setSlaParamId(int slaParamId) {  
  
        this.slaParamId = slaParamId;  
  
    } 
    
    public String getSlaParamName() {  
  
        return slaParamName;  
  
    }  
  
    public void setSlaParamName(String slaParamName) {  
  
        this.slaParamName = slaParamName;  
  
    } 
    
    public int getCustomerId() {  
  
        return customerId;  
  
    }  
  
    public void setCustomerId(int customerId) {  
  
        this.customerId = customerId;  
  
    } 
    
    public String getCustomerName() {  
  
        return customerName;  
  
    }  
  
    public void setCustomerName(String customerName) {  
  
        this.customerName = customerName;  
  
    } 
    
   
   public String getSlaType() {  
  
        return slaType;  
  
    }  
  
    public void setSlaType(String slaType) {  
  
        this.slaType = slaType;  
  
    }  
  
    public String getThreatValue() {  
  
        return threatValue; 
  
    }  
  
    public void setThreatValue(String threatValue) {  
  
        this.threatValue = threatValue;  
  
    }
    
    public String getViolationValue() {  
  
        return violationValue; 
  
    }  
  
    public void setViolationValue(String violationValue) {  
  
        this.violationValue = violationValue;  
  
    }   
   
    public Date getCreatedDate() {  
  
        return createdDate; 
  
    }  
  
    public void setCreatedDate(Date createdDate) {  
  
        this.createdDate = createdDate;  
  
    }   
   
    
    public Date getExpiryDate() {  
  
        return expiryDate; 
  
    }  
  
    public void setExpiryDate(Date expiryDate) {  
  
        this.expiryDate = expiryDate;  
  
    }   
   
  
  
    @Override  
  
    public String toString() {  
  
        return "Sla [slaId=" + slaId + ", applicationId=" + applicationId  + ", applicationName=" + applicationName 
  
                + ", slaParamId=" + slaParamId  + ", slaParamName=" + slaParamName + ", customerId=" + customerId 
                
                + ", customerName=" + customerName + ", threatValue=" + threatValue + ", violationValue=" + violationValue 
                
                + ", slaType=" + slaType + ", expiryDate=" + expiryDate + ", createdDate=" + createdDate + "]";  
  
    }     
    
}
