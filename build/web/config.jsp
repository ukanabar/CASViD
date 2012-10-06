<%@include file="header.jsp" %> 
<script language="javascript" src="./scripts/config.js"></script>  
 <div class="top-bar">

<h1><c:choose>
      <c:when test="${action=='insert'}">Add      
      </c:when>
      <c:otherwise>Update      
      </c:otherwise>
    </c:choose> Configuration Value</h1>
<!--<div class="breadcrumbs"><a href="#">Homepage</a> / <a href="#">Contents</a></div>-->
</div>
<div class="select-bar">

</div>
<div class="table">     
        <form method="POST" action='ConfigController' name="frmAddConfig" id="frmAddConfig">  
        <table class="listing form" cellpadding="0" cellspacing="0">
                        <tr>
                            <th class="full" colspan="2"><c:choose>
      <c:when test="${action=='insert'}">Add      
      </c:when>
      <c:otherwise>Update      
      </c:otherwise>
    </c:choose> Configuration Value</th>
                        </tr>
  <tr>
    <td class="spec">Config Parameter Name : </th>
    <td><input type="hidden" name="configId"  
      
                value="<c:out value="${config.configId}" />" /> <input  
      
                type="text" name="paramName"  id"paramName"
      
                value="<c:out value="${config.configParamName}" />" />   </td>
  </tr>
  <tr>
    <td class="spec">Config Parameter Value :</th>
    <td><input  
      
                type="text" name="paramValue"  id="paramValue"
      
                value="<c:out value="${config.configParamValue}" />" />   </td>
  </tr>
  <tr>
    <td class="spec" colspan="2"> <input  
      
                type="submit" <c:choose>
      <c:when test="${action=='insert'}">value='Add'</c:when>
      <c:otherwise>value='Update'</c:otherwise></c:choose> class="button" /> </td>
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