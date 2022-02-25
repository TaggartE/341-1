public class AppDriver {

	public static void main(String[] args) {
		AppController app = new AddressAppController();
		app.setView("gui");
		app.run();
	}
}
