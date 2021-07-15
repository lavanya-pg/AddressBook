package address;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook 
{

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
			contactList.add(contact);
			addressBooks.put(bookName, contactList);
			System.out.println("New Contact Added Sucessfully");
		} 
		else
		{
			allContacts.add(contact);
			addressBooks.put(bookName, allContacts);
			System.out.println("New book created and Contact Added Sucessfully");
		}

		return contact;
	}

	public boolean editContact(String phoneNumber)
	{
		for (Contact contact : allContacts) 
		{
			if (contact.getPhoneNumber() == phoneNumber)
			{
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
				contact.setFirstName(lastName);
				contact.setCity(city);
				contact.setState(state);
				contact.setState(zip);
				return operationStatus(true);
			}
		}
		return operationStatus(false);
	}

	
	public boolean deleteContact(String phoneNumber) 
	{

		for (Contact contact : allContacts) 
		{
			if (contact.getPhoneNumber() == phoneNumber)
			{
				allContacts.remove(contact);
				return operationStatus(true);
			}
		}
		return operationStatus(false);
	}

	
	public void displayContacts() 
	{
		for (Contact contact : allContacts) 
		{
			System.out.println(contact);
		}
	}

	private static boolean operationStatus(boolean status) 
	{
		if (status) 
		{
			System.out.println("Contact Updated Successfully");
		} 
		else 
		{
			System.out.println("Contact not found");
		}
		return status;
	}
	
		private void addContactToExsistingBook(Contact contact, String bookName, ArrayList<Contact> contactList)
		{
			boolean isAlreadyExsist = false;
			for (Contact searchContact : contactList) 
			{
				if (searchContact.getFirstName().equals(contact.getFirstName()))
				{
					isAlreadyExsist = true;
					break;
				}
			}
			if( !(isAlreadyExsist) )
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

		public void searchPerson(String searchKey)
		{
			for (String bookName : addressBooks.keySet())
			{
				ArrayList<Contact> contactList  =  addressBooks.get(bookName);
				for (Contact contact : contactList) 
				{
					if (contact.getCity().equals(searchKey) ||  contact.getState().equals(searchKey) )
					{
						System.out.println(contact.getFirstName() + ""+ contact.getLastName());

					}
				}
			}
		}
}
