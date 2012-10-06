// JavaScript Document
$.validator.setDefaults({
	submitHandler: function() { document.frmAddApplication.submit(); }
});

$().ready(function() {
	// validate signup form on keyup and submit
	$("#frmAddApplication").validate({
		rules: {
			appName: "required",
			appDesc: {
				required: true,
				minlength:50
				
			}
		},
		messages: {
			appName: "Please enter application name",
			appDesc: {
				required: "Please enter application description",
				minlength: jQuery.format("Please enter at least {0} characters")				
			}
		}
	});

	
});