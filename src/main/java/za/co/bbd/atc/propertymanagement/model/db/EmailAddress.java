package za.co.bbd.atc.propertymanagement.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "EmailAddress")
public class EmailAddress implements DbModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmailID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "EmailAddress", unique = true, nullable = false)
    private String emailAddress;

    @OneToOne
    @JoinColumn(name = "PersonID", unique = true, nullable = false)
    private PersonLookup personLookup;

    protected EmailAddress() {}

    public EmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @JsonIgnore
    public PersonLookup getPersonLookup() {
        return personLookup;
    }

    public void setPersonLookup(PersonLookup personLookup) {
        this.personLookup = personLookup;
    }
}
