function check() {
	if(document.regForm.empName.value === "") {
		alert('사원이름을 입력하세요!');
		document.regForm.empName.focus();
		return false;
	}
	
	document.regForm.submit();
}