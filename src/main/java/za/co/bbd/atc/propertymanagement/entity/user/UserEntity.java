package za.co.bbd.atc.propertymanagement.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import za.co.bbd.atc.propertymanagement.entity.AddressEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "PersonLookup")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "FirstName", nullable = false, length = 20)
    private String firstName;

    @Column(name = "LastName", nullable = false, length = 20)
    private String lastName;

    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private EmailAddressEntity emailAddressEntity;

    @ManyToMany(mappedBy = "userEntityList", cascade = CascadeType.ALL)
    private List<PhoneNumberEntity> phoneNumberEntityList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "PersonLocation",
            joinColumns = @JoinColumn(name = "PersonID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "LocationID", nullable = false)
    )
    private AddressEntity addressEntity;

    public void removePhoneNumber(PhoneNumberEntity phoneNumber) {
        if (null != phoneNumberEntityList)
            this.phoneNumberEntityList.remove(phoneNumber);
        if (null != phoneNumber.getUserEntityList())
            phoneNumber.getUserEntityList().remove(this);
    }

    public void addPhoneNumber(PhoneNumberEntity phoneNumber) {
        if (null == phoneNumberEntityList)
            this.setPhoneNumberEntityList(new ArrayList<>());

        this.phoneNumberEntityList.add(phoneNumber);

        if (null == phoneNumber.getUserEntityList())
            phoneNumber.setUserEntityList(new ArrayList<>());

        phoneNumber.getUserEntityList().add(this);
    }

    public void addPhoneNumbers(List<PhoneNumberEntity> phoneNumbers) {
        phoneNumbers.forEach(this::addPhoneNumber);
    }

    public void removePhoneNumbers(List<PhoneNumberEntity> phoneNumbers) {
        phoneNumbers.forEach(this::removePhoneNumber);
    }

    public void removeAllPhoneNumbers() {
        if (null != getPhoneNumberEntityList()) {
            for (PhoneNumberEntity phoneNumberEntity : getPhoneNumberEntityList()) {
                phoneNumberEntity.getUserEntityList().remove(this);
            }
            setPhoneNumberEntityList(new ArrayList<>());
        }
    }
}
