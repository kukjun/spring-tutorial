<%--
  Created by IntelliJ IDEA.
  User: kukjunlee
  Date: 2022/02/03
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<%--registerRequest 는 커맨드 객체에 접근할 때 사용한 속성 이름이다.--%>
<p><strong>${registerRequest.name}님</strong>회원 가입을 완료했습니다.</p>
<p><a href="<c:url value='/main'/>">[첫 화면 이동]</a> </p>
</body>
</html>
