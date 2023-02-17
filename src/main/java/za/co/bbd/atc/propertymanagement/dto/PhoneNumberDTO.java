package za.co.bbd.atc.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhoneNumberDTO {
    @JsonProperty(required = true)
    private String countryCode;

    @JsonProperty(required = true)
    private String phoneNumber;
}
