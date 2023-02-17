package za.co.bbd.atc.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "PhoneLookup")
@NoArgsConstructor
@Data
public class PhoneNumberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PhoneID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "Code", nullable = false)
    private String countryCode;

    @Column(name = "Number", nullable = false)
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "PersonPhone",
            joinColumns = @JoinColumn(name = "PhoneID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "PersonID", nullable = false)
    )
    private List<UserEntity> userEntityList;

}
