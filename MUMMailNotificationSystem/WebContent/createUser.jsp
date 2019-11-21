<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contact Us</title>
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/solar/bootstrap.min.css" rel="stylesheet" integrity="sha384-8nq3OiMMgrVFAHyRMMO+DTfMEciSY+c3Awhj/5ljQ1xck1Uv2BUtMjsjLD8GT5Er" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%@ include file="fragments/header.jsp"%>
   
    <div class="container"><br/>
        <p class="float-right">
            <a class="nav-link" href="ListofUsers.jsp">List of Users</a>
   <p>
        <form id="formCreateUser" method="post" action="./CreateUserValidator">
            <fieldset>
                <legend>Create User</legend>
                <c:if test="${isErrMsgsPresent}">
                    <div>
                        <p>
                            ${errMsgs}
                        </p>
                    </div>
                </c:if>
                <div class="form-group">
                    <label for="userName">*UserName:</label>
                    <input type="text" class="form-control" id="username" name="username" aria-describedby="userNameHelp" placeholder="eg. aigemtio" title="Enter your username" required autofocus>
                    <small id="userNameHelp" class="form-text text-muted">Enter your UserName.</small>
                </div>
               <div class="form-group">
                    <label for="password">*Password:</label>
                    <input type="password" class="form-control" id="password" name="password" aria-describedby="passwordHelp" placeholder="" title="Enter your username" required autofocus>
                   
                </div>
                <div class="form-group">
                    <label for="ddluserRole">*User Role:</label>
                    <select class="form-control" id="ddluserRole" name="ddluserRole">
                        <option value="null">Select...</option>
                        <option value="1">Administrator</option>
                        <option value="2">Student</option>
                        <option value="3">Faculty</option>
                    </select>
                </div>
                 <div class="form-group">
                    <label for="ddlPerson">*Select Person:</label>
                    <select class="form-control" id="ddlPerson" name="ddlPerson">
                        <option value="null">Select...</option>
                        <option value="1">Amanuel Isack</option>
                        <option value="2">Desalie Hdremariam</option>
                        <option value="3">Bruk Andemariam</option>
                    </select>
                </div>
                
                <button id="btnSubmit" type="submit" class="btn btn-primary btn-block">Submit</button>
            </fieldset>
        </form>
    </div>
   

    <%@include file="fragments/footer.jsp"%>
</body>
</html>
