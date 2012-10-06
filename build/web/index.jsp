<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Admin</title>
    <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />    
    <link rel="stylesheet" href="./styles/casvid.css" />
    <script language="javascript" src="./scripts/jquery.js"></script>
    <script language="javascript" src="./scripts/jquery-validate.js"></script>

</head>
<body>
 
  <div style="width: 500px; margin: 200px auto 0 auto;">
      
  <form name="loginForm" id="loginForm" action="UserController" method="post">
      <div align="center" class="formerror">${error}</div>
          
  <table class="listing" cellpadding="0" cellspacing="0" style="width:400px;">
      
  <tr>
                            <th class="full" colspan="2" style="font-size:18px">USER LOGIN</th>    
  </tr>
  <tr>
    <td class="spec">UserName:</td>
    <td style="text-align:left;"><input type="text" name="userName"/></td>
  </tr>
  <tr>
    <td class="spec">Password:</td>
    <td style="text-align:left;"><input type="password" name="password"/></td>
  </tr>
  <tr>
    <td colspan="2"><input name="action" type="submit" class="button" value="Login" style="display:compact" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="UserController?action=insert">Request an account?</a></td>
  </tr>
</table>
</form>
</div>
</body>
</html>
      
     
   