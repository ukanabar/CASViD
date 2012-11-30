/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ConfigDao;
import java.io.*;  
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Config;


/**
 *
 * @author Utkarsh
 */
public class ConfigController  extends HttpServlet {
    private static final long serialVersionUID = 1L;  
  
    private static String INSERT_OR_EDIT = "/config.jsp";  
  
    private static String LIST_CONFIG = "/listConfig.jsp";  
  
    private ConfigDao dao;  
  
  
  
    public ConfigController() {  
  
        super();        
        dao = new ConfigDao();
  
    }
  
  
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
        String forward="";  
  
        String action = request.getParameter("action");  
        
        request.setAttribute("strLink","config"); 
        
        String error = "sucess";
        
        request.setAttribute("action",action);
        if (action.equalsIgnoreCase("delete")){  
  
            int configId = Integer.parseInt(request.getParameter("configId"));  
  
            dao.deleteConfig(configId);  
  
            forward = LIST_CONFIG;  
  
            request.setAttribute("configs", dao.getAllConfigs(""));     
  
        } else if (action.equalsIgnoreCase("edit")){  
  
            forward = INSERT_OR_EDIT;  
  
            int configId = Integer.parseInt(request.getParameter("configId"));  
  
            Config config = dao.getConfigById(configId);  
  
            request.setAttribute("config", config);  
  
        } else if (action.equalsIgnoreCase("listConfig")){  
  
            forward = LIST_CONFIG;  
  
            request.setAttribute("configs", dao.getAllConfigs(""));  
  
        } else {  
  
            forward = INSERT_OR_EDIT;  
  
        }  
  
  
        request.setAttribute("error",error);
        
        RequestDispatcher view = request.getRequestDispatcher(forward);  
  
        view.forward(request, response);  
  
    }  
  
  
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
        Config config = new Config();  
        
        request.setAttribute("strLink","config"); 
        
        String error = "sucess";
        
        String search = request.getParameter("search");
        
        String action = request.getParameter("action");
        
            if(action.equalsIgnoreCase("search")){
                
                List<Config> configs = new ArrayList<Config>();  
                configs = dao.getAllConfigs(search);


                if(!configs.isEmpty()){
                    request.setAttribute("configs",configs);
                }else {
                    error = "No Configs found!";
                }


            } else {

                config.setConfigParamName(request.getParameter("paramName"));  

                config.setConfigParamValue(request.getParameter("paramValue"));        


                String configId = request.getParameter("configId");  

                if(configId == null || configId.isEmpty())  

                {  

                    dao.addConfig(config);  

                }  

                else  

                {  

                    config.setConfigId(Integer.parseInt(configId));  

                    dao.updateConfig(config);  

                }
                
                request.setAttribute("configs", dao.getAllConfigs(""));

            }
            
            request.setAttribute("error",error);

            RequestDispatcher view = request.getRequestDispatcher(LIST_CONFIG);               

            view.forward(request, response);  

          
        
    }
    
    
}
