package za.co.bbd.atc.propertymanagement.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.bbd.atc.propertymanagement.dto.AddressDTO;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private List<PhoneNumberDTO> contactDetails;
    private AddressDTO address;
}
