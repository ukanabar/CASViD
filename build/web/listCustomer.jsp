<%@include file="header.jsp" %>

<div class="top-bar">
                    <a href="CustomerController?action=insert" class="button">ADD NEW CUSTOMER</a>
                    <h1>Customers</h1>
                    
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
      
                    <th>First Name</th>  
      
                    <th>Last Name</th>
                    
                    <th>Email</th>  
      
                    <th>Created Date</th>                    
      
                    <th colspan="3">Action</th>  
      
                </tr>  
      
            
      
                <c:forEach items="${customers}" var="customer">  
      
                    <tr>      
                        
                        <td class="style1"><c:out value="${customer.firstName}" /></td>  
      
                        <td class="style1"><c:out value="${customer.lastName}" /></td>                        
                        
                        <td class="style1"><c:out value="${customer.email}" /></td>  
      
                        <td class="style1"><c:out value="${customer.createdDate}" /></td>                          
      
                        <td class="style1"><a href="CustomerController?action=edit&customerId=<c:out value="${customer.customerId}"/>"><img src="./images/edit-icon.gif" width="16" height="16" alt="Update" />Update</a></td>  
      
                        <td class="style1"><a href="CustomerController?action=delete&customerId=<c:out value="${customer.customerId}"/>"><img src="./images/hr.gif" width="16" height="16" alt="Delete" />Delete</a></td>  
                        
                        <td class="style1"><a href="VmController?action=listvm&customerId=<c:out value="${customer.customerId}"/>"><img src="./images/vm.png" width="16" height="16" alt="VMs" />VMs</a></td>  
      
                          
      
                    </tr>  
      
                </c:forEach>  
      
           
        <tr><td colspan="8" align="right"><div class="select">
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
                <div class="box">This is your admin home page. </div>
            </div>
      
       
      
    <%@include file="footer.jsp" %>  