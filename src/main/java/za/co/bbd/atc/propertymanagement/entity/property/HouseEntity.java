package za.co.bbd.atc.propertymanagement.entity.property;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Houses")
@NoArgsConstructor
@Data
public class HouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HouseID", unique = true, nullable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PropertyID", unique = true, nullable = false)
    private PropertyEntity propertyEntity;
}
