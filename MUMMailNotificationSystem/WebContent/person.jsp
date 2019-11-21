
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CS472-WAP-Lab 11 Solution - Contact Form</title>
<%--    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cosmo/bootstrap.min.css" rel="stylesheet" integrity="sha384-uhut8PejFZO8994oEgm/ZfAv0mW1/b83nczZzSwElbeILxwkN491YQXsCFTE6+nx" crossorigin="anonymous">--%>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">--%>
    <%--  <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/united/bootstrap.min.css" rel="stylesheet" integrity="sha384-WTtvlZJeRyCiKUtbQ88X1x9uHmKi0eHCbQ8irbzqSLkE0DpAZuixT5yFvgX0CjIu" crossorigin="anonymous">  --%>
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/solar/bootstrap.min.css" rel="stylesheet" integrity="sha384-8nq3OiMMgrVFAHyRMMO+DTfMEciSY+c3Awhj/5ljQ1xck1Uv2BUtMjsjLD8GT5Er" crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%@ include file="fragments/header.jsp"%>
    <div class="container"><br/>
        <form id="formPersonRegistration" method="POST" action="PersonRegistrationValidator">
            <fieldset>
                <legend>Person Registration Form</legend>
                <c:if test="${isErrMsgsPresent}">
                    <div>
                        <p>
                            ${errMsgs}
                        </p>
                    </div>
                </c:if>
                <div class="form-group"> <%-- Customer name  changed to fName--%>
                    <label for="customerName">*First Name:</label>
                    <input type="text" class="form-control" id="fName" name="fName" aria-describedby="customerNameHelp" placeholder="e.g. John" title="Enter first name" autofocus>
                    <small id="customerNameHelp" class="form-text text-muted">Enter first name.</small>
                </div>
                <div class="form-group">
                    <label for="customerName">*Last Name:</label> <%-- Customer name  changed to lName and aria-describedby to be deleted if have no impact the format--%>
                    <input type="text" class="form-control" id="lName" name="lName" aria-describedby="customerNameHelp" placeholder="e.g. Smith" title="Enter last name" autofocus>
                    <small id="customerNameHelp" class="form-text text-muted">Enter last name.</small>
                </div>
                <div class="form-group">
                    <label for="customerName">*Phone:</label> <%-- Customer name  changed to lName and aria-describedby to be deleted if have no impact the format--%>
                    <input type="text" class="form-control" id="phone" name="phone" aria-describedby="customerNameHelp" placeholder="" title="Enter phone" autofocus>
                    <small id="customerNameHelp" class="form-text text-muted">Enter phone number.</small>
                </div>
                
               <div class="input-group mb-3">
                     <div class="input-group-prepend">
                      <button class="btn btn-outline-secondary" type="button">Person Type</button>
                     </div>
                          <select class="custom-select" name="pType" aria-label="Example select with button addon">
                                   <option selected value="null">Choose...</option>
                                   <option value="1">Faculty</option>
                                   <option value="2">Student</option>
                                   <option value="3">Staff</option>
                        </select>
                    </div>
                              
                <div class="form-group"><%-- Id --%>
                    <label for="customerName">*Email:</label> <%-- Customer name  changed to lName--%>
                    <input type="text" class="form-control" id="email" name="email" aria-describedby="customerNameHelp" placeholder="e.g. jsmith@mum.edu" title="Email" autofocus>
                    <small id="customerNameHelp" class="form-text text-muted">Enter email.</small>
                </div>
                
                <div class="form-group"><%-- Id --%>
                    <label for="customerName">*MR #:</label> <%-- Customer name  changed to lName--%>
                    <input type="text" class="form-control" id="boxnumber" name="boxnumber" aria-describedby="customerNameHelp" pattern ="\d{3}">
                     <small id="customerNameHelp" class="form-text text-muted"> Box Number.</small>
                </div>
               
                <button id="btnSubmit" type="submit" class="btn btn-primary btn-block">Add</button>
            </fieldset>
        </form>
    </div>


    <%@include file="fragments/footer.jsp"%>
</body>
</html>
