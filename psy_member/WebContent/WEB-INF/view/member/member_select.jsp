<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 회원 조회</title>
</head>
<body>
	<h5>전체 회원 목록</h5>
	<table>
	<thead>
	<tr>
	<th>아이디</th>
	<th>비밀번호</th>
	<th>이름</th>
	<th>성별</th>
	<th>생일</th>
	<th>닉네임</th>
	<th>소개</th>
	</tr>
	 </thead>
	 
	<tbody>
	<tr>
	<td><a href="./MemberSelectDetail.me?id=${arrayList.id}">${arrayList.id}</a></td> 
	<td>${arrayList.id }</td>
	<td>${arrayList.password }</td>
	<td>${arrayList.name }</td>
	<td>${arrayList.gender }</td>
	<td>${arrayList.birth }</td>
	<td>${arrayList.nickname }</td>
	<td>${arrayList.introduce }</td>
	</tr>
	
	<c:otherwise>
     <tr><td>등록된 회원이 없습니다.</td></tr> 
    </c:otherwise>
    
	</tbody> 
	</table>
</body>
</html>