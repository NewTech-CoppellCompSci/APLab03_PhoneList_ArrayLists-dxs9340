package phoneList;

/*
 * This contains info for a single contact
 * 
 * Parameters Needed to Store
 *   - Contact's Name
 *   - Contact's Phone Number
 *   
 * Needed Methods
 *   - Constructor(s)
 *   - getter methods
 *   - Setter methods not necessary unless Constructor
 *        initialize variables.
 *   - Override toString() so that Contact can
 *        be printed as part of a list.
 * 
 */



public class Contact {

	private String name; 
	private double phonenumber;
	
	public Contact (String name, double phonenumber) {
		this.name = name;  
		this.phonenumber = phonenumber;
	}
	
	public String getName() {
		return name;
	}
	
	public double getphonenumber() {
		return phonenumber;
	}
	
	public String toString() {
		return "Name: " + name 
				+ "\nPhone Number: " + phonenumber;
	}
	
	
}
