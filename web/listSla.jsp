<%@include file="header.jsp" %>   
      
      <div class="top-bar">
                    <a href="SlaController?action=insert" class="button">ADD NEW SLA</a>
                    <h1>Service Level Agreements</h1>
                    
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
      
                    <th>Application</th>  
      
                    <th>SLA Parameter</th>
                    
                    <th>Threat Limit</th>  
      
                    <th>Threshold Limit</th> 
                    
                    <th>Customer</th>  
                    
                    <th>Created Date</th>  
                    
                     <th>Expiry Date</th> 
      
                    <th colspan=2>Action</th>  
      
                </tr>  
      
            
      
                <c:forEach items="${slas}" var="sla">  
      
                    <tr>      
                        
                        <td class="style1"><c:out value="${sla.applicationName}" /></td>  
      
                        <td class="style1"><c:out value="${sla.slaParamName}" /></td>                        
                        
                        <td class="style1"><c:out value="${sla.threatValue}" /></td>  
      
                        <td class="style1"><c:out value="${sla.violationValue}" /></td>                    
                        
                        <td class="style1"><c:out value="${sla.customerName}" /></td>  
                        
                         <td class="style1"><c:out value="${sla.createdDate}" /></td>
                        
                        <td class="style1"><c:out value="${sla.expiryDate}" /></td>  
                        
                        <td class="style1"><a href="SlaController?action=edit&slaId=<c:out value="${sla.slaId}"/>"><img src="./images/edit-icon.gif" width="16" height="16" alt="" /><br />Update</a></td>  
      
                        <td class="style1"><a href="SlaController?action=delete&slaId=<c:out value="${sla.slaId}"/>"><img src="./images/hr.gif" width="16" height="16" alt="" /><br />Delete</a></td>  
      
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