<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>MUMMailNotificationSystem</title>
  <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/solar/bootstrap.min.css" rel="stylesheet" integrity="sha384-8nq3OiMMgrVFAHyRMMO+DTfMEciSY+c3Awhj/5ljQ1xck1Uv2BUtMjsjLD8GT5Er" crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%@ include file="fragments/header.jsp"%>
    <div class="container">
      <div class="jumbotron">
        <p>Welcome <c:out value="${userRole}"></c:out>, <c:out value="${user.userName}"></c:out> </p>
		  <c:if test="${user.userName==null}">
		  	<% response.sendRedirect("login.jsp"); %>
		  </c:if>
		  
		  
		  <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
			  <thead>
			    <tr>
			      <th class="th-sm">UserName
			
			      </th>
			      <th class="th-sm">Password
			
			      </th>
			      <th class="th-sm">UserRole
			
			      </th>
			      <th class="th-sm">Person ID
				  </th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td>Tiger Nixon</td>
			      <td>System Architect</td>
			      <td>Edinburgh</td>
			      <td>61</td>
			      
			    </tr>
			    <tr>
			      <td>Garrett Winters</td>
			      <td>Accountant</td>
			      <td>Tokyo</td>
			      <td>63</td>
			      
			    </tr>
			    <tr>
			      <td>Ashton Cox</td>
			      <td>Junior Technical Author</td>
			      <td>San Francisco</td>
			      <td>66</td>
			      
			    </tr>
			    
			   
			    
			  </tbody>
			  <tfoot>
			    <tr>
			      <th>Name
			      </th>
			      <th>Position
			      </th>
			      <th>Office
			      </th>
			      <th>Age
			      </th>
			     
			    </tr>
			  </tfoot>
			</table>
      </div>
      
      
      
    </div>
    <%@include file="fragments/footer.jsp"%>
    
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
     <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script> 
     <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script> 
    <script src="js/app.js"></script>
</body>
</html>
