<%@include file="header.jsp" %> 
<script language="javascript" src="./scripts/user.js"></script>  
<div class="top-bar">

<h1><c:choose>
      <c:when test="${action=='insert'}">Add      
      </c:when>
      <c:otherwise>Update      
      </c:otherwise>
    </c:choose>
 User</h1>
<!--<div class="breadcrumbs"><a href="#">Homepage</a> / <a href="#">Contents</a></div>-->
</div>
<div class="select-bar">

</div>
<div class="table">
        <form method="POST" action='UserController' name="frmAddUser" id="frmAddUser">  
            <input type="hidden" name="action" value="add/edit" />
      <table class="listing form" cellpadding="0" cellspacing="0">
                        <tr>
                            <th class="full" colspan="2"><c:choose>
      <c:when test="${action=='insert'}">Add      
      </c:when>
      <c:otherwise>Update      
      </c:otherwise>
    </c:choose> User</th>
                        </tr>
  <tr>
    <td class="spec">User Name:</th>
    <td><input type="hidden" name="userId"  
      
                value="<c:out value="${user.userId}" />" /> <input  
      
                type="text" name="userName" id="userName"
      
                value="<c:out value="${user.userName}" />" />  </td>
  </tr>
  <tr>
    <td class="spec">Password :</th>
    <td><input  
      
                type="password" name="password"  id="password"
      
                /> </td>
  </tr>
  <tr>
    <td class="spec">Confirm Password:</th>
    <td><input  
      
                type="password" name="cpassword" id="cpassword" 
      
                /> </td>
  </tr>
  <tr>
    <td class="spec">Email :</th>
    <td><input  
      
                type="text" name="email"  id="email"
      
                value="<c:out value="${user.email}" />" /></td>
  </tr>
  <tr>
    <td class="spec">Role :</th>
    <td> <select name="role"><option value="admin" <c:if test="${user.role=='admin'}">selected="selected"</c:if>>Admin</option>
               <option value="user" <c:if test="${user.role=='user'}">selected="selected"</c:if>>User</option></select>
      </td>
  </tr>
  <tr>
    <td colspan="2" class="spec"><input  
      
                type="submit" <c:choose>
      <c:when test="${action=='insert'}">value='Add'</c:when>
      <c:otherwise>value='Update'</c:otherwise></c:choose>  class="button"/>  </td>
    
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