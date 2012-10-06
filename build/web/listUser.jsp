<%@include file="header.jsp" %>

<div class="top-bar">
                    <a href="UserController?action=insert" class="button">ADD NEW USER</a>
                    <h1>Users</h1>
                    
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
      
                    <th>User Name</th>                   
                    
                    <th>Email</th>  
      
                    <th>Role</th> 
                    
                    <th>Created Date</th>                    
      
                    <th colspan=2>Action</th>  
      
                </tr>  
      
           
       
      
                <c:forEach items="${users}" var="user">  
      
                    <tr>      
                        
                        <td class="style1"><c:out value="${user.userName}" /></td>                                          
                        
                        <td class="style1"><c:out value="${user.email}" /></td>  
      
                        <td class="style1"><c:out value="${user.role}" /></td>                    
                        
                        <td class="style1"><c:out value="${user.createdDate}" /></td>                          
      
                        <td class="style1"><a href="UserController?action=edit&userId=<c:out value="${user.userId}"/>"><img src="./images/edit-icon.gif" width="16" height="16" alt="" /><br />Update</a></td>  
      
                        <td class="style1"><a href="UserController?action=delete&userId=<c:out value="${user.userId}"/>"><img src="./images/hr.gif" width="16" height="16" alt="" /><br />Delete</a></td>  
      
                    </tr>  
      
                </c:forEach>  
      
      <tr><td colspan="6" align="right"><div class="select">
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