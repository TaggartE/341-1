package appPackage;

import appPackage.AppInterfaces.Customer;

public class ServiceCustomerOps implements Customer {
	ServiceGUIOps GUI;
	
	ServiceCustomerOps(){
		GUI=new ServiceGUIOps();
	}

	@Override
	public String getFName() {
		String toreturn="";
		toreturn=GUI.MakeStringPrompt("Enter First Name");
		return toreturn;
	}

	@Override
	public String getLInitial() {
		String toreturn="";
		toreturn=GUI.MakeStringPrompt("Enter Last Initial");
		return toreturn;
	}

	@Override
	public int getApptStatus() {
		boolean correctInput=false;
		int choice=0;;
		while(!correctInput) {
			choice=GUI.MakeIntPrompt("Do you have an appointment? Yes(1) No(2)");
			correctInput=GUI.inputIntVerify(new int[] {1,2}, choice);
		}
		
		return choice;
	}

	@Override
	public String getReason() {
		boolean correctInput=false;
		int choice=0;;
		while(!correctInput) {
			choice=GUI.MakeIntPrompt("What brings you in today? Select your reason\n"
					+ "1. TV Service\n"
					+ "2. Internet Service\n"
					+ "2. Cell Phone Service\n"
					+ "4. Stream Service\n"
					+ "5. Other");
			correctInput=GUI.inputIntVerify(new int[] {1,2,3,4,5}, choice);
		}
		String reason="";
		switch(choice) {
		case 1:
			reason="TV Service";
			break;
		case 2:
			reason="Internet Service";
			break;
		case 3:
			reason="Cell Phone Service";
			break;
		case 4:
			reason="Stream Service";
			break;
		case 5:
			reason="Other";
			break;
		default:
			reason="Other";
			break;
		}
		return reason;
	}

}
