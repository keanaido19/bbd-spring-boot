package za.co.bbd.atc.propertymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.atc.propertymanagement.model.db.EmailAddress;
import za.co.bbd.atc.propertymanagement.model.db.PersonLookup;

public interface PersonLookupRepository extends JpaRepository<PersonLookup, Integer> {
    PersonLookup findByEmailAddress(EmailAddress emailAddress);
}
