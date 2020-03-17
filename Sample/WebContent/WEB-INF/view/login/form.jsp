<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
</head>
<body>
	<form:form commandName="loginCommand">
	 <form:errors element="div" /> <!-- 글로벌 에러 -->
	  아이디: <form:input path="userId" />
	  <!-- <input id="userId" name="userId" type="text" value=""> 이렇게 만들어줌 -->
	 <form:errors path="userId" element="div"/><!-- userId에 대한 에러 -->
	 <br/>
	  암호: <form:password path="password" showPassword="false" /> <!-- 소스보기 하면 html태그로 만들어진거 확인가능 -->
	 <form:errors path="password" element="div" /><!-- 패스워드에 대한 에러메세지가 div태그로 감싸져서 나옴 -->
	 <br/>
	 <input type="submit" />
	</form:form>
</body>
</html>