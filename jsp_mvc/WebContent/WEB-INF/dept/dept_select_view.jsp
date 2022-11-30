<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 관리</h1>
	<h5>부서 목록</h5>
	<table>
		<thead>
			<tr class="text-center">
				<th>부서 번호</th>
				<th>부서 이름</th>
				<th>부서 지역</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="arrayList" items="${arrayList}">
				<tr class="text-center">
					<td>${arrayList.deptno}</td>
					<td>${arrayList.dname}</td>
					<td>${arrayList.loc}</td>
					<td>
						<a href="./DeptSelectDetail.do?deptno=${arrayList.deptno}">부서 상세 보기</a>
					</td>
				</tr>
			</c:forEach>
			<c:if test="${empty arrayList}">
				<tr>
					<td colspan="4">등록된 부서가 없습니다.</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<br><br>
	<a href="./DeptInsert.do"> 부서 입력  </a>
</body>
</html>