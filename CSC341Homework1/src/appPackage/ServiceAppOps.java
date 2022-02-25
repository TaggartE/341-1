package appPackage;

import java.util.LinkedList;
import java.util.Queue;

import appPackage.AppInterfaces.Controller;

public class ServiceAppOps implements Controller {
	
	ServiceGUIOps GUI;
	Queue<String>apptQ;
	Queue<String>nonApptQ;
	
	
	ServiceAppOps(){
		appInit();
	}

	@Override
	public void appInit() {
		apptQ = new LinkedList<String>();
		nonApptQ = new LinkedList<String>();
		GUI=new ServiceGUIOps();
		run();
		
	}

	@Override
	public void run() {
		int choice=0;
		do {
			//first get customer or staffer option
			boolean correctEntry=false;
			while(!correctEntry) {
				choice=GUI.MakeIntPrompt("Are you a customer (1) or staffer (2)? Quit(0)");
				correctEntry=GUI.inputIntVerify(new int[] {1,2,0},choice);
			}
			//correct entry made. take input to customer or staffer
			switch(choice) {
			case 1:
				customer();
				break;
			case 2:
				staffer();
				break;
			case 0:
				System.exit(0);
			default:
				GUI.MakeErrorPrompt();
			}
			
		}while(true);
		
	}
	
	public void customer() {
		ServiceCustomerOps customer = new ServiceCustomerOps();
		String firstName=customer.getFName();
		String lastInitial=customer.getLInitial();
		int apptStatus=customer.getApptStatus();
		String reason=customer.getReason();
		
		//add customer info to corresponding queue using appointment status
		if(apptStatus==1) {
			apptQ.add(firstName+" "+lastInitial+" needs "+reason);
		}
		else {
			nonApptQ.add(firstName+" "+lastInitial+" needs "+reason);
		}
	}
	
	public void staffer() {
		ServiceStafferOps staffer = new ServiceStafferOps();
		if(apptQ.isEmpty()) {
			staffer.displayCustomer(nonApptQ);
		}
		else {
			staffer.displayCustomer(apptQ);
		}
	}

}
