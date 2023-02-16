package za.co.bbd.atc.propertymanagement.service;

import org.springframework.stereotype.Service;
import za.co.bbd.atc.propertymanagement.model.db.PersonLookup;
import za.co.bbd.atc.propertymanagement.model.dto.UserCreationDTO;
import za.co.bbd.atc.propertymanagement.repository.PersonLookupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonLookupService extends AbstractService<PersonLookup, PersonLookupRepository> {
    protected PersonLookupService(PersonLookupRepository repository) {
        super(repository);
    }

    public List<PersonLookup> getAll() {
        return repository.findAll();
    }

    public Optional<PersonLookup> get(Integer id) {
        return repository.findById(id);
    }

    public void save(UserCreationDTO userCreationDTO) {
        // TODO
    }

    public void save(String firstName, String lastName, String emailAddress){
        repository.save(new PersonLookup(firstName, lastName, emailAddress));
    }
}
