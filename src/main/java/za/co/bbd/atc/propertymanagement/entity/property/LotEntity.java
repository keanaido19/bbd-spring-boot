package za.co.bbd.atc.propertymanagement.entity.property;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PropertyID", unique = true, nullable = false)
    private PropertyEntity propertyEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private EstateEntity estateEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private ApartmentEntity apartmentEntity;
}
