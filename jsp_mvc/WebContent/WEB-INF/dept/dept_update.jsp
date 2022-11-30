<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보 수정</title>
</head>
<body>
<h1> 부서 정보 수정 </h1>
<h5> 부서 수정 </h5>
<form action="./DeptUpdateView.do" method="post" id="sign_dept">
부서 번호 : <input type="text" name="deptno" id="deptno" value="${param.deptno}" readonly>
부서 이름 : <input type="text" name="dname" id="dname" value="${deptDTO.dname}">
부서 지역 : <input type="text" name="loc" id="loc" value="${deptDTO.loc}">

<button type="submit"> 등록 </button>
<button type="reset"> 취소 </button>
</form>
<a href="./DeptSelect.do"> 부서 목록 </a>
<a href="./DeptInsert.do"> 부서 입력 </a>
<a href="./DeptDelete.do?deptno=${param.deptno}">부서 삭제</a>
</body>
</html>