package appPackage;

import java.util.Queue;

public class AppInterfaces {
	
	
	interface Customer{
		String getFName();
		String getLInitial();
		int getApptStatus();
		String getReason();
		
	}
	
	interface Staffer{
		void displayCustomer(Queue<String>q);
	}
	
	interface Controller{
		void appInit();
		void run();
	}
	
	interface GUIHandler{
		int MakeIntPrompt(String prompt);
		String MakeStringPrompt(String prompt);
		void MakeErrorPrompt();
		boolean inputIntVerify(int[] correctEntries,int entry);
		void makeCustomerPrompt(String customer);
		void makePrompt(String prompt);
		
	}

}
