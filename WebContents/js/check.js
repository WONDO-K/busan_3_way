function idCheck() {
	// 사용자 아이디가 입력되었는지 확인 루틴 구현
	if (document.joinform.join_id.value == "") {
		alert("아이디를 입력해주세요.");
		document.joinform.join_id.focus();
		return false;
	}
	// 아이디 중복 체크를 위한 페이지는 새로운 창에 출력한다.(idcheck.jsp)
	var url = "/idcheckservlet?join_id=" + document.joinform.join_id.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function nickCheck() {
	if (document.joinform.join_nickname.value == "") {
		alert("닉네임을 입력해주세요.");
		document.joinform.join_nickname.focus();
		return false;
	}
	
	var url = "/nickcheckservlet?join_nickname=" + document.joinform.join_nickname.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function emailCheck() {
	if (document.joinform.join_email.value == "") {
		alert("이메일을 입력해주세요.");
		document.joinform.join_email.focus();
		return false;
	}
	
	var url = "/emailcheckservlet?join_email=" + document.joinform.join_email.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}