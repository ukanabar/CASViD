<%@include file="header.jsp" %> 
<script language="javascript" src="./scripts/slaparam.js"></script>
<div class="top-bar">

<h1><c:choose>
      <c:when test="${action=='insert'}">Add      
      </c:when>
      <c:otherwise>Update      
      </c:otherwise>
    </c:choose> Service Level Agreement Parameter</h1>
<!--<div class="breadcrumbs"><a href="#">Homepage</a> / <a href="#">Contents</a></div>-->
</div>
<div class="select-bar">

</div>
<div class="table">  
      
        <form method="POST" action='SlaParamController' name="frmAddSlaParam" id="frmAddSlaParam">  
      <table class="listing form" cellpadding="0" cellspacing="0">
                        <tr>
                            <th class="full" colspan="2"><c:choose>
      <c:when test="${action=='insert'}">Add      
      </c:when>
      <c:otherwise>Update      
      </c:otherwise>
    </c:choose> Service Level Agreement Parameter</th>
                        </tr>
  <tr>
    <td class="spec">SLA Parameter Name : </th>
    <td><input type="hidden" name="slaParamId"  
      
                value="<c:out value="${slaParam.slaParamId}" />" /><input  
      
                type="text" name="slaParamName"  id="slaParamName"
      
                value="<c:out value="${slaParam.slaParamName}" />" /> <input type="hidden" name="action" value="add/edit" ></td>
  </tr>
  <tr>
    <td class="spec">SLA Parameter Unit :</th>
    <td><input  
      
                type="text" name="slaParamUnit"  id="slaParamUnit"
      
                value="<c:out value="${slaParam.slaParamUnit}" />" /></td>
  </tr>
  <tr>
    <td class="spec">SLA Parameter Description :</th>
    <td><textarea name="slaParamDesc"  id="slaParamDesc"
      
                /><c:out value="${slaParam.slaParamDesc}" /></textarea></td>
  </tr>
  <tr>
    
    <td colspan="2" class="spec"><input  
      
                type="submit" <c:choose>
      <c:when test="${action=='insert'}">value='Add'</c:when>
      <c:otherwise>value='Update'</c:otherwise></c:choose>  class="button"/> </td>
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