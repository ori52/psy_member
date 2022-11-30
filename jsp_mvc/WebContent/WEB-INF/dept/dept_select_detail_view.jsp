<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세 부서 정보</h1>
	<h5>부서 상세 보기</h5>
	<table>
		<thead>
			<tr>
				<th>부서 번호</th>
				<th>부서 이름</th>
				<th>부서 지역</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${deptDTO.deptno}</td>
				<td>${deptDTO.dname}</td>
				<td>${deptDTO.loc}</td>
			</tr>
		</tbody>
	</table>
	<a href="./DeptSelect.do">  부서 목록  |</a>
	<a href="./DeptUpdate.do?deptno=${deptDTO.deptno}">  부서 수정  |</a>
	<a href="./DeptDelete.do?deptno=${deptDTO.deptno}">  부서 삭제 </a>

</body>
</html>