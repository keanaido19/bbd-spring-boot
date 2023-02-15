package za.co.bbd.atc.propertymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.atc.propertymanagement.model.db.PhoneLookup;

public interface PhoneLookupRepository extends JpaRepository<PhoneLookup, Integer> {
}
