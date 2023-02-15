package za.co.bbd.atc.propertymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.atc.propertymanagement.model.db.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
