package za.co.bbd.atc.propertymanagement.model.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserCreationDTO {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Set<PhoneNumber> phoneNumbers;
    private Address address;
}
