<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <c:set var="req" value="${pageContext.request}" />
    <c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="<c:out value="${baseURL}"></c:out>">MUM Mail Notification System</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Login">Login</a>
                </li>
                
                <c:choose>
                	<c:when test="${userRole=='Admin'}">
                		<li class="nav-item">
                    		<a class="nav-link" href="CreateUser">CreateUser</a>
                		</li>
                		<li class="nav-item">
                    		<a class="nav-link" href="PersonRegistrationValidator">CreatePerson</a>
                		</li>
                		<li class="nav-item">
                    		<a class="nav-link" href="AdminMailController">SendNotification</a>
                		</li>
                		<li class="nav-item">
                    		<a class="nav-link" href="about.jsp">LoginHistory</a>
                		</li>
                	</c:when>
                	<c:when test="${userRole=='Student'}">
                		<li class="nav-item">
	                   		 <a class="nav-link" href="mailController">Check Mail</a>
	               		</li>
                	</c:when>
                	<c:otherwise>
	                	
                	</c:otherwise>
                </c:choose>
                <li class="nav-item">
                    <a class="nav-link" href="about.jsp">About</a>
                </li>
            </ul>
            
             <c:choose>
                	<c:when test="${user.userName!=null}">
                		<!-- <form class="form-inline my-2 my-lg-0">
		                <input class="form-control mr-sm-2" type="text" placeholder="Search">
		                <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
			            </form>&nbsp;&nbsp; -->
			            <form class="form-inline my-2 my-lg-0" action="Logout" method="get">
			                <button class="btn btn-secondary my-2 my-sm-0" type="submit">Logout</button>
			            </form>
                	</c:when>
                	
                	<c:otherwise>
	                	
                	</c:otherwise>
            </c:choose>
                
            
        </div>
    </nav>
</header>