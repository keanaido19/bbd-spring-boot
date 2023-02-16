package za.co.bbd.atc.propertymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.atc.propertymanagement.model.db.EmailAddress;

import java.util.Optional;

public interface EmailAddressRepository extends JpaRepository<EmailAddress, Integer> {

    Optional<EmailAddress> findByEmailAddress(String emailAddress);
}
