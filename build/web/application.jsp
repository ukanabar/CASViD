<%@include file="header.jsp" %>
<script language="javascript" src="./scripts/application.js"></script>
<div class="top-bar">

<h1><c:choose>
      <c:when test="${action=='insert'}">Add      
      </c:when>
      <c:otherwise>Update      
      </c:otherwise>
    </c:choose> Application</h1>
<!--<div class="breadcrumbs"><a href="#">Homepage</a> / <a href="#">Contents</a></div>-->
</div>
<div class="select-bar">

</div>
<div class="table">
   
      
 <form method="POST" action='ApplicationController' name="frmAddApplication" id="frmAddApplication">
 <table class="listing form" cellpadding="0" cellspacing="0">
                        <tr>
                            <th class="full" colspan="2"><c:choose>
      <c:when test="${action=='insert'}">Add      
      </c:when>
      <c:otherwise>Update      
      </c:otherwise>
    </c:choose> Application</th>
                        </tr>
  <tr> 
    <td class="spec">Application Name :</th>
    <td><input type="hidden" name="applicationId" value="<c:out value="${application.applicationId}" />" />   
        <input type="text" name="appName" id="appName" value="<c:out value="${application.applicationName}" />" />   
    </td>
  </tr>
  <tr>
    <td class="spec"> Application Description:</th>
    <td><textarea name="appDesc" id="appDesc"><c:out value="${application.applicationDesc}" /></textarea>    
      </td>
  </tr>
  <tr>
    <td colspan="2" class="style1"><input type="submit" <c:choose>
      <c:when test="${action=='insert'}">value='Add'</c:when>
      <c:otherwise>value='Update'</c:otherwise></c:choose> class="button"/></td>
    
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