$(function() {
	$('#deletebtn').on('click', function() {
		var result = confirm("게시글이 완전히 삭제됩니다. 삭제하시겠습니까?")
		if (result) {
			return true;
		} else {
			return false;
		}
	})
});