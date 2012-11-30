/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ApplicationDao;
import dao.CustomerDao;
import dao.SlaDao;
import dao.SlaParamDao;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date; 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Sla;

/**
 *
 * @author Utkarsh
 */
public class SlaController extends HttpServlet{
    
    private static final long serialVersionUID = 1L;  
  
    private static String INSERT_OR_EDIT = "/sla.jsp";  
  
    private static String LIST_SLA = "/listSla.jsp";  
  
    private SlaDao dao;
    
    private CustomerDao daoCustomer;
    
    private ApplicationDao daoApplication;
    
    private SlaParamDao daoSlaParam;
  
  
  
    public SlaController() {  
  
        super();        
        dao = new SlaDao();
        daoCustomer = new CustomerDao();
        daoApplication = new ApplicationDao();
        daoSlaParam   = new SlaParamDao();  
        
  
    }
  
  
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
        String forward="";  
  
        String action = request.getParameter("action"); 
        
        int intVmId = Integer.parseInt(request.getParameter("vmId"));
        request.setAttribute("intVmId",intVmId);
        request.setAttribute("strLink","customer");  
        
        request.setAttribute("action",action);
        request.setAttribute("Application", daoApplication.getAllApplications(""));
        request.setAttribute("Slaparam", daoSlaParam.getAllSlaParams(""));
        
        if (action.equalsIgnoreCase("delete")){  
  
            int slaId = Integer.parseInt(request.getParameter("slaId"));  
  
            dao.deleteSla(slaId);  
  
            forward = LIST_SLA;  
  
            request.setAttribute("slas", dao.getAllSlas(intVmId));     
  
        } else if (action.equalsIgnoreCase("edit")){  
  
            forward = INSERT_OR_EDIT;  
  
            int slaId = Integer.parseInt(request.getParameter("slaId"));  
  
            Sla sla = dao.getSlaById(slaId);  
  
            request.setAttribute("sla", sla);  
  
        } else if (action.equalsIgnoreCase("listSla")){  
  
            forward = LIST_SLA;  
            
            
            
            
            request.setAttribute("slas",dao.getAllSlas(intVmId)); 
            
  
        } else {  
  
            forward = INSERT_OR_EDIT;  
  
        }  
  
  
  
        RequestDispatcher view = request.getRequestDispatcher(forward);  
  
        view.forward(request, response);  
  
    }  
  
  
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
        Sla sla = new Sla();  
        Date expDate = null;
                
        int intVmId = Integer.parseInt(request.getParameter("vmId"));
        request.setAttribute("intVmId",intVmId);
         
        sla.setApplicationId(Integer.parseInt(request.getParameter("appId")));  
        
        sla.setSlaParamId(Integer.parseInt(request.getParameter("slaParamId")));       
        
        sla.setVmId(intVmId);
        
        sla.setThreatValue(request.getParameter("threatValue"));        
        
        sla.setViolationValue(request.getParameter("violationValue")); 
        
        sla.setSlaType(request.getParameter("slaType")); 
        
        PrintWriter out = response.getWriter();
        
        
        
        try {  
  
            expDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("expDate"));  
  
            sla.setExpiryDate(expDate);  
  
        } catch (ParseException e) {  
  
            e.printStackTrace();  
  
        }  
               
        String slaId = request.getParameter("slaId");  
  
        if(slaId == null || slaId.isEmpty())  
  
        {  
  
            dao.addSla(sla);  
  
        }  
  
        else  
  
        {  
  
            sla.setSlaId(Integer.parseInt(slaId));  
  
            dao.updateSla(sla);  
  
        }  
  
        RequestDispatcher view = request.getRequestDispatcher(LIST_SLA);  
  
        request.setAttribute("slas", dao.getAllSlas(intVmId));  
  
        view.forward(request, response); 
  
    }  
    
    
}
