package za.co.bbd.atc.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhoneNumberDTO {
    @NotNull(message = "countryCode field must not be null")
    @NotBlank(message = "countryCode field must not be blank")
    @JsonProperty(required = true)
    private String countryCode;

    @NotNull(message = "phoneNumber field must not be null")
    @NotBlank(message = "phoneNumber field must not be blank")
    @JsonProperty(required = true)
    private String phoneNumber;
}
