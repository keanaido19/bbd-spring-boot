package za.co.bbd.atc.propertymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.atc.propertymanagement.entity.property.HouseEntity;

public interface HouseRepository  extends JpaRepository<HouseEntity, Integer> {
}
