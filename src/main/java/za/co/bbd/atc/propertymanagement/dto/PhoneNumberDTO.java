package za.co.bbd.atc.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhoneNumberDTO {
    @NotNull
    @NotBlank
    private String countryCode;

    @NotNull
    @NotBlank
    private String phoneNumber;
}
