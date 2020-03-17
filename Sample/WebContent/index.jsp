<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<a href="insert.do"> 입력</a><br>
	<a href="order/order.do">list 저장</a><br>
	<a href="search/internal.do?query=abc&p=10">@RequestParam1</a>
	<a href="search/external.do">@RequestParma2</a><br>
	<a href="cookie/make.do">쿠키 생성</a>
	<a href="cookie/view.do">쿠키 확인@CookieValue</a><br>
	<a href="header/check.do">헤더 정보 확인@RequestHeader</a><br>
	<a href="search/main.do">model 데이터 생성</a>
	<a href="account/create.do">@ModelAttribute 객체 초기화</a>
	<a href="game/users/Hanyue/characters/25">@PathVariable</a>
	<a href="login/login.do">@Vaild</a>
	</body>
</html>