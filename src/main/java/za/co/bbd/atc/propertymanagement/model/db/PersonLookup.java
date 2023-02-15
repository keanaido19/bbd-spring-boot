package za.co.bbd.atc.propertymanagement.model.db;

import jakarta.persistence.*;

import java.util.Set;

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

    @OneToOne(mappedBy = "personLookup")
    private EmailAddress emailAddress;

    @ManyToMany
    @JoinTable(
            name = "PersonPhone",
            joinColumns = @JoinColumn(name = "PersonID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "PhoneID", nullable = false)
    )
    private Set<PhoneLookup> phonesLookup;

    @ManyToOne
    @JoinTable(
            name = "PersonLocation",
            joinColumns = @JoinColumn(name = "PersonID", unique = true, nullable = false),
            inverseJoinColumns = @JoinColumn(name = "LocationID", nullable = false)
    )
    private Location location;

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

    public Set<PhoneLookup> getPhonesLookup() {
        return phonesLookup;
    }

    public void setPhonesLookup(Set<PhoneLookup> phonesLookup) {
        this.phonesLookup = phonesLookup;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
