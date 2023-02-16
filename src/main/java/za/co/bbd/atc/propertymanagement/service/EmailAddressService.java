package za.co.bbd.atc.propertymanagement.service;

import org.springframework.stereotype.Service;
import za.co.bbd.atc.propertymanagement.model.db.EmailAddress;
import za.co.bbd.atc.propertymanagement.model.db.PersonLookup;
import za.co.bbd.atc.propertymanagement.repository.EmailAddressRepository;

import java.util.Optional;

@Service
public class EmailAddressService extends AbstractService<EmailAddress, EmailAddressRepository> {

    public EmailAddressService(EmailAddressRepository repository) {
        super(repository);
    }

    public Optional<PersonLookup> getUser(String emailAddress) {
        return repository.findByEmailAddress(emailAddress).map(EmailAddress::getPersonLookup);
    }

    public Optional<EmailAddress> get(String emailAddress) {
        return repository.findByEmailAddress(emailAddress);
    }
}
