package za.co.bbd.atc.propertymanagement.entity.property;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Estates")
@NoArgsConstructor
@Data
public class EstateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EstateID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "Name", unique = true, nullable = false)
    private String Name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PropertyID", unique = true, nullable = false)
    private PropertyEntity propertyEntity;

    @OneToMany(mappedBy = "estateEntity")
    @JoinTable(
            name = "EstateLots",
            joinColumns = @JoinColumn(name = "EstateID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "LotID", unique = true, nullable = false)
    )
    List<LotEntity> estateLots;

}
