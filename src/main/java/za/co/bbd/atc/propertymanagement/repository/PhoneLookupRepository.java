package za.co.bbd.atc.propertymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.atc.propertymanagement.model.db.PhoneLookup;

import java.util.Optional;

public interface PhoneLookupRepository extends JpaRepository<PhoneLookup, Integer> {

    Optional<PhoneLookup> findPhoneLookupByCodeAndNumber(String countryCode, String phoneNumber);

}
