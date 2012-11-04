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
public class Customer {
    
    private int customerId;  
  
    private String firstName;  
  
    private String lastName; 
    
    private String email;
    
    private Date createdDate;
  
      
  
    public int getCustomerId() {  
  
        return customerId;  
  
    }  
  
    public void setCustomerId(int customerId) {  
  
        this.customerId = customerId;  
  
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
       
  
    public String getEmail() {  
  
        return email;  
  
    }  
  
    public void setEmail(String email) {  
  
        this.email = email;  
  
    }     
   
    public Date getCreatedDate() {  
  
        return createdDate; 
  
    }  
  
    public void setCreatedDate(Date createdDate) {  
  
        this.createdDate = createdDate;  
  
    }   
   
  
  
    @Override  
  
    public String toString() {  
  
        return "Customer [customerId=" + customerId + ", firstName=" + firstName  
  
                + ", lastName=" + lastName + ", email=" + email+ ", createdDate=" + createdDate + "]";  
  
    }     
    
}
