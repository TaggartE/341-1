import java.util.*;
import javax.swing.*;

class AddressAppController implements AppController{
	AppView view;
	IAddressBook book;
	IDataHandler handler;
	String input, viewName;
	
	AddressAppController(){
		appInit();
	}

	@Override
	public void setView(String name) {
		this.viewName = name; 
		if(viewName.equalsIgnoreCase("console"))
			view = new ConsoleAppView(book);
		else if(viewName.equalsIgnoreCase("gui"))
			view = new GUIAppView(book);
		else view = null;
		if(view != null){
			view.display( "Current names \n" + ((AddressBook) book).getKeyset().toString() );
		}
		else System.exit(1);
	}
	
	@Override
	public void appInit() {
		book = new AddressBook();
		handler = new DataHandler(book);
		handler.getData("addresses.txt");
	}

	@Override
	public void run() {
		do{
			input = view.getInput("Add (a), Retrieve (r) an address, or quit (q)? ");
			if(input.equalsIgnoreCase("a")){
				String name = view.getInput("Enter name --> ");
				String address = view.getInput("Enter address --> ");
				book.add(name, address);
				view.display("Current names in the book:");
				view.display( ((AddressBook) book).getKeyset().toString()); 
			}
			else if(input.equalsIgnoreCase("r")){
				input = view.getInput("Enter name --> ");
				view.display("Address: " + view.getResult() + "\n-----");
			}
			else {
				handler.saveData("addresses.txt");
				break; 
			}
		}while(true);		
	}
}

class ConsoleAppView implements AppView {
	private Scanner sc;
	String input;
	IAddressBook book;
	
	ConsoleAppView(IAddressBook b){
		book = b;
		sc = new Scanner(System.in);
	}
	
	@Override
	public String getInput(String prompt) {
		System.out.println(prompt);
		input = sc.nextLine();
		//input = JOptionPane.showInputDialog(prompt);
		return input;
	}

	@Override
	public String getResult() {
		String result = book.getAddress(input.trim());
		return result;
	}

	@Override
	public void display(String msg) {
		//JOptionPane.showMessageDialog(null, msg );
		System.out.println(msg);		
	}
}

class GUIAppView implements AppView{
	String input;
	IAddressBook book;
	JTextArea area;
	
	GUIAppView(IAddressBook b){
		book = b;
		getFrame("diaplay frame").setVisible(true);
	}
	
	JFrame getFrame(String title){
		JFrame frame = new JFrame(title);
		area = new JTextArea();
		frame.add(area);
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		return frame;
	}

	@Override
	public String getInput(String prompt) {
		input = JOptionPane.showInputDialog(prompt).trim();
		return input;
	}

	@Override
	public String getResult() {
		String result = book.getAddress(input.trim());
		return result;
	}

	@Override
	public void display(String msg) {
		area.append("\n" + msg);		
	}	
}
