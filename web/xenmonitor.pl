#!/usr/bin/perl
# To Copy Paste Ctrl+Insert and Shift+Insert
use DBI;
my $loop = 0;
my %last;
my $XMTOP               = '/usr/sbin/xentop';
my $host = "localhost";
my $database =  "casvid";
my $user     = "root";
my $password = "";
my $dbh = DBI->connect('DBI:mysql:'.$database.':'.$host,$user,$password) or die "Cannot connect:".$DBI::errstr;
my $cost = 5;

my %val; undef (%vals);
while(++$loop){

@chunks = split(/^xentop - .*$/m, `$XMTOP -b -i2 -d2`);
    my @stats = split (/\n/,pop(@chunks));

    # remove the first 4 items that are junk that we don't need.
    shift(@stats); 
    shift(@stats); 
    shift(@stats); 
    shift(@stats); 

     
    foreach my $domain (@stats) {
        # trim the leading whitespace and break into an array for later use
        $domain =~ s/^\s+//;
        my @v_tmp = split(" ", $domain);
        $vals{"name"} = $v_tmp[0];
		#if($vals{"name"}!='Domain-0'){
		$vals{$vals{"name"}}{"state"} = $v_tmp[1]; 
		$vals{$vals{"name"}}{"cpu_sec"} = $v_tmp[2];
		$vals{$vals{"name"}}{"cpu_pct"} = $v_tmp[3];
		$vals{$vals{"name"}}{"mem"} = $v_tmp[4];
		$vals{$vals{"name"}}{"mem_pct"} = $v_tmp[5];
		$vals{$vals{"name"}}{"max_mem"} = $v_tmp[6];
		$vals{$vals{"name"}}{"max_mem_pct"} = $v_tmp[7];
		$vals{$vals{"name"}}{"vcpus"} = $v_tmp[8]; 
		$vals{$vals{"name"}}{"nets"} = $v_tmp[9]; 
		$vals{$vals{"name"}}{"nettx"} = $v_tmp[10];
		$vals{$vals{"name"}}{"bytes"} = 0;
		$vals{$vals{"name"}}{"prevdatetime"} = 0;
		my $sth = $dbh->prepare('SELECT nettx,bandwidth,moniter_date FROM `'.$vals{"name"}.'` order by moniter_date desc limit 1') || die "$DBI::errstr";
		$sth->execute();
		
		# If table is empty
		if ($sth->rows < 0) {
		$vals{$vals{"name"}}{"bytes"} = 0;
		$vals{$vals{"name"}}{"prevdatetime"} = 0;	
		    
		} else {
		    # Loop if results found
		    while (my $results = $sth->fetchrow_hashref) {
				#bytes are in mega bytes unit
				$vals{$vals{"name"}}{"bytes"} = ($v_tmp[10] - $results->{nettx})/1024;
				$vals{$vals{"name"}}{"prevdatetime"} = $results->{moniter_date};
				$vals{$vals{"name"}}{"bandwidth"} = $results->{bandwidth};
				#Getting service level agreement from defined Virtual Machine
				my $sth1 = $dbh->prepare('select cv.vm_id,cv.vm_name,cs.slaparam_id,cs.sla_id,cs.app_id,cs.sla_threatvalue,cs.sla_violationvalue from casvid_vms cv,casvid_slas cs,casvid_slaparameters csp
	where csp.slaparam_id = cs.slaparam_id and cv.vm_id=cs.vm_id and cv.vm_name="'.$vals{"name"}.'" and csp.slaparam_name = "bandwidth"') || die "$DBI::errstr";
				$sth1->execute();
					if ($sth1->rows < 0) {
					
					} else {
						while (my $results = $sth1->fetchrow_hashref) {
							#Violation Value checking
							if($vals{$vals{"name"}}{"bandwidth"}>=$results->{sla_violationvalue}){
								my $bandwidthdiff = $vals{$vals{"name"}}{"bandwidth"} - $results->{sla_violationvalue};
								my $totalcost = $bandwidthdiff * $cost;
								my $strQ1 = 'INSERT INTO casvid_slaviolations (`vm_id`, `app_id`, `slaparam_id`, `slaviolation_type`, `slaviolation_paramvalue`, `slaviolation_cost`, `slaviolation_date`, `sla_violation_desc`) VALUES ('.$results->{vm_id}.', '.$results->{app_id}.', '.$results->{slaparam_id}.',"violation",'.$bandwidthdiff.','.$totalcost.',now(),"bandwith constraint violation value crossed")';
								$dbh->do($strQ1);
							}							
							elsif($vals{$vals{"name"}}{"bandwidth"}>=$results->{sla_threatvalue}){
								#Threat Value checking
								my $strQ1 = 'INSERT INTO casvid_slaviolations (`vm_id`, `app_id`, `slaparam_id`, `slaviolation_type`, `slaviolation_paramvalue`, `slaviolation_cost`, `slaviolation_date`, `sla_violation_desc`) VALUES ('.$results->{vm_id}.', '.$results->{app_id}.', '.$results->{slaparam_id}.',"threat",0,0,now(),"bandwith constraint threat value crossed")';					
								$dbh->do($strQ1);
							} 					
						}		
				
				}					
		    }
		}
	
		#$last{$vals{"name"}} = $vals{$vals{"name"}}{"nettx"}; 
		$vals{$vals{"name"}}{"netrx"} = $v_tmp[11]; 
		$vals{$vals{"name"}}{"vbds"} = $v_tmp[12]; 
		$vals{$vals{"name"}}{"vbd_oo"} = $v_tmp[13]; 
		$vals{$vals{"name"}}{"vbd_rd"} = $v_tmp[14]; 
		$vals{$vals{"name"}}{"vbd_wr"} = $v_tmp[15]; 
		$vals{$vals{"name"}}{"ssid"} = $v_tmp[16];
		
		#Adding domain data to it's relavant table
		my $strQuery = 'INSERT INTO `'.$vals{"name"}.'` (`state`, `cpu_sec`, `cpu_percent`, `memory`, `memory_percent`, `maximum_memory`, `maximum_memory_percent`, `vcpus`, `nets`, `nettx`, `netrx`, `bytes`, `seconds`, `bandwidth`, `vbds`, `vbd_oo`, `vbd_rd`, `vbd_wr`, `ssid`, `moniter_date`) VALUES ("'.$vals{$vals{"name"}}{"state"}.'",'.$vals{$vals{"name"}}{"cpu_sec"}.','.$vals{$vals{"name"}}{"cpu_pct"}.','.$vals{$vals{"name"}}{"mem"}.','.$vals{$vals{"name"}}{"mem_pct"}.',"'.$vals{$vals{"name"}}{"max_mem"}.'","'.$vals{$vals{"name"}}{"max_mem_pct"}.'","'.$vals{$vals{"name"}}{"vcpus"}.'",'.$vals{$vals{"name"}}{"nets"}.','.$vals{$vals{"name"}}{"nettx"}.','.$vals{$vals{"name"}}{"netrx"}.','.$vals{$vals{"name"}}{"bytes"}.',TIME_TO_SEC(TIMEDIFF(now(),"'.$vals{$vals{"name"}}{"prevdatetime"}.'")),('.$vals{$vals{"name"}}{"bytes"}.'/(TIME_TO_SEC(TIMEDIFF(now(),"'.$vals{$vals{"name"}}{"prevdatetime"}.'")))),'.$vals{$vals{"name"}}{"vbds"}.','.$vals{$vals{"name"}}{"vbd_oo"}.','.$vals{$vals{"name"}}{"vbd_rd"}.','.$vals{$vals{"name"}}{"vbd_wr"}.','.$vals{$vals{"name"}}{"ssid"}.',now())';
		
			
		
		#open (MYFILE, '>>data.txt'); 
		#print MYFILE "$strQuery\n";
		#close (MYFILE);			
		print "$strQuery\n";		
		my $rows = $dbh->do($strQuery);
		if($rows>0){
			print "record inserted\n";
		}
		#print "$rows row(s) affected\n";
		

		# Disconnect	
		#$sth->finish;
		#$dbh->disconnect;

	#SELECT nettx,moniter_date FROM `ubuntu12-g` order by moniter_date desc limit 1
	#INSERT INTO `ubuntu12-g` (`id`, `state`, `cpu_sec`, `cpu_percent`, `memory`, `memory_percent`, `maximum_memory`, `maximum_memory_percent`, `vcpus`, `nets`, `nettx`, `netrx`, `bytes`, `seconds`, `bandwidth`, `vbds`, `vbd_oo`, `vbd_rd`, `vbd_wr`, `ssid`, `moniter_date`) VALUES (1, '', '', '', '', '', '', '', '', '', '', '', '123', '10', '12.3', '', '', '', '', '', '2012-11-30 07:18:20')
	
        #}
     }
sleep 8;	
}	
