$.validator.setDefaults({
	submitHandler: function() { document.frmAddVm.submit(); }
});

$().ready(function() {
	// validate signup form on keyup and submit
	$("#frmAddVm").validate({
		rules: {
			vmName: "required",
                        vmDesc: "required",
                        ip: "required",
                        hostname: "required",
			port: {
				required: true,
				port: true
			},
                        macaddress:"required"		
			
		},
		messages: {
			vmName: "Please enter Vm name",
			vmDesc: "Please enter Vm Description",			
			ip: "Please enter ip address for Vm",
                        hostname:"Please enter hostname for Vm",
                        port:"Please enter valid port",
                        macaddress:"Please end mac address for vm"
			
		}
	});

	

	
});