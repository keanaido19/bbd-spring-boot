package za.co.bbd.atc.propertymanagement.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PersonLookup")
public class PersonLookup implements DbModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @OneToOne(mappedBy = "personLookup", cascade = CascadeType.ALL)
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

    public PersonLookup(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = new EmailAddress(emailAddress);
        this.emailAddress.setPersonLookup(this);
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

    public String getEmailAddress() {
        return emailAddress.getEmailAddress();
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Set<PhoneLookup> getPhonesLookup() {
        if (null == phonesLookup) {
            phonesLookup = new HashSet<>();
        }
        return phonesLookup;
    }

    public void setPhonesLookup(Set<PhoneLookup> phonesLookup) {
        this.phonesLookup = phonesLookup;
    }

    public void addPhoneLookup(PhoneLookup phoneLookup) {
        this.phonesLookup.add(phoneLookup);
        phoneLookup.getPeopleLookup().add(this);
    }

    public void removePhoneLookup(PhoneLookup phoneLookup) {
        this.phonesLookup.remove(phoneLookup);
        phoneLookup.getPeopleLookup().remove(this);
    }

    @JsonIgnore
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
