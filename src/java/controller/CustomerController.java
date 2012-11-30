/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDao;
import java.io.*;  
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;

/**
 *
 * @author Utkarsh
 */
public class CustomerController  extends HttpServlet {
    private static final long serialVersionUID = 1L;  
  
    private static String INSERT_OR_EDIT = "/customer.jsp";  
  
    private static String LIST_CUSTOMER = "/listCustomer.jsp";  
  
    private CustomerDao dao;  
  
  
  
    public CustomerController() {  
  
        super();        
        dao = new CustomerDao();
  
    }
  
  
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
        String forward="";  
        
        String action = request.getParameter("action");
        String error = "sucess";
        
        request.setAttribute("strLink","customer"); 
        
        request.setAttribute("action",action);
        if (action.equalsIgnoreCase("delete")){  
  
            int customerId = Integer.parseInt(request.getParameter("customerId"));  
  
            dao.deleteCustomer(customerId);  
  
            forward = LIST_CUSTOMER;  
  
            request.setAttribute("customers", dao.getAllCustomers(""));     
  
        } else if (action.equalsIgnoreCase("edit")){  
  
            forward = INSERT_OR_EDIT;  
  
            int customerId = Integer.parseInt(request.getParameter("customerId"));  
  
            Customer customer = dao.getCustomerById(customerId);  
  
            request.setAttribute("customer", customer);  
  
        } else if (action.equalsIgnoreCase("listCustomer")){  
  
            forward = LIST_CUSTOMER;  
  
            request.setAttribute("customers", dao.getAllCustomers(""));  
  
        } else {  
  
            forward = INSERT_OR_EDIT;  
  
        }  
  
  
        request.setAttribute("error",error);
        
        RequestDispatcher view = request.getRequestDispatcher(forward);  
  
        view.forward(request, response);  
  
    }  
  
  
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
        Customer customer = new Customer();
        
        request.setAttribute("strLink","customer"); 
        
        String action = request.getParameter("action");
        String search = request.getParameter("search");
        String error = "sucess";
        
        
        if(action.equalsIgnoreCase("search")){
            List<Customer> customers = new ArrayList<Customer>();  
            customers = dao.getAllCustomers(search);
            
            
            if(!customers.isEmpty()){
                request.setAttribute("customers",customers);
            }else {
                error = "No Customer found!";
            }
            
            
        } else {
        
            request.setAttribute("strLink","customer"); 

            customer.setFirstName(request.getParameter("firstName"));  

            customer.setLastName(request.getParameter("lastName"));        

            customer.setEmail(request.getParameter("email")); 

            String customerId = request.getParameter("customerId");  

            if(customerId == null || customerId.isEmpty())  

            {  

                dao.addCustomer(customer);  

            }  

            else  

            {  

                customer.setCustomerId(Integer.parseInt(customerId));  

                dao.updateCustomer(customer);  

            }             
            
            request.setAttribute("customers", dao.getAllCustomers("")); 
         }
        request.setAttribute("error",error);
        RequestDispatcher view = request.getRequestDispatcher(LIST_CUSTOMER); 
        view.forward(request, response); 
  
    }  
    
    
}
