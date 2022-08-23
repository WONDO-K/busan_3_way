/**
 * 로그인 처리 현황
1. 아이디와 암호 모두 입력되었을 때만 로그인 인증 처리 수행
2. 입력이 안되면 알림창으로 에러 메시지 출력
 */

function loginCheck(){
	if (document.loginform.input_id.value == ""){
		alert("아이디를 입력해 주세요.");
		document.loginform.input_id.focus();
		return false;
	} else if (document.loginform.input_pwd.value == ""){
		alert("비밀번호를 입력해주세요.");
		document.loginform.input_pwd.focus();
		return false;
	} else {
		return true;
	}
}



/*$(function() {
         
           fnInit();
         
     });
     
     function frm_check(){
         saveid();
     }
 
    function fnInit(){
        var cookieid = getCookie("saveid");
        console.log(cookieid);
        if(cookieid !=""){
            $("#stay-checkbox").prop("checked", true);
            $('#input_id').val(cookieid);
        }
        
    }    
 
    function setCookie(name, value, expiredays) {
        var todayDate = new Date();
        todayDate.setTime(todayDate.getTime() + 0);
        if(todayDate > expiredays){
            document.cookie = name + "=" + escape(value) + "; path=/; expires=" + expiredays + ";";
        }else if(todayDate < expiredays){
            todayDate.setDate(todayDate.getDate() + expiredays);
            document.cookie = name + "=" + escape(value) + "; path=/; expires=" + todayDate.toGMTString() + ";";
        }
        
        
        console.log(document.cookie);
    }
 
    function getCookie(Name) {
        var search = Name + "=";
        console.log("search : " + search);
        
        if (document.cookie.length > 0) { // 쿠키가 설정되어 있다면 
            offset = document.cookie.indexOf(search);
            console.log("offset : " + offset);
            if (offset != -1) { // 쿠키가 존재하면 
                offset += search.length;
                // set index of beginning of value
                end = document.cookie.indexOf(";", offset);
                console.log("end : " + end);
                // 쿠키 값의 마지막 위치 인덱스 번호 설정 
                if (end == -1)
                    end = document.cookie.length;
                console.log("end위치  : " + end);
                
                return unescape(document.cookie.substring(offset, end));
            }
        }
        return "";
    }
 
    function saveid() {
        var expdate = new Date();
        if ($("#stay-checkbox").is(":checked")){
            expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 30);
            setCookie("saveid", $("#input_id").val(), expdate);
            }else{
            expdate.setTime(expdate.getTime() - 1);
            setCookie("saveid", $("#input_id").val(), expdate);
             
        }
    }*/