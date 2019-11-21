<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Confirmation Page</title>
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/solar/bootstrap.min.css" rel="stylesheet" integrity="sha384-8nq3OiMMgrVFAHyRMMO+DTfMEciSY+c3Awhj/5ljQ1xck1Uv2BUtMjsjLD8GT5Er" crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <%@ include file="fragments/header.jsp"%>

    <div class="container">
        <div class="container">
            <br/>
            <span style="float:right;" class="text-muted"><c:out value="${currDateTime}"></c:out></span>
        </div>
        <p>
            <br/>
            <div class="card">
                <div class="card-header">
                    <h2>Thank you! Your message has been received as follows:</h2>
                </div>
                <div class="card-body">
                    <h4 class="card-title">First Name: <c:out value="${PesrsonRegistration.fname}"></c:out></h4>
                    <br/>
                    <h5 class="card-subtitle mb-2 text-muted">Last Name: <c:out value="${PesrsonRegistration.lname}"></c:out></h5>
                    <br/>
                    <h5 class="card-subtitle mb-2 text-muted">Email: <c:out value="${PesrsonRegistration.email}"></c:out></h5>
                    <br/>
                    <h4 class="card-title">Person Type: <c:out value="${PesrsonRegistration.ptype}"></c:out></h4>
                    <br/>
                    <h5 class="card-subtitle mb-2 text-muted">Phone: <c:out value="${PesrsonRegistration.phone}"></c:out></h5>
                    <br/>
                    <h5 class="card-subtitle mb-2 text-muted">Box Number: <c:out value="${PesrsonRegistration.boxnumber}"></c:out></h5>
        <br/><br/>
        <p>Please feel free to <a href="./contact-form" class="card-link">Contact Us</a> again</p>
    </div>
    </div>
    </p>
    </div>

    <%@include file="fragments/footer.jsp"%>

</body>
</html>