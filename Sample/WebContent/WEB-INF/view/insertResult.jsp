<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 쓰기</title>
</head>
<body>
<c:if test="${i == 0 }">
회원가입안됨!!
</c:if>
<c:if test="${i >0 }">
	게시글 등록됨:<br>
	제목: ${mem.memberid}<br><!-- ${command.title} -->
	내용: ${mem.password}<!-- ${command.content} -->
	${mem.name}
	${mem.email}
	<!-- getter를 통해서 출력. 없음 error -->
</c:if>
</body>
</html>