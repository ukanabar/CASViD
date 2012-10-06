// JavaScript Document
$.validator.setDefaults({
	submitHandler: function() { document.frmAddSlaParam.submit(); }
});

$().ready(function() {
	// validate signup form on keyup and submit
	$("#frmAddSlaParam").validate({
		rules: {
			slaParamName: "required",
			slaParamUnit: "required",
			slaParamDesc: {
				required: true,
				minlength:50
				
			}
		},
		messages: {
			slaParamName: "Please enter SLA parameter name",
			slaParamUnit: "Please enter SLA parameter unit",
			slaParamDesc: {
				required: "Please enter  SLA parameter description",
				minlength: jQuery.format("Please enter at least {0} characters")				
			}
		}
	});

	
});