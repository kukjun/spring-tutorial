<%--
  Created by IntelliJ IDEA.
  User: kukjunlee
  Date: 2022/02/03
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="member.register"/></title>
</head>
<body>
    <%--registerRequest 는 커맨드 객체에 접근할 때 사용한 속성 이름이다.--%>
    <p>
        <spring:message code="register.done" arguments="${registerRequest.name},${registerRequest.email}"/>
<%--        <spring:message code="register.done">--%>
<%--            <spring:argument value="${registerRequest.name}"/>--%>
<%--            <spring:argument value="${registerRequest.email}"/>--%>
<%--        </spring:message>--%>
    </p>
    <p><a href="<c:url value='/main'/>">[<spring:message code="go.main"/>]</a></p>
</body>
</html>
