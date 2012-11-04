<%@include file="header.jsp" %>   
      <script language="javascript" src="./scripts/customer.js"></script>

<div class="top-bar">

<h1><c:choose>
      <c:when test="${action=='insert'}">Add      
      </c:when>
      <c:otherwise>Update      
      </c:otherwise>
    </c:choose> Customer</h1>
<!--<div class="breadcrumbs"><a href="#">Homepage</a> / <a href="#">Contents</a></div>-->
</div>
<div class="select-bar">

</div>
<div class="table">
        <form method="POST" action='CustomerController' name="frmAddCustomer" id="frmAddCustomer">  
  
  
  <table class="listing form" cellpadding="0" cellspacing="0">
                        <tr>
                            <th class="full" colspan="2"><c:choose>
      <c:when test="${action=='insert'}">Add      
      </c:when>
      <c:otherwise>Update      
      </c:otherwise>
    </c:choose> Customer</th>
                        </tr>
  <tr>
    <td class="spec">First Name :</th>
    <td> <input  
      
                type="text" name="firstName"  id="firstName"
      
                value="<c:out value="${customer.firstName}" />" /> <input type="hidden" name="customerId"  
      
                value="<c:out value="${customer.customerId}" />" /></td>
     
  </tr>
  <tr>
    <td class="spec">Last Name :</th>
    <td>
             <input  
      
                type="text" name="lastName"  id="lastName"
      
                value="<c:out value="${customer.lastName}" />" /> </td>
  </tr>
  <tr>
    <td class="spec"> Email :</th>
    <td> <input  
      
                type="text" name="email"  id="email"
      
                value="<c:out value="${customer.email}" />" /> </td>
  </tr>
  <tr>
    <td colspan="2" class="style1">  <input  
      
                type="submit" <c:choose>
      <c:when test="${action=='insert'}">value='Add'</c:when>
      <c:otherwise>value='Update'</c:otherwise></c:choose> class="button"/>  </td>
    
  </tr>
</table>

             
      
      
              
      
      
            
          
           
           
      
            
   
      
        </form> 
         </div>
            </div>
            <div id="right-column">
                <strong class="h">Quick Info</strong>
                <div class="box">This is your admin home page. It will give you access to all things within the back end system that you will need to facilitate a smooth operation.</div>
            </div> 
      
    <%@include file="footer.jsp" %>  