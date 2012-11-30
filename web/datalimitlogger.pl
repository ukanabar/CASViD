#!/usr/bin/perl
# To Copy Paste Ctrl+Insert and Shift+Insert
use DBI;
my $host = "localhost";
my $database =  "casvid";
my $user     = "root";
my $password = "";
my $dbh = DBI->connect('DBI:mysql:'.$database.':'.$host,$user,$password) or die "Cannot connect:".$DBI::errstr;
my $cost = 5;
my $sth = $dbh->prepare('select cv.vm_id,cv.vm_name,cs.slaparam_id,cs.sla_id,cs.app_id,cs.sla_threatvalue,cs.sla_violationvalue from casvid_vms cv,casvid_slas cs,casvid_slaparameters csp
where csp.slaparam_id = cs.slaparam_id and cv.vm_id=cs.vm_id and csp.slaparam_name = "datalimit"') || die "$DBI::errstr";
				$sth->execute();
					if ($sth->rows > 0) {	
						while (my $results = $sth->fetchrow_hashref) {
							my $sth1 = $dbh->prepare('select sum(bytes) as bytes from `'.$results->{vm_name}.'` where month(moniter_date)=MONTH(NOW())');
							$sth1->execute();
							if($sth1->rows>0){
								while (my $results1 = $sth1->fetchrow_hashref) {
								    #Adjusting bandwidth as xentop adds some extra bytes of tcp/ip header + pipe + ssh connection 
									$downloadedbytes = 0.938 * $results1->{bytes};
									#Violation Value checking
									if($downloadedbytes>=$results->{sla_violationvalue}){
										my $limitdiff = $downloadedbytes - $results->{sla_violationvalue};
										my $totalcost = $limitdiff * $cost;
										my $strQ1 = 'INSERT INTO casvid_slaviolations (`vm_id`, `app_id`, `slaparam_id`, `slaviolation_type`, `slaviolation_paramvalue`, `slaviolation_cost`, `slaviolation_date`, `sla_violation_desc`) VALUES ('.$results->{vm_id}.', '.$results->{app_id}.', '.$results->{slaparam_id}.',"violation",'.$limitdiff.','.$totalcost.',now(),"data limit constraint violation value crossed")';
										$dbh->do($strQ1);
									}							
									elsif($downloadedbytes>=$results->{sla_threatvalue}){
										#Threat Value checking
										my $strQ1 = 'INSERT INTO casvid_slaviolations (`vm_id`, `app_id`, `slaparam_id`, `slaviolation_type`, `slaviolation_paramvalue`, `slaviolation_cost`, `slaviolation_date`, `sla_violation_desc`) VALUES ('.$results->{vm_id}.', '.$results->{app_id}.', '.$results->{slaparam_id}.',"threat",0,0,now(),"data limit constraint threat value crossed")';					
										$dbh->do($strQ1);
									} 
								}		
							}	
					}
				}	
