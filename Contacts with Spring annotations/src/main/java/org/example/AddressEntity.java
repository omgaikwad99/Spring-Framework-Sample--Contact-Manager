package org.example;

import javax.persistence.*;

@Entity
@Table(name = "contact_addresses")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Column(name = "address")
    private String address;

    // Constructors, getters, and setters

    public AddressEntity() {
        // Default constructor
    }

    public AddressEntity(Contact contact, String address) {
        this.contact = contact;
        this.address = address;
    }

    // Getter and Setter methods for contact and address

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
