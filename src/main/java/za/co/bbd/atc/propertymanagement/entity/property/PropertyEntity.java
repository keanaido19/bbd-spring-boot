package za.co.bbd.atc.propertymanagement.entity.property;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LocationID", unique = true, nullable = false)
    private AddressEntity addressEntity;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "propertyEntity")
    private HouseEntity houseEntity;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "propertyEntity")
    private ApartmentEntity apartmentEntity;


//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "propertyEntity")
//    private LotEntity lotEntity;

    @JsonIgnore
    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

//    @JsonIgnore
//    public LotEntity getLotEntity() {
//        return lotEntity;
//    }
}
