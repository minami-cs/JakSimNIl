$(function() {
	$('#loginbtn').on('click', function() {
		if ($('#login_id').val() == "") {
			alert('아이디를 입력해주세요');
			$('#id').focus();
			return false;
		}
		if ($('#login_pass').val() == "") {
			alert('패스워드를 입력해주세요');
			$('#login_pass').focus();
			return false;
		}
	})
});