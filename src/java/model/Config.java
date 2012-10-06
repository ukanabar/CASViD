/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 *
 * @author Utkarsh
 */
public class Config {
    
    private int configId;  
  
    private String configParamName;  
  
    private String configParamValue;  
  
      
  
    public int getConfigId() {  
  
        return configId;  
  
    }  
  
    public void setConfigId(int configId) {  
  
        this.configId = configId;  
  
    }  
  
    public String getConfigParamName() {  
  
        return configParamName;  
  
    }  
  
    public void setConfigParamName(String configParamName) {  
  
        this.configParamName = configParamName;  
  
    }  
  
    public String getConfigParamValue() {  
  
        return configParamValue;  
  
    }  
  
    public void setConfigParamValue(String configParamValue) {  
  
        this.configParamValue = configParamValue;  
  
    }  
  
   
  
  
    @Override  
  
    public String toString() {  
  
        return "Config [configId=" + configId + ", configParamName=" + configParamName  
  
                + ", configParamValue=" + configParamValue + "]";  
  
    }     
    
}
