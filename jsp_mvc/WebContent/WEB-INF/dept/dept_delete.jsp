<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보 삭제</title>
</head>
<body>
	<h1>부서 정보 삭제</h1>
	<h5>부서 삭제</h5>

	<form action="./DeptDeleteView.do" method="post" id="sign_dept">
		부서 번호 : <input type="text" name="deptno" id="deptno" value="${param.deptno}" readonly>

		<button type="submit">삭제</button>
		<button type="reset">취소</button>
	</form>
	<a href="./DeptSelect.do"> 부서 목록  |</a>
	<a href="./DeptInsert.do"> 부서 입력  |</a>
	<a href="./DeptUpdate.do?deptno=${param.deptno}"> 부서 수정 </a>


</body>
</html>