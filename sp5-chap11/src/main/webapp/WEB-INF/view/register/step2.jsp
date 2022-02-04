<%--
  Created by IntelliJ IDEA.
  User: kukjunlee
  Date: 2022/02/03
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>회원 가입</title>
</head>
<body>
<h2>회원 정보 입력</h2>
<%--action 은 from 태그와 동일한 값을 사용한다.--%>
<%--modelAttribute 는 커맨드 객체의 속성 이름을 지정한다. 설정하지 않는 경우 "command"를 기본값으로 사용한다.--%>
<form:form action="step3" modelAttribute="registerRequest">
    <p>
        <lable>이메일:<br>
                <%--form:input tag 는 input tag 를 생성한다. path 로 지정한 커맨드 객체의 프로퍼티를 input tag 에 value 속성 값으로 사용--%>
            <form:input path="email"/>
        </lable>
    </p>
    <p>
        <lable>이름:<br>
            <form:input path="name"/>
        </lable>
    </p>
    <p>
        <lable>패스워드:<br>
                <%--form:password tag 는 password 타입의 input tag 를 생성한다.--%>
            <form:password path="password"/>
        </lable>
    </p>
    <p>
        <lable>패스워드 확인:<br>
            <form:password path="confirmPassword"/>
        </lable>
    </p>
    <input type="submit" value="가입 완료">
</form:form>
</body>
</html>
