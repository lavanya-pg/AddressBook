package address;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook
{
	static Scanner scanner = new Scanner(System.in);
    static ArrayList<Contact> contactArrayList = new ArrayList<Contact>();

        public static void main(String[] args)
        {
			boolean flag = true;
		    while (flag) 
		    {
			Contact contact = new Contact();
		
			System.out.println("Press 1 - Add contact");
			System.out.println("Press 2 - Edit Contact");
			System.out.println("Press 3 - Delete contact");
		    int choice = scanner.nextInt();
		
		    switch (choice)
		    {
		        case 1:
		            addContact(contact, contactArrayList);
		            break;
		        case 2:
		            editContact(contact);
		        case 3:
		            deleteContact(contact);
		            break;
		        default:
		        	flag = false;
		            System.out.println("Invalid input");
		    }
		
		    }
		
		}
		
		public static void addContact(Contact contact, ArrayList<Contact> contactArrayList) 
		{
		    System.out.print("Enter first name: ");
		    String firstName = scanner.next();
		    contact.setFirstName(firstName);
		   
		    System.out.print("Enter last name: ");
		    String lastName = scanner.next();
		    contact.setLastName(lastName);
		    
		    System.out.print("Enter address: ");
		    String address = scanner.next();
		    contact.setAddress(address);
		    
		    System.out.print("Enter city: ");
		    String city = scanner.next();
		    contact.setCity(city);
		    
		    System.out.print("Enter state: ");
		    String state = scanner.next();
		    contact.setState(state);
		    
		    System.out.print("Enter zip: ");
		    long zip = scanner.nextLong();
		    contact.setZipCode(zip);
		    
		    System.out.print("Enter phone no: ");
		    long phNumber = scanner.nextLong();
		    contact.setPhoneNumber(phNumber);
		    
		    System.out.print("Enter email: ");
		    String email = scanner.next();
		    contact.setEmail(email);
		
		    contactArrayList.add(contact);
		
		    for (Contact c: contactArrayList)
		    {
		        System.out.println(c.getFirstName() + " " + c.getLastName() + " " + c.getAddress() + " " + c.getCity() + " " + c.getState() + " "  + c.getZipCode()+ " " + c.getPhoneNumber() + " " + c.getEmail());
		    }
		}
		
		public static void editContact(Contact contact)
		{
		    System.out.print("Enter a first name: ");
		    String firstName = scanner.next();
		    System.out.print("Enter a last name: ");
		    String lastName = scanner.next();
		    for (int i=0; i<contactArrayList.size(); i++) 
		    {
		        if (contactArrayList.get(i).getFirstName().equals(firstName) && contactArrayList.get(i).getLastName().equals(lastName)) {
		            System.out.print("Enter address: ");
		            String address = scanner.next();
		            contact.setAddress(address);
		
		            System.out.print("Enter city: ");
		            String city = scanner.next();
		            contact.setCity(city);
		
		            System.out.print("Enter state: ");
		            String state = scanner.next();
		            contact.setState(state);
		
		            System.out.print("Enter zip: ");
		            long zip = scanner.nextLong();
		            contact.setZipCode(zip);
		
		            System.out.print("Enter phone no: ");
		            long phNumber = scanner.nextLong();
		            contact.setPhoneNumber(phNumber);
		
		            System.out.print("Enter email: ");
		            String email = scanner.next();
		            contact.setEmail(email);
		
		            for (Contact c: contactArrayList)
		            {
		                System.out.println(c.getFirstName() + " " + c.getLastName() + " " + c.getAddress() + " " + c.getCity() + " " + c.getState() + " "  + c.getZipCode()+ " " + c.getPhoneNumber() + " " + c.getEmail());
		            }
		        }
		    }
		}
		public static void deleteContact(Contact contact)
		{
			System.out.print("Enter a first name: ");
			String firstName = scanner.next();
			System.out.print("Enter a last name: ");
			String lastName = scanner.next();
			for (int i=0; i<contactArrayList.size(); i++)
			{
				if (contactArrayList.get(i).getFirstName().equals(firstName) && contactArrayList.get(i).getLastName().equals(lastName))
				{
					contactArrayList.remove(i);
				}
			}
		}

}
