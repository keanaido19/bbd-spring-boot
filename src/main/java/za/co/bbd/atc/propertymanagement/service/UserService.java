package za.co.bbd.atc.propertymanagement.service;

import org.springframework.stereotype.Service;
import za.co.bbd.atc.propertymanagement.model.db.EmailAddress;
import za.co.bbd.atc.propertymanagement.model.db.PersonLookup;
import za.co.bbd.atc.propertymanagement.model.db.PhoneLookup;
import za.co.bbd.atc.propertymanagement.repository.EmailAddressRepository;
import za.co.bbd.atc.propertymanagement.repository.PersonLookupRepository;
import za.co.bbd.atc.propertymanagement.repository.PhoneLookupRepository;

import java.util.Optional;

@Service
public class UserService {
    private final PersonLookupRepository personLookupRepository;
    private final EmailAddressRepository emailRepository;

    private final PhoneLookupRepository phoneLookupRepository;

    public UserService(
            PersonLookupRepository personLookupRepository,
            EmailAddressRepository emailRepository,
            PhoneLookupRepository phoneLookupRepository
    ) {
        this.personLookupRepository = personLookupRepository;
        this.emailRepository = emailRepository;
        this.phoneLookupRepository = phoneLookupRepository;
    }

    public Optional<PersonLookup> getUser(String emailAddress) {
        return emailRepository.findByEmailAddress(emailAddress).map(EmailAddress::getPersonLookup);
    }

    public void UpdateEmail(String currentEmail, String newEmail) {
        Optional<EmailAddress> optionalEmailAddress = emailRepository.findByEmailAddress(currentEmail);
//        TODO
        if (optionalEmailAddress.isEmpty()) throw new RuntimeException();

        EmailAddress emailAddress = optionalEmailAddress.get();
        emailAddress.setEmailAddress(newEmail);
        emailRepository.save(emailAddress);
    }

    public void AddPhoneNumber(String email, String countryCode, String phoneNumber) {
        PhoneLookup phoneLookup;

        Optional<PhoneLookup> optionalPhoneLookup = phoneLookupRepository.findPhoneLookupByCodeAndNumber(countryCode, phoneNumber);

        if (optionalPhoneLookup.isEmpty()) {
            phoneLookup = new PhoneLookup(countryCode, phoneNumber);
            phoneLookupRepository.save(phoneLookup);
        } else {
            phoneLookup = optionalPhoneLookup.get();
        }

        Optional<EmailAddress> optionalEmailAddress = emailRepository.findByEmailAddress(email);
//        TODO
        if (optionalEmailAddress.isEmpty()) throw new RuntimeException();

        EmailAddress emailAddress = optionalEmailAddress.get();
        PersonLookup user = emailAddress.getPersonLookup();
        user.addPhoneLookup(phoneLookup);
        personLookupRepository.save(user);
    }

    public void UpdatePhoneNumber(
            String email,
            String oldCountryCode,
            String oldPhoneNumber,
            String newCountryCode,
            String newPhoneNumber
    ) {
        PhoneLookup phoneLookup;

        Optional<PhoneLookup> optionalPhoneLookup = phoneLookupRepository.findPhoneLookupByCodeAndNumber(oldCountryCode, oldPhoneNumber);

        if (optionalPhoneLookup.isEmpty()) {
            // TODO
            throw new RuntimeException();
        } else {
            phoneLookup = optionalPhoneLookup.get();
        }

        Optional<EmailAddress> optionalEmailAddress = emailRepository.findByEmailAddress(email);
//        TODO
        if (optionalEmailAddress.isEmpty()) throw new RuntimeException();

        EmailAddress emailAddress = optionalEmailAddress.get();
        PersonLookup user = emailAddress.getPersonLookup();
        user.removePhoneLookup(phoneLookup);
        AddPhoneNumber(email, newCountryCode, newPhoneNumber);
    }


}
