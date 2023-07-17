package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    private String email;
    private String phoneNumber;

    @ElementCollection
    @CollectionTable(
            name = "contact_addresses",
            joinColumns = @JoinColumn(name = "contact_id")
    )
    @Column(name = "address")
    private List<String> addresses;

    public Contact() {
        // Default constructor
    }

    public Contact(String name, String email, String phoneNumber, List<String> addresses) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addresses = addresses;
    }

    // Getter and Setter methods for name, email, phoneNumber, and addresses

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }
}
