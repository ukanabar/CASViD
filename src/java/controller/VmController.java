/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.VmDao;
import java.io.*;  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vm;

/**
 *
 * @author Utkarsh
 */
public class VmController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;  
  
    private static String INSERT_OR_EDIT = "/vm.jsp";  
  
    private static String LIST_VM = "/listVm.jsp";  
  
    private VmDao dao;  
  
  
  
    public VmController() {  
  
        super();        
        dao = new VmDao();
  
    }
  
  
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
        String forward="";  
        
        String action = request.getParameter("action");
        
        int intCustId = Integer.parseInt(request.getParameter("customerId"));
        request.setAttribute("intCustId",intCustId);
        request.setAttribute("strLink","customer");  
        
        request.setAttribute("action",action);
        if (action.equalsIgnoreCase("delete")){  
  
            int vmId = Integer.parseInt(request.getParameter("vmId"));  
  
            dao.deleteVm(vmId);  
  
            forward = LIST_VM;  
  
            request.setAttribute("vms", dao.getAllVms(intCustId));     
  
        } else if (action.equalsIgnoreCase("edit")){  
  
            forward = INSERT_OR_EDIT;  
  
            int vmId = Integer.parseInt(request.getParameter("vmId"));  
  
            Vm vm = dao.getVmById(vmId);  
  
            request.setAttribute("vm", vm);  
  
        } else if (action.equalsIgnoreCase("listVm")){  
  
            forward = LIST_VM;  
  
            request.setAttribute("vms", dao.getAllVms(intCustId));  
  
        } else {  
  
            forward = INSERT_OR_EDIT;  
  
        }  
  
  
  
        RequestDispatcher view = request.getRequestDispatcher(forward);  
  
        view.forward(request, response);  
  
    }  
  
  
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
        int intCustId = Integer.parseInt(request.getParameter("customerId"));
        
        request.setAttribute("intCustId",intCustId);
        
        Vm vm = new Vm();  
  
        vm.setVmName(request.getParameter("vmName"));  
  
        vm.setVmDesc(request.getParameter("vmDesc"));
        
        vm.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
        
        vm.setPort(Integer.parseInt(request.getParameter("port"))); 
        
        vm.setMacAddress(request.getParameter("macaddress"));
        
        vm.setIp(request.getParameter("ip")); 
        
        vm.setHost(request.getParameter("hostname"));
  
        String vmId = request.getParameter("vmId");  
  
        if(vmId == null || vmId.isEmpty())  
  
        {  
  
            dao.addVm(vm);  
  
        }  
  
        else  
  
        {  
  
            vm.setVmId(Integer.parseInt(vmId));  
  
            dao.updateVm(vm);  
  
        }  
  
        RequestDispatcher view = request.getRequestDispatcher(LIST_VM);  
  
        request.setAttribute("vms", dao.getAllVms(intCustId));  
  
        view.forward(request, response);  
  
    }  
    
   
}
