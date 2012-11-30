<%@include file="header.jsp" %> 
<div class="top-bar">
                    <a href="ApplicationController?action=insert" class="button">ADD NEW APPLICATION</a>
                    <h1>Applications</h1>
                    
</div>
<form action="ApplicationController" method="post">
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
      
                    <th>Application Name</th>  
      
                    <th>Application Description</th>                      
      
                    <th colspan="2" scope="col">Action</th>  
      
                </tr>  
       
                <c:choose>
               <c:when test="${error!='sucess'}">
                   <tr><td colspan="4" align="right" >${error}</td></tr>
               </c:when>
               <c:otherwise>  
             
      
                <c:forEach items="${applications}" var="application">  
      
                    <tr>      
                        
                        <td class="style1"><c:out value="${application.applicationName}" /></td>  
      
                        <td class="style1"><c:out value="${application.applicationDesc}" /></td>                        
      
                        <td class="style1"><a href="ApplicationController?action=edit&applicationId=<c:out value="${application.applicationId}"/>"><img src="./images/edit-icon.gif" width="16" height="16" alt="" /><br />Update</a></td>  
      
                        <td class="style1"><a href="ApplicationController?action=delete&applicationId=<c:out value="${application.applicationId}"/>"><img src="./images/hr.gif" width="16" height="16" alt="" /><br />Delete</a></td>  
      
                    </tr>  
      
                </c:forEach>  
      </c:otherwise>
               </c:choose>
            <!--<tr><td colspan="4" align="right"><div class="select">
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