<%-- 
    Document   : listVm
    Created on : Oct 9, 2012, 12:57:28 AM
    Author     : Utkarsh
--%>

<%@include file="header.jsp" %> 
<div class="top-bar">
                    <a href="VmController?action=insert&customerId=<c:out value="${intCustId}"/>" class="button">ADD NEW VIRTUAL MACHINE</a>
                    <h1>VIRTUAL MACHINEs</h1>
                    
</div>
<div class="select-bar">
                    <label>
                        <input type="text" name="textfield" />
                    </label>
                    <label>
                        <input type="submit" name="Submit" value="Search" class="button"/>
                    </label>
</div>


   
      
   
       <div class="table">  
      
        <table class="listing" cellpadding="0" cellspacing="0">  
      
             
      
                <tr>               
      
                    <th>Vm Name</th>  
      
                    <th>Vm Description</th>
                    
                    <th>Customer</th>
                    
                    <th>Vm Ip</th> 
                    
                    <th>Vm Host</th> 
                    
                    <th>Vm Port</th> 
                    
                    <th>Vm Mac Address</th>             
                    
                    <th colspan="2" scope="col">Action</th>  
      
                </tr>  
       
      
             
      
                <c:forEach items="${vms}" var="vm">  
      
                    <tr>      
                        
                    <td><c:out value="${vm.vmName}" /></td>  
      
                    <td><c:out value="${vm.vmDesc}" /></td>
                    
                    <td><c:out value="${vm.firstName}" /> <c:out value="${vm.lastName}" /></td>
                    
                    <td><c:out value="${vm.ip}" /></td> 
                    
                    <td><c:out value="${vm.host}" /></td> 
                    
                    <td><c:out value="${vm.port}" /></td> 
                    
                    <td><c:out value="${vm.macAddress}" /></td>   
      
                        <td class="style1"><a href="VmController?action=edit&customerId=<c:out value="${intCustId}"/>&vmId=<c:out value="${vm.vmId}"/>"><img src="./images/edit-icon.gif" width="16" height="16" alt="" /><br />Update</a></td>  
      
                        <td class="style1"><a href="VmController?action=delete&customerId=<c:out value="${intCustId}"/>&vmId=<c:out value="${vm.vmId}"/>"><img src="./images/hr.gif" width="16" height="16" alt="" /><br />Delete</a></td>  
      
                    </tr>  
      
                </c:forEach>  
      
            <tr><td colspan="9" align="right"><div class="select">
                        <strong>Other Pages: </strong>
                        <select>
                            <option>1</option>
                        </select>
                    </div></td></tr>
      
        </table> 
        
                </div>
                <div class="table">
                    
                </div>
            </div>
            <div id="right-column">
                <strong class="h">Quick Info</strong>
                <div class="box">This is your admin home page. It will give you access to all things within the back end system that you will need to facilitate a smooth operation.</div>
            </div>
      
        
      
         
      
    <%@include file="footer.jsp" %>  