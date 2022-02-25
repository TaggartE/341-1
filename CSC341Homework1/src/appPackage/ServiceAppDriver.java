package appPackage;

import appPackage.AppInterfaces.Controller;

public class ServiceAppDriver {
	public static void main(String[]args) {
		Controller app = new ServiceAppOps();
		app.run();
	}
}
