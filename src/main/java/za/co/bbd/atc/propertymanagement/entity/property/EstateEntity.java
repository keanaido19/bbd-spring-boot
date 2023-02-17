package za.co.bbd.atc.propertymanagement.entity.property;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Estates")
@NoArgsConstructor
public class EstateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EstateID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "Name", unique = true, nullable = false)
    private String Name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PropertyID", unique = true, nullable = false)
    private PropertyEntity propertyEntity;

    @OneToMany(mappedBy = "estateEntity")
    List<LotEntity> estateLots;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @JsonIgnore
    public PropertyEntity getPropertyEntity() {
        return propertyEntity;
    }

    public void setPropertyEntity(PropertyEntity propertyEntity) {
        this.propertyEntity = propertyEntity;
    }

    public List<LotEntity> getEstateLots() {
        return estateLots;
    }

    public void setEstateLots(List<LotEntity> estateLots) {
        this.estateLots = estateLots;
    }
}
