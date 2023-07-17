package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactManager contactManager;

    @Autowired
    public ContactController(ContactManager contactManager) {
        this.contactManager = contactManager;
    }

    @PostMapping
    public void addContact(@RequestBody Contact contact) {
        contactManager.addContact(contact);
    }

    @PostMapping("/{name}/addresses")
    public void addAddressToContact(@PathVariable String name, @RequestBody String address) {
        Contact contact = contactManager.getContact(name);
        if (contact != null) {
            List<String> addresses = contact.getAddresses();
            addresses.add(address.trim().replaceAll("\\\\", ""));
            contact.setAddresses(addresses);
            contactManager.updateContact(name, contact);
        }
    }

    @DeleteMapping("/{name}")
    public void deleteContact(@PathVariable String name) {
        contactManager.deleteContact(name);
    }

    @GetMapping("/{name}")
    public Contact getContact(@PathVariable String name) {
        return contactManager.getContact(name);
    }

    @PutMapping("/{name}")
    public void updateContact(@PathVariable String name, @RequestBody Contact updatedContact) {
        contactManager.updateContact(name, updatedContact);
    }
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactManager.getAllContacts();
    }
    @GetMapping("/{name}/addresses")
    public List<String> getContactAddresses(@PathVariable String name) {
        Contact contact = contactManager.getContact(name);
        if (contact != null) {
            return contact.getAddresses();
        }
        return null;
    }

}

