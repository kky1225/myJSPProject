<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('#register_form').submit(function(){
					
					if($('#id').val().trim() == ''){
						alert('아이디를 입력하세요');
						$('#id').val('');
						$('#id').focus();
						return false;
					}
					
					if($('#password').val().trim() == ''){
						alert('비밀번호를 입력하세요');
						$('#password').val('')
						$('#password').focus();
						return false;
					}
					
					if($('#password_check').val().trim() == ''){
						alert('비밀번호 확인을 입력하세요');
						$('#password_check').val('')
						$('#password_check').focus();
						return false;
					}
					
					if($('#password').val().trim() != $('#password_check').val().trim()){
						alert('비밀번호와 비밀번호 확인의 값이 다릅니다.');
						$('#password_check').val('').focus();
						return false;
					}
					
					if($('#name').val().trim() == ''){
						alert('이름을 입력하세요');
						$('#name').val('').focus();
						return false;
					}
					
					if($('#phone').val().trim() == ''){
						alert('전화번호를 입력하세요');
						$('#id').val('').focus();
						return false;
					}
					
					if($('#email').val().trim() == ''){
						alert('이메일 입력하세요');
						$('#id').val('').focus();
						return false;
					}
					
					if($('#zipcode').val().trim() == ''){
						alert('우편번호를 입력하세요');
						$('#id').val('').focus();
						return false;
					}
					
					if($('#address1').val().trim() == ''){
						alert('주소를 입력하세요');
						$('#id').val('').focus();
						return false;
					}
					
					if($('#address2').val().trim() == ''){
						alert('상세주소를 입력하세요');
						$('#id').val('').focus();
						return false;
					}
					
					if($('#gender').val().trim() == ''){
						alert('성별을 입력하세요');
						return false;
					}
				});
			});
		</script>
	</head>
	<body>
		<div class="page-main">
		<jsp:include page="/WEB-INF/views/common/header.jsp"/>
		<h2>회원가입</h2>
		<form id="register_form" action="registerUser.do" method="post">
			<ul>
				<li>
					<label for="id">아이디</label>
					<input type="text" name="id" id="id" maxlength="12" autocomplete="off">
					<input type="button" value="중복확인" id="id_check">
					<span id="message_id"></span>
				</li>
				<li>
					<label for="passwd">비밀번호</label>
					<input type="password" name="password" id="password" maxlength="12">
				</li>
				<li>
					<label for="passwd">비밀번호 확인</label>
					<input type="password" name="password_check" id="password_check" maxlength="12">
				</li>
				<li>
					<label for="name">이름</label>
					<input type="text" name="name" id="name" maxlength="10">
				</li>
				<li>
					<label for="phone">전화번호</label>
					<input type="text" name="phone" id="phone" maxlength="15">
				</li>
				<li>
					<label for="email">이메일</label>
					<input type="email" name="email" id="email" maxlength="50">
				</li>
				<li>
					<label for="zipcode">우편번호</label>
					<input type="text" name="zipcode" id="zipcode" maxlength="5">
				</li>
				<li>
					<label for="address1">주소</label>
					<input type="text" name="address1" id="address1" maxlength="30">
				</li>
				<li>
					<label for="address2">상세 주소</label>
					<input type="text" name="address2" id="address2" maxlength="30">
				</li>
				<li>
					<label for="gender">성별</label>
					<input type="radio" name="gender" id="male" value="m">남자
					<input type="radio" name="gender" id="female" value="f">여자
				</li>
			</ul>
			<div class="align-center">
				<input type="submit" value="등록">
				<input type="button" value="홈으로" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
			</div>
		</form>
		</div>
	</body>
</html>