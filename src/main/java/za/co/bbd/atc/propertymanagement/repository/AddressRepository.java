package za.co.bbd.atc.propertymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.atc.propertymanagement.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
}
