package za.co.bbd.atc.propertymanagement.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PhoneLookup")
public class PhoneLookup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PhoneID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "Code", nullable = false)
    private String code;

    @Column(name = "Number", nullable = false)
    private String number;

    @ManyToMany(mappedBy = "phonesLookup")
    private Set<PersonLookup> peopleLookup;

    protected PhoneLookup() {}

    public PhoneLookup(String code, String number) {
        this.code = code;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getNumber() {
        return number;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @JsonIgnore
    public Set<PersonLookup> getPeopleLookup() {
        if (null == peopleLookup) {
            peopleLookup = new HashSet<>();
        }
        return peopleLookup;
    }

    public void setPeopleLookup(Set<PersonLookup> peopleLookup) {
        this.peopleLookup = peopleLookup;
    }
}
