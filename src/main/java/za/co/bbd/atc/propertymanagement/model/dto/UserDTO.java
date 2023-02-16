package za.co.bbd.atc.propertymanagement.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private List<PhoneNumberDTO> phoneNumberList;
    private AddressDTO address;
}
