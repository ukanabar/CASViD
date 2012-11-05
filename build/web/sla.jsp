<%@include file="header.jsp" %>   
<div class="top-bar">

<h1><c:choose>
      <c:when test="${action=='insert'}">Add      
      </c:when>
      <c:otherwise>Update      
      </c:otherwise>
    </c:choose> Service Level Agreement</h1>
<!--<div class="breadcrumbs"><a href="#">Homepage</a> / <a href="#">Contents</a></div>-->
</div>
<div class="select-bar">

</div>
<div class="table">
      
        <form method="POST" action='SlaController' name="frmAddSla">  
      
      <table class="listing form" cellpadding="0" cellspacing="0">
                        <tr>
                            <th class="full" colspan="2"><c:choose>
      <c:when test="${action=='insert'}">Add      
      </c:when>
      <c:otherwise>Update      
      </c:otherwise>
    </c:choose> Service Level Agreement</th>
                        </tr>
  <tr>
    <td class="spec">Application :</th>
    <td> <input type="hidden" name="slaId"  
      
                value="<c:out value="${sla.slaId}" />" />   
           
            <input type="hidden" name="slaType"  
      
                value="pro" /><input name="customerId" type="hidden" value="<c:out value="${intCustId}" />"/> <select name="appId"><option value="select">select</option><c:forEach items="${Application}" var="app"><option value="<c:out value="${app.applicationId}" />"  <c:if test="${app.applicationId==sla.applicationId}">selected="selected"</c:if>><c:out value="${app.applicationName}" /></option></c:forEach></select></td>
  </tr>
  <tr>
    <td class="spec">SLA Parameter :</th>
    <td><select name="slaParamId"><option value="select">select</option><c:forEach items="${Slaparam}" var="slap"><option value="<c:out value="${slap.slaParamId}" />" <c:if test="${slap.slaParamId==sla.slaParamId}">selected="selected"</c:if>><c:out value="${slap.slaParamName}" /></option></c:forEach></select> </td>
  </tr>
  <tr>
    <td class="spec">Threat Value : </th>
    <td> <input  
      
                type="text" name="threatValue"  
      
                value="<c:out value="${sla.threatValue}" />" /> </td>
  </tr>
  <tr>
    <td class="spec"> Threshold Value : </th>
    <td><input  
      
                type="text" name="violationValue"  
      
                value="<c:out value="${sla.violationValue}" />" /> </td>
  </tr>
    
  <tr>
    <td class="spec"> SLA Expiry Date:</th>
    <td> <input  
      
                type="text" name="expDate"  
      
                value="<c:out value="${sla.expiryDate}" />" /></td>
  </tr>
  <tr>
    <td colspan="2" class="spec"><input  
      
                type="submit" <c:choose>
      <c:when test="${action=='insert'}">value='Add'</c:when>
      <c:otherwise>value='Update'</c:otherwise></c:choose>  class="button"/>  
      </td>
    
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