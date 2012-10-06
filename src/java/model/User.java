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
public class User {
    
    private int userId;  
  
    private String userName;  
  
    private String userPassword; 
    
    private String email;
    
    private String role;
    
    private boolean active;
    
    private Date createdDate;
  
      
  
    public int getUserId() {  
  
        return userId;  
  
    }  
  
    public void setUserId(int userId) {  
  
        this.userId = userId;  
  
    }  
  
    public String getUserName() {  
  
        return userName;  
  
    }  
  
    public void setUserName(String userName) {  
  
        this.userName = userName;  
  
    } 
    
    public String getUserPassword() {  
  
        return userPassword;  
  
    }  
  
    public void setUserPassword(String userPassword) {  
  
        this.userPassword = userPassword;  
  
    }      
    
  
    public String getEmail() {  
  
        return email;  
  
    }  
  
    public void setEmail(String email) {  
  
        this.email = email;  
  
    }  
  
    public String getRole() {  
  
        return role; 
  
    }  
  
    public void setRole(String role) {  
  
        this.role = role;  
  
    }   
   
    public Date getCreatedDate() {  
  
        return createdDate; 
  
    }  
  
    public void setCreatedDate(Date createdDate) {  
  
        this.createdDate = createdDate;  
  
    }
    
   public boolean isActive(){
       
       return active;
   }
   
   
   public void setActive(boolean active){
       this.active = active;
   
   }
  
  
    @Override  
  
    public String toString() {  
  
        return "User [userId=" + userId + ", userName=" + userName  
  
                + ", userPassword=" + userPassword + ", email=" + email+ ", role=" + role + ", createdDate=" + createdDate + ",active=" + active + "]";  
  
    } 
    
}
