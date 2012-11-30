<%@include file="header.jsp" %>   
<div class="top-bar">
                    <a href="ConfigController?action=insert" class="button">ADD NEW Configuration Value</a>
                    <h1>Configuration Values</h1>
                    
</div>
<form action="ConfigController" method="post">
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
      
                    <th>Config ParamName</th>  
      
                    <th>Config ParamValue</th>                      
      
                    <th colspan=2>Action</th>  
      
                </tr>  
                <c:choose>
               <c:when test="${error!='sucess'}">
                   <tr><td colspan="4" align="right" >${error}</td></tr>
               </c:when>
               <c:otherwise>  
            
      
                <c:forEach items="${configs}" var="config">  
      
                    <tr>      
                        
                        <td class="style1"><c:out value="${config.configParamName}" /></td>  
      
                        <td class="style1"><c:out value="${config.configParamValue}" /></td>                        
      
                        <td class="style1"><img src="./images/edit-icon.gif" width="16" height="16" alt="" /><br /><a href="ConfigController?action=edit&configId=<c:out value="${config.configId}"/>">Update</a></td>  
      
                        <td class="style1"><img src="./images/hr.gif" width="16" height="16" alt="" /><br /><a href="ConfigController?action=delete&configId=<c:out value="${config.configId}"/>">Delete</a></td>  
      
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