import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    private ArrayList<account> contacts = new ArrayList<>();

    public void addContact(account contact) {
        contacts.add(contact);
    }

    public void deleteContact(String name) {
        account toRemove = null;
        for (account contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                toRemove = contact;
                break;
            }
        }

        if (toRemove != null) {
            contacts.remove(toRemove);
            System.out.println("Contact removed.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public account searchContact(String name) {
        for (account contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void listAllContacts() {
        for (account contact : contacts) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Address Book System:");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. List All Contacts");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Name, Phone Number, Email:");
                    String name = scanner.nextLine();
                    String phoneNumber = scanner.nextLine();
                    String email = scanner.nextLine();
                    addressBook.addContact(new account(name, phoneNumber, email));
                    break;

                case 2:
                    System.out.println("Enter Name of the contact to delete:");
                    name = scanner.nextLine();
                    addressBook.deleteContact(name);
                    break;

                case 3:
                    System.out.println("Enter Name of the contact to search:");
                    name = scanner.nextLine();
                    account c = addressBook.searchContact(name);
                    if (c != null) {
                        System.out.println(c);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    addressBook.listAllContacts();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
