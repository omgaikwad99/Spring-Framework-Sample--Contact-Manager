package org.example;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.AmqpTemplate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.example.MessageListener.*;


@Component
public class ContactManager implements CommandLineRunner {
    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;
    private final AmqpTemplate amqpTemplate;
    private final RabbitTemplate rabbitTemplate;
    private final MessageListener receiver;


    @Autowired
    public ContactManager(ContactRepository contactRepository, AddressRepository addressRepository, AmqpTemplate amqpTemplate, MessageListener receiver, RabbitTemplate rabbitTemplate) {
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
        this.amqpTemplate = amqpTemplate;
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void addContact(Contact contact) {
        contactRepository.save(contact);
        sendMessage("Contact added: " + contact.getName());
    }

    public void deleteContact(String name) {
        Contact contact = contactRepository.findByName(name);
        if (contact != null) {
            contactRepository.delete(contact);
            sendMessage("Contact deleted: " + name);
        }
    }

    public Contact getContact(String name) {
        sendMessage("Receiving contact: " + name);
        return contactRepository.findByName(name);
    }
    public void updateContact(String name, Contact updatedContact) {
        Contact existingContact = contactRepository.findByName(name);
        if (existingContact != null) {
            existingContact.setName(updatedContact.getName());
            existingContact.setEmail(updatedContact.getEmail());
            existingContact.setPhoneNumber(updatedContact.getPhoneNumber());
            existingContact.setAddresses(updatedContact.getAddresses());
            contactRepository.save(existingContact);
            sendMessage("Contact updated: " + name);
        }
    }

    public List<Contact> getAllContacts(){
        sendMessage("Retrieving list of all contacts from table contacts");
        return (List<Contact>) contactRepository.findAll();
    }

    private void sendMessage(String message){
        
        rabbitTemplate.convertAndSend(MessagingRabbitmqApplication.topicExchangeName, "foo.bar.baz", message);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(MessagingRabbitmqApplication.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
        boolean await = MessageListener.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }

    public void sendMessageToUser(String message) {
        rabbitTemplate.convertAndSend(MessagingRabbitmqApplication.userExchangeName, "foo.bar.baz", message);
    }

}


