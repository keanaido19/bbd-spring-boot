package za.co.bbd.atc.propertymanagement.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumberEntity that = (PhoneNumberEntity) o;
        return Objects.equals(countryCode, that.countryCode) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, phoneNumber);
    }
}
