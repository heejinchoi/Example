<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form id="registerModify" name="registerModify" method="post" action="register-modify" onsubmit="return check2();">
<div style="text-align: center; margin-top: 50px;">
	<div>
		<h1>회원가입</h1>
	</div>
	
	<div>
		<label for="select">회원구분</label>
		<select id="userType" name="userType">
		<option value="개인회원" selected>개인회원</option>
		<option value="기업회원">기업회원</option>
		<option value="관리자">관리자</option>
		</select>
	</div>
		
	<div>	
		<label for="id">아이디</label>
		<input type="text" id="userId" name="userId" size="20">
	</div>	
		
	<div>
		<label for="password">비밀번호</label>
		<input type="text" id="password" name="password" size="20">
	</div>	
		
	<div>	
		<label for="name">이름</label>
		<input type="text" id="userName" name="userName"> 
	</div>
		
	<div>	
		<label for="gender">성별</label>
		<input type="radio" id="genderx" name="gender" value="남성"><label for="genderx">남성</label>
		<input type="radio" id="gendery" name="gender" value="여성"><label for="gendery">여성</label>
	</div>
		
	<div>	
		<label for="mobile">전화번호</label>
		<input type="text" id="mobile" name="mobile">
	</div>
		
	<div>	
		<label for="email">이메일</label>
		<input type="email" id="email" name="email"> 
	</div>
		
	<div>	
		<label for="contents">기타의견</label><br>
		<textarea id="contents" name="contents"></textarea>
	</div>
		
	<div>	
		<input type="submit" value="수정">	
		<input type="button" value="ajax" onclick="ajaxcheck();">
		
	</div>
</div>

<div>
	<input type="hidden" id="userInfo" name="userInfo">
</div>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>	
<script type="text/javascript">

 	function check1() {
		var userId =  document.getElementById("userId").value;
		var password =  document.getElementById("password").value;
		var userName =  document.getElementById("userName").value;
		var mobile =  document.getElementById("mobile").value;
		var email =  document.getElementById("email").value;
//		var gender =  document.getElementById("gender").value;
// 		var userType = document.getElementById("userType").value;

		if(userId.value == null || "" == userId.value){
			alert("아이디를 입력하여 주십시오.");
			return false;
		}
		else if(password.value == null || "" == password.value){
			alert("비밀번호를 입력하여 주십시오.");
			return false;
		}
		else if(userName.value == null || "" == userName.value){
			alert("이름을 입력하여 주십시오.");
			return false;
		}
		else if(mobile.value == null || "" == mobile.value){
			alert("전화번호를 입력하여 주십시오.");
			return false;
		}
		else if(email.value == null || "" == email.value){
			alert("이메일을 입력하여 주십시오.");
			return false;
		}
/* 		else if(userType.value == null || "" == userType.value){
			alert("회원구분을 선택하여 주십시오.");
			return false;
		} */
/* 		else if(){
			alert("성별을 체크하여 주십시오.");
			return false;
		} */
		
	} 
 	
 	function check2(){		
 		if($("#userId").val() == null || $("#userId").val() == ""){
	 		alert("아이디를 입력하여 주십시오.");
	 		return false;
 		}
 		else if($("#password").val() == null || $("#password").val() == ""){
	 		alert("비밀번호를 입력하여 주십시오.");
	 		return false;
 		}
 		else if($("#userName").val() == null || $("#userName").val() == ""){
	 		alert("이름을 입력하여 주십시오.");
	 		return false;
 		}
 		else if($("#mobile").val() == null || $("#mobile").val() == ""){
	 		alert("전화번호를 입력하여 주십시오.");
	 		return false;
 		}
 		else if($("#email").val() == null || $("#email").val() == ""){
	 		alert("이메일을 입력하여 주십시오.");
	 		return false;
 		}
/*  		else if($("#gender").val() == null || $("#gender").val() == ""){
	 		alert("성별을 체크하여 주십시오.");
	 		return false;
 		}
 		else if($("#userType").val() == null || $("#userType").val() == ""){
	 		alert("회원구분을 선택하여 주십시오.");
	 		return false;
 		} */

 	}
 	
/*  	function duplication() {
		alert("중복확인 되었습니다.");
	} */
	
	
 	function ajaxcheck() {
		/* var gender = $('input:radio[name=gender]:checked').val()
		console.log('선택된 성별 : ' + gender);
		
		var userType = $('#userType option:selected').val();
		console.log('선택된 회원구분 : ' + userType);
		
		var email = $('#email').val();
		console.log('email: ' + email);
		
		var contents = $('#contents').val();
		console.log('textarea: ' + contents); */

		
	 	var info = $('#registerForm').serialize();
	 
		$.ajax({
			url: "/user/ajax-register",
			type: "POST",
			data: info,
			dataType: "json",
			success: function(message) {
				alert("회원가입 되었습니다.");
			},
			error:function(request, status, error) {
				console.log("code : " + request.status + "\n message : " + request.responseText + "\n error : " + error);
			}
		});
	}
	

	
	
</script>

</body>
</html>