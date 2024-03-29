/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.ApplicationDao;
import java.io.*;  
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Application;

/**
 *
 * @author Utkarsh
 */
public class ApplicationController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;  
  
    private static String INSERT_OR_EDIT = "/application.jsp";  
  
    private static String LIST_APPLICATION = "/listApplication.jsp";  
  
    private ApplicationDao dao;  
  
  
  
    public ApplicationController() {  
  
        super();        
        dao = new ApplicationDao();
  
    }
  
  
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
        String forward="";  
  
        String action = request.getParameter("action");  
        
        request.setAttribute("strLink","app"); 
        
        request.setAttribute("action",action);
        
        String error = "sucess";
         
        if (action.equalsIgnoreCase("delete")){  
  
            int applicationId = Integer.parseInt(request.getParameter("applicationId"));  
  
            dao.deleteApplication(applicationId);  
  
            forward = LIST_APPLICATION;  
  
            request.setAttribute("applications", dao.getAllApplications(""));     
  
        } else if (action.equalsIgnoreCase("edit")){  
  
            forward = INSERT_OR_EDIT;  
  
            int applicationId = Integer.parseInt(request.getParameter("applicationId"));  
  
            Application application = dao.getApplicationById(applicationId);  
  
            request.setAttribute("application", application);  
  
        } else if (action.equalsIgnoreCase("listApplication")){  
  
            forward = LIST_APPLICATION;  
  
            request.setAttribute("applications", dao.getAllApplications(""));  
  
        } else {  
  
            forward = INSERT_OR_EDIT;  
  
        }  
  
  
        request.setAttribute("error",error);
        
        RequestDispatcher view = request.getRequestDispatcher(forward);  
  
        view.forward(request, response);  
  
    }  
  
  
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
        Application application = new Application();  
        
        request.setAttribute("strLink","app");
        
        String error = "sucess";
        
        String search = request.getParameter("search");
        
        String action = request.getParameter("action");
        
            if(action.equalsIgnoreCase("search")){
                
                List<Application> applications = new ArrayList<Application>();  
                applications = dao.getAllApplications(search);


                if(!applications.isEmpty()){
                    request.setAttribute("applications",applications);
                }else {
                    error = "No Applications found!";
                }


            } else {
  
        application.setApplicatioName(request.getParameter("appName"));  
  
        application.setApplicationDesc(request.getParameter("appDesc"));        
          
  
        String applicationId = request.getParameter("applicationId");  
  
        if(applicationId == null || applicationId.isEmpty())  
  
        {  
  
            dao.addApplication(application);  
  
        }  
  
        else  
  
        {  
  
            application.setApplicationId(Integer.parseInt(applicationId));  
  
            dao.updateApplication(application);  
  
        }  
        
            request.setAttribute("applications", dao.getAllApplications(""));  
        
        }
  
        request.setAttribute("error",error);
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_APPLICATION);       
  
        view.forward(request, response);  
  
    }  
}
