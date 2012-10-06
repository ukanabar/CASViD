/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.SlaParamDao;
import java.io.*;  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SlaParam;

/**
 *
 * @author Utkarsh
 */
public class SlaParamController extends HttpServlet {
    private static final long serialVersionUID = 1L;  
  
    private static String INSERT_OR_EDIT = "/slaParam.jsp";  
  
    private static String LIST_SLAPARAM = "/listSlaParam.jsp";  
  
    private SlaParamDao dao;  
  
  
  
    public SlaParamController() {  
  
        super();        
        dao = new SlaParamDao();
  
    }
  
  
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
        String forward="";  
  
        String action = request.getParameter("action");  
        
        request.setAttribute("strLink","slaparam");
        
        request.setAttribute("action",action);
        if (action.equalsIgnoreCase("delete")){  
  
            int slaParamId = Integer.parseInt(request.getParameter("slaParamId"));  
  
            dao.deleteSlaParam(slaParamId);  
  
            forward = LIST_SLAPARAM;  
  
            request.setAttribute("slaParams", dao.getAllSlaParams());     
  
        } else if (action.equalsIgnoreCase("edit")){  
  
            forward = INSERT_OR_EDIT;  
  
            int slaParamId = Integer.parseInt(request.getParameter("slaParamId"));  
  
            SlaParam slaParam = dao.getSlaParamById(slaParamId);  
  
            request.setAttribute("slaParam", slaParam);  
  
        } else if (action.equalsIgnoreCase("listSlaParam")){  
  
            forward = LIST_SLAPARAM;  
  
            request.setAttribute("slaParams", dao.getAllSlaParams());  
  
        } else {  
  
            forward = INSERT_OR_EDIT;  
  
        }  
  
  
  
        RequestDispatcher view = request.getRequestDispatcher(forward);  
  
        view.forward(request, response);  
  
    }  
  
  
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
        SlaParam slaParam = new SlaParam();  
  
        slaParam.setSlaParamName(request.getParameter("slaParamName"));  
  
        slaParam.setSlaParamUnit(request.getParameter("slaParamUnit")); 
        
        slaParam.setSlaParamDesc(request.getParameter("slaParamDesc")); 
          
  
        String slaParamId = request.getParameter("slaParamId");  
  
        if(slaParamId == null || slaParamId.isEmpty())  
  
        {  
  
            dao.addSlaParam(slaParam);  
  
        }  
  
        else  
  
        {  
  
            slaParam.setSlaParamId(Integer.parseInt(slaParamId));  
  
            dao.updateSlaParam(slaParam);  
  
        }  
  
        RequestDispatcher view = request.getRequestDispatcher(LIST_SLAPARAM);  
  
        request.setAttribute("slaParams", dao.getAllSlaParams());  
  
        view.forward(request, response);  
  
    }  
    
    
}
