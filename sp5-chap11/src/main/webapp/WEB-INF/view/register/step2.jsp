<%--
  Created by IntelliJ IDEA.
  User: kukjunlee
  Date: 2022/02/03
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="member.register"/></title>
</head>
<body>
<h2><spring:message code="member.info"/></h2>
<%--action 은 from 태그와 동일한 값을 사용한다.--%>
<%--modelAttribute 는 커맨드 객체의 속성 이름을 지정한다. 설정하지 않는 경우 "command"를 기본값으로 사용한다.--%>
<form:form action="step3" modelAttribute="registerRequest">
    <p>
        <lable><spring:message code="email"/>:<br>
                <%--form:input tag 는 input tag 를 생성한다. path 로 지정한 커맨드 객체의 프로퍼티를 input tag 에 value 속성 값으로 사용--%>
            <form:input path="email"/>
            <form:errors path="email"/>
        </lable>
    </p>
    <p>
        <lable><spring:message code="name"/>:<br>
            <form:input path="name"/>
            <form:errors path="name"/>
        </lable>
    </p>
    <p>
        <lable><spring:message code="password"/>:<br>
                <%--form:password tag 는 password 타입의 input tag 를 생성한다.--%>
            <form:password path="password"/>
            <form:errors path="password"/>
        </lable>
    </p>
    <p>
        <lable><spring:message code="password.confirm"/>:<br>
            <form:password path="confirmPassword"/>
            <form:errors path="confirmPassword"/>
        </lable>
    </p>
    <input type="submit" value="<spring:message code="register.btn"/>">
</form:form>
</body>
</html>
