// JavaScript Document
$.validator.setDefaults({
	submitHandler: function() { document.frmAddConfig.submit(); }
});

$().ready(function() {
	// validate signup form on keyup and submit
	$("#frmAddConfig").validate({
		rules: {
			paramName: "required",
			paramValue:"required"
		},
		messages: {
			paramName: "Please enter configuration parameter name",
			paramValue:"Please enter configuration parameter value"
		}
	});

	
});