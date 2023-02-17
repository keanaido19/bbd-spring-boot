package za.co.bbd.atc.propertymanagement.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import za.co.bbd.atc.propertymanagement.entity.AddressEntity;

import java.util.ArrayList;
import java.util.List;

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

    public void removePhoneNumbers() {
        if (null != getPhoneNumberEntityList()) {
            for (PhoneNumberEntity phoneNumberEntity : getPhoneNumberEntityList()) {
                phoneNumberEntity.getUserEntityList().remove(this);
            }
            setPhoneNumberEntityList(new ArrayList<>());
        }
    }
}
