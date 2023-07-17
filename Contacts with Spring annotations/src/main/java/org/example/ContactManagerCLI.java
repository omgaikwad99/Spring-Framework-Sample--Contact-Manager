package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
/*
@Component
public class ContactManagerCLI {
    private static final Scanner scanner = new Scanner(System.in);
    private final ContactManager contactManager;

    @Autowired
    public ContactManagerCLI(ContactManager contactManager) {
        this.contactManager = contactManager;
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to Contact Manager");
            System.out.println("1. Add contact");
            System.out.println("2. Retrieve contact");
            System.out.println("3. Update contact");
            System.out.println("4. Delete contact");
            System.out.println("5. Display all contacts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    retrieveContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    displayAllContacts();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    private void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        Contact contact = new Contact(name, email, phoneNumber, address);
        if (Syntax.isValidEmail(email) && Syntax.isValidMobileNumber(phoneNumber)) {
            System.out.println("Email and Phone Number are valid.");
            contactManager.addContact(contact);
            contactManager.addAddress(contact);
            System.out.println("Contact added successfully!");
        } else {
            System.out.println("Email or Phone Number is not valid.");
        }
    }

    private void retrieveContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Contact contact = contactManager.getContact(name);
        if (contact != null) {
            System.out.println("Contact details:");
            System.out.println("Name: " + contact.getName());
            System.out.println("Email: " + contact.getEmail());
            System.out.println("Phone number: " + contact.getPhoneNumber());
            System.out.println("Address Line: " + contact.getAddresses());
        } else {
            System.out.println("Contact not found!");
        }
    }

    private void updateContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Contact contact = contactManager.getContact(name);
        if (contact != null) {
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter additional address: ");
            String address = scanner.nextLine();

            // Create a new Contact object with the updated details
            Contact updatedContact = new Contact(name, email, phoneNumber, address);

            // Call the updateContact method in ContactManager
            contactManager.updateContact(name, updatedContact);
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Contact not found!");
        }
    }


    private void deleteContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Contact contact = contactManager.getContact(name);
        if (contact != null) {
            contactManager.deleteContact(name);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found!");
        }
    }

    private void displayAllContacts() {
        List<Contact> contacts = contactManager.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("No contacts found!");
        } else {
            System.out.println("All contacts:");
            for (Contact contact : contacts) {
                System.out.println("Name: " + contact.getName());
                System.out.println("Email: " + contact.getEmail());
                System.out.println("Phone number: " + contact.getPhoneNumber());
                System.out.println("Address Line: " + contact.getAddresses());
                System.out.println("-----------------------------");
            }
        }
    }
}*/



