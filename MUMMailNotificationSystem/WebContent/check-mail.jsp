<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Check Mail</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/solar/bootstrap.min.css" rel="stylesheet" integrity="sha384-8nq3OiMMgrVFAHyRMMO+DTfMEciSY+c3Awhj/5ljQ1xck1Uv2BUtMjsjLD8GT5Er" crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%@ include file="fragments/header.jsp"%>
    <div class="container"><br/>
        <h2>List of Mails</h2>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">mail id</th>
                <th scope="col">delivery Date</th>
                <th scope="col">sender</th>
                <th scope="col">delivered By</th>
                <th scope="col">status</th>
                <th scope="col">&nbsp;</th>
                <th scope="col">&nbsp;</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="list" items="${mailList}" varStatus="iteration">
                    <tr>
                        <td><c:out value="${list.mailId}"></c:out></td>
                        <td><c:out value="${list.deliveryDate}"></c:out></td>
                        <td><c:out value="${list.sender}"></c:out></td>
                        <td><c:out value="${list.deliveredBy}"></c:out></td>
                        <td><c:out value="${list.status}"></c:out></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <%@include file="fragments/footer.jsp"%>
</body>
</html>
