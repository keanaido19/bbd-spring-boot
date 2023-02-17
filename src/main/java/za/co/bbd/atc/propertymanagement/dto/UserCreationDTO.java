package za.co.bbd.atc.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserCreationDTO {
    @NotNull(message = "firstName field must not be null")
    @NotBlank(message = "firstName field must not be blank")
    @JsonProperty(required = true)
    private String firstName;
    @NotNull(message = "lastName field must not be null")
    @NotBlank(message = "lastName field must not be blank")
    @JsonProperty(required = true)
    private String lastName;
    @NotNull(message = "emailAddress field must not be null")
    @NotBlank(message = "emailAddress field must not be blank")
    @JsonProperty(required = true)
    private String emailAddress;

    private List<PhoneNumberDTO> phoneNumberList;

    private AddressDTO address;
}
