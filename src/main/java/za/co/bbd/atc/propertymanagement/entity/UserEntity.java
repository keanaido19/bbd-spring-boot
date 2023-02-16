package za.co.bbd.atc.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToOne(mappedBy = "userEntity")
    private EmailAddressEntity emailAddressEntity;

    @ManyToMany(mappedBy = "userEntityList")
    private List<PhoneNumberEntity> phoneNumberEntityList;

    @ManyToOne
    @JoinTable(
            name = "PersonLocation",
            joinColumns = @JoinColumn(name = "PersonID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "LocationID", nullable = false)
    )
    private AddressEntity addressEntity;
}
