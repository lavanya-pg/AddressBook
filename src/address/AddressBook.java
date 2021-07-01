package address;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook
{
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Contact> contactList = new ArrayList<>();
		   
		    public static void main(String[] args) 
		    {

		        System.out.println("Welcome to the Address book program"); // Welcome statement
		        AddressBook add = new AddressBook();
		        add.addContactList();
		    }
		    
		    public void display(ArrayList<Contact> contactList)//Display Address book
		   {
		        for (Contact contact : contactList) 
		        {
		            System.out.println(contact);
		        }
		    }
		    
		  
		    public void addContact(Contact contactItems, ArrayList<Contact> contactList) {

		        contactItems = new Contact();

		        System.out.println("Enter first name : ");
		        contactItems.firstName = sc.next();

		        System.out.println("Enter last name : ");
		        contactItems.lastName = sc.next();

		        System.out.println("Enter address : ");
		        contactItems.address = sc.next();
		       

		        System.out.println("Enter city : ");
		        contactItems.city = sc.next();

		        System.out.println("Enter state : ");
		        contactItems.state = sc.next();

		        System.out.println("Enter zip code : ");
		        contactItems.zip = sc.nextInt();

		        System.out.println("Enter phone number : ");
		        contactItems.phoneNumber = sc.nextLong();

		        System.out.println("Enter email : ");
		        contactItems.email = sc.next();

		        contactList.add(contactItems);

		    }

			
		    public void editContact() 
			{

		        System.out.println("Enter the first name of contact you wish to edit");
		        String edit = sc.nextLine();
		        System.out.println("Press 1 - To edit first name");
		        System.out.println("Press 2 - To edit last name");
		        System.out.println("Press 3 - To edit address");
		        System.out.println("Press 4 - To edit city");
		        System.out.println("Press 5 - To edit state");
		        System.out.println("Press 6 - To edit zip code");
		        System.out.println("Press 7 - To edit phone number");
		        System.out.println("Press 8 - To edit email");
		        int choice = sc.nextInt();
		        if (choice == 1) {
		            for (Contact contactItems : contactList) {
		                if (contactItems.firstName.equals(edit)) {
		                    System.out.println("Enter new first name");
		                    contactItems.firstName = sc.next();
		                }
		            }
		        }
		        if (choice == 2) {
		            for (Contact contactItems : contactList) {
		                if (contactItems.firstName.equals(edit)) {
		                    System.out.println("Enter new last name");
		                    contactItems.lastName = sc.next();
		                }
		            }
		        }
		        if (choice == 3) {
		            for (Contact contactItems : contactList) {
		                if (contactItems.firstName.equals(edit)) {
		                    System.out.println("Enter new address");
		                    contactItems.address = sc.next();
		                }
		            }
		        }
		        if (choice == 4) {
		            for (Contact contactItems : contactList) {
		                if (contactItems.firstName.equals(edit)) {
		                    System.out.println("Enter new city");
		                    contactItems.city = sc.next();
		                }
		            }
		        }
		        if (choice == 5) {
		            for (Contact contactItems : contactList) {
		                if (contactItems.firstName.equals(edit)) {
		                    System.out.println("Enter new state");
		                    contactItems.state = sc.next();
		                }
		            }
		        }
		        if (choice == 6) {
		            for (Contact contactItems : contactList) {
		                if (contactItems.firstName.equals(edit)) {
		                    System.out.println("Enter new zip code");
		                    contactItems.zip = sc.nextInt();
		                }
		            }
		        }
		        if (choice == 7) {
		            for (Contact contactItems : contactList) {
		                if (contactItems.firstName.equals(edit)) {
		                    System.out.println("Enter new phone number");
		                    contactItems.phoneNumber = sc.nextLong();
		                }
		            }
		        }
		        if (choice == 8) {
		            for (Contact contactItems : contactList) {
		                if (contactItems.firstName.equals(edit)) {
		                    System.out.println("Enter new email");
		                    contactItems.email = sc.next();
		                }
		            }
		        }
		    }

		 	
		      public void addContactList() {
		        while (true) {
		            System.out.println("Press 0 - Display all contacts");
		            System.out.println("Press 1 - Add contact");
		            System.out.println("Press 2 - Edit contact");
		            System.out.println("Press 6 - Exit");
		            int option = sc.nextInt();
		            sc.nextLine();

		            switch (option) {
		                case 0 -> display(contactList);
		                case 1 -> addContact(null, contactList);
		                case 2 -> editContact();
		            }
		            if (option == 6) {
		                break;
		            }
		        }

}
