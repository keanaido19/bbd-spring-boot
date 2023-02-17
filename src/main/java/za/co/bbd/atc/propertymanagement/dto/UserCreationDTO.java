package za.co.bbd.atc.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserCreationDTO {
    @JsonProperty(required = true)
    private String firstName;

    @JsonProperty(required = true)
    private String lastName;

    @JsonProperty(required = true)
    private String emailAddress;

    @JsonProperty(required = false)
    private List<PhoneNumberDTO> phoneNumberList;

    @JsonProperty(required = false)
    private AddressDTO address;
}
