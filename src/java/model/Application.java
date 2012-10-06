/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Utkarsh
 */
public class Application {
    
   private int applicationId;  
  
    private String applicationName;  
  
    private String applicationDesc;  
  
      
  
    public int getApplicationId() {  
  
        return applicationId;  
  
    }  
  
    public void setApplicationId(int applicationId) {  
  
        this.applicationId = applicationId;  
  
    }  
  
    public String getApplicationName() {  
  
        return applicationName;  
  
    }  
  
    public void setApplicatioName(String applicationName) {  
  
        this.applicationName = applicationName;  
  
    }  
  
    public String getApplicationDesc() {  
  
        return applicationDesc;  
  
    }  
  
    public void setApplicationDesc(String applicationDesc) {  
  
        this.applicationDesc = applicationDesc;  
  
    }  
  
   
  
  
    @Override  
  
    public String toString() {  
  
        return "Application [applicationId=" + applicationId + ", applicationName=" + applicationName  
  
                + ", applicationDesc=" + applicationDesc + "]";  
  
    }      
}
