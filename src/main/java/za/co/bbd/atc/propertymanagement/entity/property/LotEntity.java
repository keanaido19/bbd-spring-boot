package za.co.bbd.atc.propertymanagement.entity.property;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Lots")
@NoArgsConstructor
@Data
public class LotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LotID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "Number", unique = true, nullable = false)
    private String Number;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PropertyID", unique = true, nullable = false)
    private PropertyEntity propertyEntity;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "EstateLots",
//            joinColumns = @JoinColumn(name = "LotID", nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "EstateID", unique = true, nullable = false)
//    )
//    private EstateEntity estateEntity;
//
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ApartmentLots",
            joinColumns = @JoinColumn(name = "LotID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "ApartmentID", unique = true, nullable = false)
    )
    private ApartmentEntity apartmentEntity;

    @JsonIgnore
    public ApartmentEntity getApartmentEntity() {
        return apartmentEntity;
    }

    @JsonIgnore
    public PropertyEntity getPropertyEntity() {
        return propertyEntity;
    }
}
