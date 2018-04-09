<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>register</title>
	
	<style>
	  table, th, td {
	    border: 1px solid white;
	  }
	  table {
	    width: 400px;
	    height: 200px;
	    margin-left: auto;
	    margin-right: auto;
	  }
	</style>
</head>

<body>

<form id="registerForm" name="registerForm" method="post" action="insertUser" onsubmit="return check2();">
<div style="text-align: center; margin-top: 50px;">
	<div>
		<h1 style="margin: 50px;">회원가입</h1>
	</div>
	
	<table style="display: ">
		<tr>		
			<th><label for="select">회원구분</label></th>
			<td>
				<select id="userType" name="userType">
					<option value="개인회원" selected>개인회원</option>
					<option value="기업회원">기업회원</option>
					<option value="관리자">관리자</option>
				</select>
			</td>
		</tr>
		<tr>		
			<th><label for="id">아이디</label></th>
			<td>
				<input type="text" id="userId" name="userId" size="20">
			</td>
			<td>
				<input type="button" id="idCheckBtn" value="중복확인"> 
			</td>
		</tr>
		<tr>		
			<th><label for="password">비밀번호</label></th>
			<td><input type="text" id="password" name="password" size="20"></td>
		</tr>
		<tr>		
			<th><label for="name">이름</label></th>
			<td><input type="text" id="userName" name="userName"> </td>
		</tr>
		<tr>		
			<th><label for="gender">성별</label></th>
			<td>
				<input type="radio" id="genderx" name="gender" value="남성"><label for="genderx">남성</label>
				<input type="radio" id="gendery" name="gender" value="여성"><label for="gendery">여성</label>
			</td>
		</tr>
		<tr>		
			<th><label for="mobile">전화번호</label></th>
			<td><input type="text" id="mobile" name="mobile"></td>
		</tr>
		<tr>		
			<th><label for="email">이메일</label></th>
			<td><input type="email" id="email" name="email"></td>
		</tr>
		<tr>		
			<th><label for="contents">기타의견</label></th>
			<td><textarea id="contents" name="contents"></textarea></td>
		</tr>
		
	</table>
		
	<div style="margin-top: 30px;">	
	  	<!-- <input type="submit" value="저장"> -->	
		<input type="button" value="ajax로 저장" onclick="ajaxcheck();"><br>
		<a href="main.do"><br>메인페이지로</a>
		
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
 	
 	

	
	
/* 	
	function validation() {
		
		if($("#userId").val() == ){
	 		alert("이미 사용중 입니다.");
	 		return false;
 		}
		else{
			alert("사용 가능합니다.");
		}
	} 
*/
	
	$(document).ready(function(){
	       $('#idCheckBtn').on('click', function(){
	           $.ajax({
	               type: 'POST',
	               url: '/ajax-idChck',
	               data: {
	                   "userId" : $('#userId').val()
	               },
	               success: function(data){
	                   if($.trim(data) == 0){
	                       $('#checkMsg').html('<p style="color:blue">아이디 사용 가능</p>');
	                   }
	                   else{
	                       $('#checkMsg').html('<p style="color:red">이미 사용중인 아이디</p>');
	                   }
	               }
	           });    //end ajax    
	       });    //end on    
	   });


	
	
	function nullCheck() {
		
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
 		else if($('#userType option:selected').val() == null || $('#userType option:selected').val() == ""){
	 		alert("회원구분을 입력하여 주십시오.");
	 		return false;
 		}
 		else if($('input:radio[name=gender]:checked').val() == null || $('input:radio[name=gender]:checked').val() == ""){
	 		alert("성별을 입력하여 주십시오.");
	 		return false;
 		}
 		else if($("#email").val() == null || $("#email").val() == ""){
	 		alert("이메일을 입력하여 주십시오.");
	 		return false;
 		}
 		else{
 			alert("확인되었습니다.");
 		}
		
		
		$('#registerForm').validate({
			rules: {
				userId: { required: true, minlength: 3 },
				password: { required: true },
				userName: { required: true },
				mobile: { required: true },
				userType: { required: true },
				gender: { required: true },
                email: { required: true, email: true },
                contents: { required: false },
            },
            messages: {
            	userId: {
                    required: "아이디를 입력하시오.",
                    minlength: jQuery.format("아이디는 {3}자 이상")
                },
                password: { required: "암호를 입력하시오." },
                userName: { required: "사용자 이름을 입력하시오." },
                mobile: { required: "전화번호를 입력하시오." },
                userType: { required: "회원 구분을 입력하시오." },
                gender: { required: "성별을 입력하시오." },
                email: { required: "이메일주소를 입력하시오.",
                         email: "올바른 이메일주소를 입력하시오." },
            },
            submitHandler: function (frm) {
                frm.submit();
            },
            success: function (e) { 
            //
            }

		});

	}
	
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
				alert("데이터 전송 완료");
			},
			error:function(request, status, error) {
				console.log("code : " + request.status + "\n message : " + request.responseText + "\n error : " + error);
			}
		});
		
		nullCheck();
		
		
	}
	

	
	
</script>


</body>
</html>
