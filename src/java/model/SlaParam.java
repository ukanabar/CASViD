/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Utkarsh
 */
public class SlaParam {
    
    private int slaParamId;  
  
    private String slaParamName;  
  
    private String slaParamUnit;  
    
    private String slaParamDesc;  
      
  
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
  
    public String getSlaParamUnit() {  
  
        return slaParamUnit;  
  
    }  
  
    public void setSlaParamUnit(String slaParamUnit) {  
  
        this.slaParamUnit = slaParamUnit;  
  
    }  
    
    public String getSlaParamDesc() {  
  
        return slaParamDesc;  
  
    }  
  
    public void setSlaParamDesc(String slaParamDesc) {  
  
        this.slaParamDesc = slaParamDesc;  
  
    }  
  
   
  
  
    @Override  
  
    public String toString() {  
  
        return "SlaParam [slaParamId=" + slaParamId + ", slaParamName=" + slaParamName  
  
                + ", slaParamUnit=" + slaParamUnit + ", slaParamDesc=" + slaParamDesc  
  
                + "]";  
  
    }     
    
}
