/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.UserDao;
import java.io.*;  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Utkarsh
 */
public class UserController extends HttpServlet{
    
    private static final long serialVersionUID = 1L;  
  
    private static String INSERT_OR_EDIT = "/user.jsp";  
  
    private static String LIST_USER = "/listUser.jsp";
    
    private static String INDEX = "/index.jsp";
    
    private static String LIST_CUSTOMER = "CustomerController?action=listcustomer";
  
    private UserDao dao;  
  
  
  
    public UserController() {  
  
        super();        
        dao = new UserDao();
  
    }
  
  
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
        String forward="";  
  
        String action = request.getParameter("action");  
        
        request.setAttribute("strLink","user");
        
        request.setAttribute("action",action);
        
        HttpSession session = request.getSession();
        
        if (action.equalsIgnoreCase("delete")){  
  
            int userId = Integer.parseInt(request.getParameter("userId"));  
  
            dao.deleteUser(userId);  
  
            forward = LIST_USER;  
  
            request.setAttribute("users", dao.getAllUsers());     
  
        } else if (action.equalsIgnoreCase("edit")){  
  
            forward = INSERT_OR_EDIT;  
  
            int userId = Integer.parseInt(request.getParameter("userId"));  
  
            User user = dao.getUserById(userId);  
  
            request.setAttribute("user", user);  
  
        } else if (action.equalsIgnoreCase("listUser")){  
  
            forward = LIST_USER;  
  
            request.setAttribute("users", dao.getAllUsers());  
  
        } else if (action.equalsIgnoreCase("logout")){          
            
            forward = INDEX;
            session.invalidate(); 
  
        } else {  
  
            forward = INSERT_OR_EDIT;  
  
        }  
  
  
  
        RequestDispatcher view = request.getRequestDispatcher(forward);  
  
        view.forward(request, response);  
  
    }  
  
  
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
               
        request.setAttribute("strLink","user");
        
        String action = request.getParameter("action");
        
        
        User user = new User();
        
        String userName = request.getParameter("userName");
        
        String password = request.getParameter("password");       
          
        
  
        if(action.equalsIgnoreCase("login")){
            
            user = dao.validateUser(userName,password);     
            
            
            if(!user.isActive()){
                
                RequestDispatcher view = request.getRequestDispatcher(INDEX);  
  
                request.setAttribute("error","Invalid UserName or Password");  
  
                view.forward(request, response);
                
            } else {
                
                
                HttpSession session = request.getSession();
                
                session.setAttribute("userData",user);
                
                RequestDispatcher view = request.getRequestDispatcher(LIST_CUSTOMER);  
  
                request.setAttribute("userData",user);
                
                request.setAttribute("strLink","customer");
  
                view.forward(request, response);
                
                
            }
            
        } else { 
             
            user.setUserName(userName);

            user.setUserPassword(password);

            user.setEmail(request.getParameter("email")); 

            user.setRole(request.getParameter("role")); 

            String userId = request.getParameter("userId");  

            if(userId == null || userId.isEmpty())  

            {  

                dao.addUser(user);  

            }  

            else  

            {  

                user.setUserId(Integer.parseInt(userId));  

                dao.updateUser(user);  

            }  

            RequestDispatcher view = request.getRequestDispatcher(LIST_USER);  

            request.setAttribute("users", dao.getAllUsers());  

            view.forward(request, response);  
        
        }
  
    }  
}
