package za.co.bbd.atc.propertymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.atc.propertymanagement.entity.property.PropertyEntity;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Integer> {
}
