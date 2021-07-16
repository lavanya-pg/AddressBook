package address;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class AddressBook {

	HashMap<String, ArrayList<Contact>> addressBooks = new HashMap<>();
	ArrayList<Contact> allContacts = new ArrayList<Contact>();
	Scanner scanner = new Scanner(System.in);

	public Contact addContact() 
	{
		Contact contact = new Contact();
		System.out.println("Enter First Name");
		contact.setFirstName(scanner.next());
		System.out.println("Enter Last Name");
		contact.setLastName(scanner.next());
		System.out.println("Enter City");
		contact.setCity(scanner.next());
		System.out.println("Enter State");
		contact.setState(scanner.next());
		System.out.println("Enter Pincode");
		contact.setZip(scanner.next());
		System.out.println("Enter Phone Number");
		contact.setPhoneNumber(scanner.next());
		System.out.println("Enter Email");
		contact.setEmail(scanner.next());
		System.out.println("Enter Book name to which you have to add contact");
		String bookName = scanner.next();

		if (addressBooks.containsKey(bookName)) 
		{
			ArrayList<Contact> contactList = addressBooks.get(bookName);
			addContactToExsistingBook(contact, bookName, contactList);
		} else {
			// creating a new book and list
			allContacts.add(contact);
			addressBooks.put(bookName, allContacts);
			System.out.println("New book created and Contact Added Sucessfully");
		}

		return contact;
	}

	/**
	 * Method to Edit contact using unique phoneNumber
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public boolean editContact(String phoneNumber) {
		for (Contact contact : allContacts) {
			if (contact.getPhoneNumber() == phoneNumber) {
				System.out.println("Enter First Name");
				String firstName = scanner.next();
				System.out.println("Enter last Name");
				String lastName = scanner.next();
				System.out.println("Enter City");
				String city = scanner.next();
				System.out.println("Enter State");
				String state = scanner.next();
				System.out.println("Enter zip");
				String zip = scanner.next();
				contact.setFirstName(firstName);
				contact.setLastName(lastName);
				contact.setCity(city);
				contact.setState(state);
				contact.setState(zip);
				return operationStatus(true);
			}
		}
		return operationStatus(false);
	}

	/**
	 * Method to Delete contact using unique phoneNumber
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public boolean deleteContact(String phoneNumber) {

		for (Contact contact : allContacts) {
			if (contact.getPhoneNumber() == phoneNumber) {
				allContacts.remove(contact);
				return operationStatus(true);
			}
		}
		return operationStatus(false);
	}

	/**
	 * Method to Display the Contact Details
	 */
	public void displayContacts(LinkedList<Contact> contactList) {
		for (Contact contact : contactList) {
			System.out.println(contact);
		}
	}

	public void displayContact() {
		for (String bookName : addressBooks.keySet()) {
			System.out.println(bookName);
			LinkedList<Contact> contactList = addressBooks.get(bookName);
			displayContacts(contactList);
		}
	}

	/**
	 * Method to check the status of operation whether it is done properly or not
	 * 
	 * @param status
	 * @return
	 */
	private static boolean operationStatus(boolean status) {
		if (status) {
			System.out.println("Contact Updated Successfully");
		} else {
			System.out.println("Contact not found");
		}
		return status;
	}

	private void addContactToExsistingBook(Contact contact, String bookName, ArrayList<Contact> contactList) {
		boolean isAlreadyExsist = false;
		for (Contact searchContact : contactList) 
		{
			if (searchContact.getFirstName().equals(contact.getFirstName())) 
			{
				isAlreadyExsist = true;
				break;
			}
		}
		if (!(isAlreadyExsist))
		{
			contactList.add(contact);
			addressBooks.put(bookName, contactList);
			System.out.println("New Contact Added Sucessfully");
		} 
		else 
		{
			System.out.println("Contact already exsist");
		}
	}
	public int searchPerson(String searchKey)
	{
		int count = 0;
		for (String bookName : addressBooks.keySet()) {
			ArrayList<Contact> contactList = addressBooks.get(bookName);
			for (Contact contact : contactList)
			{
				if (contact.getCity().equals(searchKey) || contact.getState().equals(searchKey)) 
				{
					System.out.println(contact.getFirstName() + "" + contact.getLastName());
					count++;
				}
			}
		}
		return count; 
	}
	public void viewPerson(String viewKey)
	{
		for (String bookName : addressBooks.keySet()) 
		{
			ArrayList<Contact> contactList = addressBooks.get(bookName);
			for (Contact contact : contactList) 
			{
				if (contact.getCity().equals(viewKey) || contact.getState().equals(viewKey)) 
				{
					System.out.println(contact);
				}
			}
		}
	}
}