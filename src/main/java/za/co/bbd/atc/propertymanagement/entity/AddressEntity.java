package za.co.bbd.atc.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Location")
@NoArgsConstructor
@Data
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocationID", nullable = false, unique = true)
    private Integer id;

    @Column(name = "Street", nullable = false, length = 30)
    private String street;

    @Column(name = "City", nullable = false, length = 20)
    private String city;

    @Column(name = "Province", nullable = false, length = 20)
    private String province;

    @Column(name = "Zip", nullable = false, length = 10)
    private String zip;

    @Column(name = "Country", nullable = false, length = 20)
    private String country;

    @Column(name = "GeoLocation")
    private String geoLocation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "addressEntity")
    private List<UserEntity> userEntityList;

}
