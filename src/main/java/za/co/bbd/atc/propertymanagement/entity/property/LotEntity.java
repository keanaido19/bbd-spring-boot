package za.co.bbd.atc.propertymanagement.entity.property;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Lots")
@NoArgsConstructor
public class LotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LotID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "Number", unique = true, nullable = false)
    private String Number;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PropertyID", unique = true, nullable = false)
    private PropertyEntity propertyEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "EstateLots",
            joinColumns = @JoinColumn(name = "LotID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "EstateID", unique = true, nullable = false)
    )
    private EstateEntity estateEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ApartmentLots",
            joinColumns = @JoinColumn(name = "LotID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "ApartmentID", unique = true, nullable = false)
    )
    private ApartmentEntity apartmentEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    @JsonIgnore
    public PropertyEntity getPropertyEntity() {
        return propertyEntity;
    }

    public void setPropertyEntity(PropertyEntity propertyEntity) {
        this.propertyEntity = propertyEntity;
    }

    @JsonIgnore
    public EstateEntity getEstateEntity() {
        return estateEntity;
    }

    public void setEstateEntity(EstateEntity estateEntity) {
        this.estateEntity = estateEntity;
    }

    @JsonIgnore
    public ApartmentEntity getApartmentEntity() {
        return apartmentEntity;
    }

    public void setApartmentEntity(ApartmentEntity apartmentEntity) {
        this.apartmentEntity = apartmentEntity;
    }
}
