package appPackage;

import java.util.Queue;

import appPackage.AppInterfaces.Staffer;

public class ServiceStafferOps implements Staffer {
	
	ServiceGUIOps GUI;
	
	public ServiceStafferOps() {
		GUI = new ServiceGUIOps();
	}



	@Override
	public void displayCustomer(Queue<String> q) {
		if(q.isEmpty()) {
			GUI.makePrompt("You have no waiting customers! Go take a break!");
			return;
		}
		GUI.makeCustomerPrompt(q.peek());
		q.poll();
		
	}
	
	

}
