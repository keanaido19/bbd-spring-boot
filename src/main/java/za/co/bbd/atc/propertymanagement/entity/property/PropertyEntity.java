package za.co.bbd.atc.propertymanagement.entity.property;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.bbd.atc.propertymanagement.entity.AddressEntity;

@Entity
@Table(name = "Properties")
@NoArgsConstructor
@Data
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PropertyID", unique = true, nullable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LocationID", unique = true, nullable = false)
    private AddressEntity addressEntity;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "propertyEntity")
    private EstateEntity estateEntity;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "propertyEntity")
    private ApartmentEntity apartmentEntity;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "propertyEntity")
    private HouseEntity houseEntity;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "propertyEntity")
    private LotEntity lotEntity;
}
