package za.co.bbd.atc.propertymanagement.entity.property;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Apartments")
@NoArgsConstructor
@Data
public class ApartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ApartmentID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "Name", unique = true, nullable = false)
    private String Name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PropertyID", unique = true, nullable = false)
    private PropertyEntity propertyEntity;

    @OneToMany(mappedBy = "apartmentEntity")
    private List<LotEntity> Lots;

    @JsonIgnore
    public List<LotEntity> getLots() {
        return Lots;
    }

    @JsonIgnore
    public PropertyEntity getPropertyEntity() {
        return propertyEntity;
    }
}
