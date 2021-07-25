package address;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class AddressBook
{

	HashMap<String, LinkedList<Contact>> addressBooks = new HashMap<>();
	LinkedList<Contact> allContacts = new LinkedList<Contact>();
	Scanner scanner = new Scanner(System.in);
	
	public Contact addContact()
	{
		Contact contact = new Contact();
		System.out.println("Enter First Name");
		contact.setFirstname(scanner.next());
		System.out.println("Enter Last Name");
		contact.setLastname(scanner.next());
		System.out.println("Enter City");
		contact.setCity(scanner.next());
		System.out.println("Enter State");
		contact.setState(scanner.next());
		System.out.println("Enter Pincode");
		contact.setZipcode(scanner.nextInt());
		System.out.println("Enter Phone Number");
		contact.setPhonenumber(scanner.next());
		System.out.println("Enter Email");
		contact.setEmail(scanner.next());
		System.out.println("Enter Book name to which you have to add contact");
		String bookName = scanner.next();

		if (addressBooks.containsKey(bookName)) 
		{
			LinkedList<Contact> contactList = addressBooks.get(bookName);
			addContactToExsistingBook(contact, bookName, contactList);
		} else 
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
			if (contact.getPhonenumber() == phoneNumber)
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
				contact.setFirstname(firstName);
				contact.setLastname(lastName);
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
			if (contact.getPhonenumber() == phoneNumber) 
			{
				allContacts.remove(contact);
				return operationStatus(true);
			}
		}
		return operationStatus(false);
	}
	public void displayContacts(LinkedList<Contact> contactList) 
	{
		addressBooks.entrySet().stream()
		.map(books->books.getKey())
		.map(bookNames->{
			System.out.println(bookNames); 
			return addressBooks.get(bookNames); 
		})
		.forEach(contactInBook->System.out.println(contactInBook));
	}

	public void displayContact()
	{
		for (String bookName : addressBooks.keySet())
		{
			System.out.println(bookName);
			LinkedList<Contact> contactList = addressBooks.get(bookName);
			displayContacts(contactList);
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

	private void addContactToExsistingBook(Contact contact, String bookName, LinkedList<Contact> contactList) 
	{
		boolean isAlreadyExsist = contactList.stream()
				.anyMatch(contactsInlist->contactsInlist.getFirstname()==contact.getFirstname());
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
		for (String bookName : addressBooks.keySet())
		{
			LinkedList<Contact> contactList = addressBooks.get(bookName);
			contactList.stream()
			.filter(n->n.getState()==searchKey || n.getCity() == searchKey)
			.forEach(n->System.out.println(n.getFirstname()+" "+n.getLastname()));
		}
		return count; 
	}

	public void viewPerson(String viewKey) 
	{
		for (String bookName : addressBooks.keySet())
		{
			LinkedList<Contact> contactList = addressBooks.get(bookName);
			contactList.stream()
			.filter(contact->contact.getState()==viewKey || contact.getCity() == viewKey)
			.forEach(contact->System.out.println(contact));
		}
	}
		public void sortContacts()
		{
			for (String bookName : addressBooks.keySet())
			{
				LinkedList<Contact> contatct = addressBooks.get(bookName);
			 	contatct.stream().sorted(Comparator.comparing(Contact::getFirstname)).forEach(n->System.out.println(n));
			}
		}
}