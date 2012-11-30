<%-- 
    Document   : vm
    Created on : Oct 9, 2012, 12:56:58 AM
    Author     : Utkarsh
--%>

<%@include file="header.jsp" %> 
<script language="javascript" src="./scripts/vm.js"></script>  
<div class="top-bar">

<h1><c:choose>
      <c:when test="${action=='insert'}">Add      
      </c:when>
      <c:otherwise>Update      
      </c:otherwise>
    </c:choose>
 Vm</h1>
<!--<div class="breadcrumbs"><a href="#">Homepage</a> / <a href="#">Contents</a></div>-->
</div>
<div class="select-bar">

</div>
<div class="table">
        <form method="POST" action='VmController' name="frmAddVm" id="frmAddVm">  
            <input type="hidden" name="action" value="add/edit" />
      <table class="listing form" cellpadding="0" cellspacing="0">
                        <tr>
                            <th class="full" colspan="2"><c:choose>
      <c:when test="${action=='insert'}">Add      
      </c:when>
      <c:otherwise>Update      
      </c:otherwise>
    </c:choose> Vm</th>
                        </tr>
  <tr>
    <td class="spec">Vm Name:</th>
    <td><input type="hidden" name="vmId"  
      
                value="<c:out value="${vm.vmId}" />" /> <input  
      
                type="text" name="vmName" id="vmName"
      
                value="<c:out value="${vm.vmName}" />" />  </td>
  </tr>
  <tr>
    <td class="spec">Vm Desc:</th>
    <td><textarea name="vmDesc" id="vmDesc"><c:out value="${vm.vmDesc}" /></textarea><input type="hidden" name="customerId" value="${intCustId}" /></td>
  </tr>
  <tr>
    <td class="spec">IP:</th>
    <td><input  
      
                type="text" name="ip" id="ip" value="<c:out value="${vm.ip}" />" 
                /> </td>
  </tr>
  <tr>
    <td class="spec">Host:</th>
    <td><input  
      
                type="text" name="hostname" id="hostname" value="<c:out value="${vm.host}" />" 
                /> </td>
  </tr>
  <tr>
    <td class="spec">Port:</th>
    <td><input  
      
                type="text" name="port" id="port" value="<c:out value="${vm.port}" />" 
                /> </td>
  </tr>
  <tr>
    <td class="spec">Mac Address:</th>
    <td><input  
      
                type="text" name="macaddress"  id="macaddress"
      
                value="<c:out value="${vm.macAddress}" />" /></td>
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