package za.co.bbd.atc.propertymanagement.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.bbd.atc.propertymanagement.dto.AddressDTO;

import java.util.List;

@Data
@NoArgsConstructor
public class UserCreationDTO {

    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    private String emailAddress;

    private List<PhoneNumberDTO> phoneNumberList;

    private AddressDTO address;
}
