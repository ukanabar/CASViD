$.validator.setDefaults({
	submitHandler: function() { document.frmAddCustomer.submit(); }
});

$().ready(function() {
	// validate signup form on keyup and submit
	$("#frmAddCustomer").validate({
		rules: {
			firstName: "required",
			lastName: "required",			
			email: {
				required: true,
				email: true
			}
			
		},
		messages: {
			firstName: "Please enter your firstname",
			lastName: "Please enter your lastname",			
			email: "Please enter a valid email address"
			
		}
	});

	

	
});