$.validator.setDefaults({
	submitHandler: function() { document.frmAddUser.submit(); }
});

$().ready(function() {
	// validate signup form on keyup and submit
	$("#frmAddUser").validate({
		rules: {
			userName: "required",
			password: {
				required: true,
				minlength: 5
			},
			cpassword: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},	
			email: {
				required: true,
				email: true
			}
		},
		messages: {
			userName: "Please enter your username",
			password: {
				required: "Please enter a password",
				rangelength: jQuery.format("Please enter at least {0} characters")
			},
			cpassword: {
				required: "Please enter same as your password",
				minlength: jQuery.format("Please enter at least {0} characters"),
				equalTo: "Please enter the same password as above"
			},		
			email: "Please enter a valid email address"
		}
	});

	

	
});