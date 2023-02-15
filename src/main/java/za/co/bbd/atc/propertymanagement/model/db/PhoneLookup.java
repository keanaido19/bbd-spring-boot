package za.co.bbd.atc.propertymanagement.model.db;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "PhoneLookup")
public class PhoneLookup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PhoneID")
    private Integer id;

    @Column(name = "Code")
    private String code;

    @Column(name = "Number")
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
}
