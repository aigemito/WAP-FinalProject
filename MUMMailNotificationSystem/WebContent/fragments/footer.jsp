<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer class="footer">
    <div id="footer-content">
        <span class="text-muted">
                <c:choose>
                	<c:when test="${user.userName!=null}">
                	  <c:out value="Login History : ${user.userName} last login time 2019-18-9 11:12:30 from IP address of 192:168:0:1"></c:out>	
                	</c:when>
                	
                	<c:otherwise>
	                	<c:out value="MUM Mail Notification System"></c:out>
                	</c:otherwise>
                </c:choose>
        </span>
        <span style="float:right;" class="text-muted">&copy; November 2019</span>
    </div>
</footer>
