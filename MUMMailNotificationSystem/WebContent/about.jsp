<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About</title>
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
                    <h2>Team Members:</h2>
                </div>
                <div class="card-body">
                    <h4 class="card-title">1. 610590    - AMANUEL ISACK  GEBREENDRIAS</h4> <br/>
                     <h4 class="card-title">2.110447    - BRUK ANDEMARIAM</h4> <br/>
                      <h4 class="card-title">3.1100595  - DESALE HDREMARIAM</h4> <br/>
                       <h4 class="card-title">4. 610483 - GIRMAY HAILE GEBRESELASSIE</h4>
              
                    <br/>
       
        <br/><br/>
        <p>Please feel free to <a href="./contact-form" class="card-link">Contact Us</a> again</p>
    </div>
    </div>
    </p>
    
    </div>

    <%@include file="fragments/footer.jsp"%>

</body>
</html>
