$(function() {
	$('#joinbtn').on('click', function() {
		if ($('#id').val() == "") {
			alert('아이디를 입력해주세요');
			$('#id').focus();
			return false;
		}
		if ($('#password').val() == "") {
			alert('패스워드를 입력해주세요');
			$('#password').focus();
			return false;
		}
		if ($('#name').val() == "") {
			alert('이름을 입력해주세요');
			$('#name').focus();
			return false;
		}
		if ($('#email').val() == "") {
			alert('이메일을 입력해주세요');
			$('#email').focus();
			return false;
		}
	})
});