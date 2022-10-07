package phoneList;

import java.util.Scanner;

import notes01_basic_objects.Student;

import java.util.ArrayList;

/*
 * Phone List
 * 
 * You'll be using an ArrayList of Contact objects
 * to crate a digital address book.
 * 
 * You MUST
 *   - Use an ArrayList
 *   - Keep list in alphabetical order
 *   - Complete the 
 *   
 * You May
 *   - Add methods as you see fit
 *   - Change method parameters and return types
 *   
 * You May NOT
 *   - change the menu method
 *        unless you're changing what methods it calls
 * 
 */


public class PhoneList {

	/*
	 * Instance Variables
	 */
	private static String name;
	private static int num;
	
	
	//Constructor
	public PhoneList(String lname,int lnum) {
		//initialize instance variables
		this.name = lname;
		this.num = lnum;
	}
	
	ArrayList<Contact> phonelist = new ArrayList<Contact>();
	
	
	/*
	 * This should do the following
	 * (whatever order you feel is best)
	 *   - ask the user for contact's name and number
	 *   - create a new Contact object with that input
	 *   - add that object to the phone list
	 *        in alphabetical order
	 *        Hint: compareTo(String other)
	 *   - tell the user what the new contact is and that 
	 *        it's been added
	 */
	public void addContact() {
		
		Scanner inKey = new Scanner(System.in);
		Scanner inKey1 = new Scanner(System.in);
		
		System.out.print("Contact Name?");  //prompt the user
		String nam = inKey.nextLine();	// store
		System.out.print("Contact Number?");  //prompt the user
		int number = inKey1.nextInt();	 // store
		
		Contact con = new Contact(nam, number);
		
		if (phonelist.size() == 0) {
			phonelist.add(con);
		}
		else {
			boolean added = false;
			for (int i = 0; i < phonelist.size(); i++) {
				if (phonelist.get(i).getName().compareToIgnoreCase(con.getName()) >= 0) {
					phonelist.add(i, con);
					added = true;
					break;
				}
			}
			if (!added) {
				phonelist.add(con);
			}
		}
		
		System.out.println("A new contact has been added\n" + con.toString());

	}
	
	
	
	/*
	 * This should do the following
	 * (whatever order you feel is best)
	 *   - ask the user for the contact's name
	 *   - search through the list for that contact
	 *   - if the contact is not found
	 *        tell the user and end the method
	 *   - if the contact is found
	 *        Remove the item from the list
	 *        Print the contact's name and number
	 *        Say that contact has been removed
	 *        Remove the item from the list
	 *        
	 */
	public void removeContact() {
		
		Scanner inKey1 = new Scanner(System.in);
		System.out.print("Contact Name?");  //prompt the user
		String nam = inKey1.nextLine();	// store
		
		boolean found = false;
		for (int i = 0; i < phonelist.size(); i++) {
			if (phonelist.get(i).getName().compareToIgnoreCase(nam) == 0) {
				found = true;
				phonelist.get(i).toString();
				System.out.println("Contact has been removed");
				phonelist.remove(i);
				break;
			}
		}
		if (!found) {
			System.out.println("Contact not found");
		}
	
		
	}
	
	
	/*
	 * This should
	 *   - Print all items in list
	 *   - Must be headers for all columns
	 *   - print in alphabetical order
	 *   - print line of something to "box" the list
	 *       Examples:
	 *          *****************
	 *          -----------------
	 *          #################
	 */
	public void printList() {
		
		System.out.println("-----------------");
		for (int i = 0; i < phonelist.size(); i++) {
			phonelist.get(i).toString();
			}
		
	}

	
	
	/*
	 * GET FAMILIAR WITH THIS MENU!!!!
	 * 
	 * I will be asking you to create programs with menus.
	 * You may do them however you like.  But here is an example
	 * of how to manage them.
	 * 
	 */
	public void menu() {
		
		int input = 0;
		
		String menu = "-----------------------\n"
				    + "     Contacts Menu     \n"
				    + "-----------------------\n"
				    + "  1 - Add Contact      \n"
				    + "  2 - Remove Contact   \n"
				    + "  3 - Print List       \n"
				    + "  4 - Quit             \n\n"
				    + "Enter Choice: ";
		
		while (input != 4) {  //keep looping till user want's to quit
			
			//try getting an input
			try {
				String inputString = getString("\n" + menu);  //get input
				input = Integer.valueOf(inputString);  //try converting to int
			}
			catch (Exception e) {
				//if bad input, set input to 0
				input = 0;  
			}
		
			switch (input) {
			case 1:
				//handle menu line 1: Add Contact
				addContact();
				break;
			case 2:
				//handle menu line 2: Remove Contact
				removeContact();
				break;
			case 3:
				//handle menu line 3: Print List
				printList();
				break;
			case 4:
				//handle menu line 4: Quit
				System.out.println("\nGoodbye!");
				break;
			default:
				System.out.println("\nNot a valid input.\n"
								 + "Please try again.");
			}
			
			
		
		}
		
	}
	
	public String getString(String str) {
		
		Scanner inKey = new Scanner(System.in);
		System.out.print(str);  //notice it's NOT a print line.  This way input is next to question.
		return inKey.nextLine();
		
	}
	
	
	public static void main(String[] args) {
		PhoneList app = new PhoneList(name, num);
		app.menu();
	}
}
