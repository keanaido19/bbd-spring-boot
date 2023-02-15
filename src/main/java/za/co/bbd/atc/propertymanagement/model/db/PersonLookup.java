package za.co.bbd.atc.propertymanagement.model.db;

import jakarta.persistence.*;

@Entity
@Table(name = "PersonLookup")
public class PersonLookup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PersonID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @OneToOne(mappedBy = "personLookup", cascade = CascadeType.ALL)
    private EmailAddress emailAddress;

    protected PersonLookup() {}

    public PersonLookup(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }
}
