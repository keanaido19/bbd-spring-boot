package za.co.bbd.atc.propertymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.atc.propertymanagement.entity.PhoneNumberEntity;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumberEntity, Integer> {
    PhoneNumberEntity findPhoneNumberEntityByCountryCodeAndPhoneNumber(String countryCode, String phoneNumber);
}
