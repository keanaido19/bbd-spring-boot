package za.co.bbd.atc.propertymanagement.model.dto;

import za.co.bbd.atc.propertymanagement.model.db.PersonLookup;

import java.util.Set;
import java.util.stream.Collectors;

public class User {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Set<PhoneNumber> phoneNumbers;
    private Address address;

    public User(PersonLookup personLookup) {
        this.firstName = personLookup.getFirstName();
        this.lastName = personLookup.getLastName();
        this.emailAddress = personLookup.getEmailAddress();
        this.phoneNumbers = personLookup.getPhonesLookup().stream().map(PhoneNumber::new).collect(Collectors.toSet());
        this.address = new Address(personLookup.getLocation());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
