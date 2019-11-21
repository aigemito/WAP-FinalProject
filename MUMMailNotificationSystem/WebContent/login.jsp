<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/solar/bootstrap.min.css" rel="stylesheet" integrity="sha384-8nq3OiMMgrVFAHyRMMO+DTfMEciSY+c3Awhj/5ljQ1xck1Uv2BUtMjsjLD8GT5Er" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div id="container">
    <%@ include file="fragments/header.jsp"%>
 
  <h2>Login Credentials</h2>
  <form id="input" method="post" action="LoginValidator">
            <%
                String value = "", checkbox = "";
                Cookie[] cookies = request.getCookies();
                if(cookies != null){
                    for(Cookie c : cookies){
                        if(c.getName().equals("userCookie")){
                            value = c.getValue();
                            checkbox = "checked";
                            break;
                        }
                    }
                }
                //  value = request.getCookies()[0].getValue();
            %>
    <c:if test="${isErrorPresent}">
     <div>
                        <p>
                            ${errorMsg}
                        </p>
      </div>
    </c:if>
    <div  class="form-group">
      <label for="userName">UserName:</label>
      <input type="userName" class="form-control" id="userName" placeholder="Enter UserName" name="username" value='<%=value%>'>
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
    </div>
    <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember" <%=checkbox%>> Remember me
      </label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
    </div>

    <%@include file="fragments/footer.jsp"%>
</div>

</body>
</html>
