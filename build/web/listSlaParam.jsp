<%@include file="header.jsp" %>

<div class="top-bar">
                    <a href="SlaParamController?action=insert" class="button">ADD NEW SLA Parameter</a>
                    <h1>SLA Parameters</h1>
                    
</div>
<form action="SlaParamController" method="post">
<div class="select-bar">
                    <label>
                         <input type="text" name="search" />
                        <input type="hidden" name="action" value="search" />
                    </label>
                    <label>
                        <input type="submit" name="Submit" value="Search" class="button"/>
                    </label>
</div>
</form>

   
      
   
       <div class="table">
        <table class="listing" cellpadding="0" cellspacing="0">  
      
           
      
                <tr>               
      
                    <th>SLA Parameter Name</th>  
      
                    <th>SLA Parameter Unit</th>
                    
                    <th>SLA Parameter Description</th>
      
                    <th colspan=2>Action</th>  
      
                </tr>  
                
                <c:choose>
               <c:when test="${error!='sucess'}">
                   <tr><td colspan="5" align="right" >${error}</td></tr>
               </c:when>
               <c:otherwise>              
      
                <c:forEach items="${slaParams}" var="slaParam">  
      
                    <tr>      
                        
                        <td class="style1"><c:out value="${slaParam.slaParamName}" /></td>  
      
                        <td class="style1"><c:out value="${slaParam.slaParamUnit}" /></td>
                        
                        <td class="style1"><c:out value="${slaParam.slaParamDesc}" /></td> 
      
                        <td class="style1"><a href="SlaParamController?action=edit&slaParamId=<c:out value="${slaParam.slaParamId}"/>"><img src="./images/edit-icon.gif" width="16" height="16" alt="" /><br />Update</a></td>  
      
                        <td class="style1"><a href="SlaParamController?action=delete&slaParamId=<c:out value="${slaParam.slaParamId}"/>"><img src="./images/hr.gif" width="16" height="16" alt="" /><br />Delete</a></td>  
      
                    </tr>  
      
                </c:forEach>  
               </c:otherwise>
               </c:choose>
            <!--<tr><td colspan="5" align="right"><div class="select">
                        <strong>Other Pages: </strong>
                        <select>
                            <option>1</option>
                        </select>
                    </div></td></tr>-->
      
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