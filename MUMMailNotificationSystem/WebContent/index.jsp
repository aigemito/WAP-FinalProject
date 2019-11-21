<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
        <h1 class="display-3">Welcome, MUM Mail Notification System!</h1>
        <h3>Web based application</h3>
        <p class="lead">The goal of the project is development of software for MUM Package Mail Notification System. The aim of this software is to allow the mailing room department of MUM to be able to send students a notification if a package or mail has arrived for them. This way students will not have to physically check whether they have mail or not. This software also helps in the management part of the department in making decision and others. </p>
        <hr class="my-4">
        <p>Do not hesitate to contact us.</p>
        <p class="lead">
          <a class="btn btn-primary btn-lg" href="about.jsp" role="button">Contact Us</a>
        </p>
      </div>
    </div>
    <%@include file="fragments/footer.jsp"%>
    
</body>
</html>
