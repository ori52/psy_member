<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 정보 입력</h1>
	<h5>부서 입력</h5>
	<form action="./DeptInsertView.do" method="post" id="sign_dept">
		부서 번호 : <input type="text" name="deptno" id="deptno">
		부서 이름 : <input type="text" name="dname" id="dname"> 
		부서 지역 : <input type="text" name="loc" id="loc">

		<button type="submit">등록</button>
		<button type="reset">취소</button>
	</form>
	<br>
	<br>
	<a href="./DeptSelect.do"> 부서 목록 </a>

</body>
</html>