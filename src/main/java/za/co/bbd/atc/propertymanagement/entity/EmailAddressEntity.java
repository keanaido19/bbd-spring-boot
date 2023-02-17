package za.co.bbd.atc.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EmailAddress")
@NoArgsConstructor
@Data
public class EmailAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmailID", nullable = false, unique = true)
    private Integer id;

    @Column(name = "EmailAddress", unique = true, nullable = false, length = 50)
    private String emailAddress;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PersonID", unique = true, nullable = false)
    private UserEntity userEntity;

}
