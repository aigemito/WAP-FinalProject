<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contact Us</title>
<%--    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cosmo/bootstrap.min.css" rel="stylesheet" integrity="sha384-uhut8PejFZO8994oEgm/ZfAv0mW1/b83nczZzSwElbeILxwkN491YQXsCFTE6+nx" crossorigin="anonymous">--%>
    <%--  <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/united/bootstrap.min.css" rel="stylesheet" integrity="sha384-WTtvlZJeRyCiKUtbQ88X1x9uHmKi0eHCbQ8irbzqSLkE0DpAZuixT5yFvgX0CjIu" crossorigin="anonymous">  --%>
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css" rel="stylesheet" integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%@ include file="fragments/header.jsp"%>
    <div class="container"><br/>
        <form id="formCustomerContact" method="post" action="contact-form-data-validator">
            <fieldset>
                <legend>Contact Form</legend>
                <c:if test="${isErrMsgsPresent}">
                    <div>
                        <p>
                            ${errMsgs}
                        </p>
                    </div>
                </c:if>
                <div class="form-group">
                    <label for="customerName">*Name:</label>
                    <input type="text" class="form-control" id="customerName" name="customerName" aria-describedby="customerNameHelp" placeholder="e.g. John Smith" title="Enter your full name" autofocus>
                    <small id="customerNameHelp" class="form-text text-muted">Enter your full name.</small>
                </div>
                <label>*Gender:</label><br/>
                <div class="form-group">
                    <div class="custom-control custom-radio">
                        <input id="radioGenderMale" name="radioGender" type="radio" class="custom-control-input" value='Male'>
                        <label for="radioGenderMale" class="custom-control-label">Male</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input id="radioGenderFemale" name="radioGender" type="radio" class="custom-control-input" value='Female'>
                        <label for="radioGenderFemale" class="custom-control-label">Female</label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="ddlCategory">*Category:</label>
                    <select class="form-control" id="ddlCategory" name="ddlCategory">
                        <option value="null">Select...</option>
                        <option value="Feedback">Feedback</option>
                        <option value="Inquiry">Inquiry</option>
                        <option value="Complaint">Complaint</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="message">*Message:</label>
                    <textarea class="form-control" id="message" name="message" rows="3" ></textarea>
                </div>
                <button id="btnSubmit" type="submit" class="btn btn-primary btn-block">Submit</button>
            </fieldset>
        </form>
    </div>
    <div class="container">
        <br/>
        <br/>
        <span class="text-muted">Hit Count for this page: 1</span>
        <span style="float:right;" class="text-muted">Total Hit Count for the entire WebApp: 4</span>
    </div>

    <%@include file="fragments/footer.jsp"%>
</body>
</html>
