package za.co.bbd.atc.propertymanagement.model.db;

import jakarta.persistence.*;

@Entity
@Table(name = "EmailAddress")
public class EmailAddress {
    @Id
    @Column(name = "EmailAddress", unique = true, nullable = false)
    private String emailAddress;

    @OneToOne
    @JoinColumn(name = "PersonID", unique = true, nullable = false)
    private PersonLookup personLookup;

    protected EmailAddress() {}

    public EmailAddress(String emailAddress, PersonLookup personLookup) {
        this.emailAddress = emailAddress;
        this.personLookup = personLookup;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public PersonLookup getPersonLookup() {
        return personLookup;
    }

    public void setPersonLookup(PersonLookup personLookup) {
        this.personLookup = personLookup;
    }
}
