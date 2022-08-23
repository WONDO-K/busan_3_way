/**
회원정보 입력 필수 입력 사항 확인
이름, 아이디, 암호, 암호확인
아이디 4글자 이상
암호와 암호확인이 일치 확인
re id의 값이 존재하는지 확인하여 중복체크여부를 검사
 */

function joinCheck() {
	
	if (joinform.join_id.value == "") {
		alert("아이디를 입력해주세요.");
		joinform.join_id.focus();
		return false;
	}
	
	if (joinform.join_id.value.length < 4) {
		alert("아이디는 4글자 이상이어야 합니다.");
		joinform.join_id.focus();
		return false;
	}
	
	if (joinform.id_check_font.value == "") {
		alert("아이디 중복체크를 하지 않았습니다.");
		return false;
	}
	
	if (joinform.join_pw.value == "") {
		alert("비밀번호를 입력해주세요.");
		joinform.join_pw.focus();
		return false;
	}

	if (joinform.join_pwc.value == "") {
		alert("비밀번호를 확인해주세요.");
		joinform.join_pwc.focus();
		return false;
	}
	
	if (joinform.join_pw.value != document.joinform.join_pwc.value) {
		alert("비밀번호가 일치하지 않습니다.");
		joinform.join_pwc.focus();
		return false;
	}
	
	if (joinform.join_name.value == "") {
		alert("이름을 입력해주세요.");
		joinform.join_name.focus();
		return false;
	}
	
	if (joinform.join_birth.value == "") {
		alert("생년월일를 입력해주세요.");
		joinform.join_birth.focus();
		return false;
	}
	
	if (joinform.join_nickname.value == "") {
		alert("닉네임을 입력해주세요.");
		joinform.join_nickname.focus();
		return false;
	}
	
	if (joinform.join_email.value == "") {
		alert("이메일을 입력해주세요.");
		joinform.join_email.focus();
		return false;
	}
	
	if (joinform.join_tel.value == "") {
		alert("전화번호를 입력해주세요.");
		joinform.join_tel.focus();
		return false;
	}
	
	if (joinform.join_address.value == "") {
		alert("주소를 입력해주세요.");
		joinform.join_address.focus();
		return false;
	}

	return true;
}