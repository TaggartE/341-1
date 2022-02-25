package appPackage;

import appPackage.AppInterfaces.GUIHandler;
import javax.swing.*;

public class ServiceGUIOps implements GUIHandler {
	
	ServiceGUIOps() {
		
	}

	@Override
	public int MakeIntPrompt(String prompt) {
		int toreturn=0;
		toreturn=Integer.parseInt(JOptionPane.showInputDialog(prompt));
		return toreturn;
	}

	@Override
	public String MakeStringPrompt(String prompt) {//only used to enter first and last name
		String toreturn="";
		toreturn=JOptionPane.showInputDialog(prompt);
		return toreturn;
	}

	@Override
	public boolean inputIntVerify(int[] correctEntries,int entry) {//any int input must be verified 
		for(int i = 0;i<correctEntries.length;i++) {
			if(entry==correctEntries[i])return true;
		}
		MakeErrorPrompt();
		return false;
	}

	@Override
	public void MakeErrorPrompt() {
		JOptionPane.showMessageDialog(null, "You Entered an Invalid Input!","ERROR!", JOptionPane.ERROR_MESSAGE);
		
	}

	@Override
	public void makeCustomerPrompt(String customer) {
		JOptionPane.showMessageDialog(null, customer,"Customer Retrieval Tool", JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void makePrompt(String prompt) {
		JOptionPane.showMessageDialog(null, prompt,"Information Box", JOptionPane.INFORMATION_MESSAGE);
		
	}


}
