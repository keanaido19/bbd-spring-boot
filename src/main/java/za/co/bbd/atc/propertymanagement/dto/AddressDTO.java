package za.co.bbd.atc.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

    @NotNull
    @NotBlank
    private String street;

    @NotNull
    @NotBlank
    private String city;

    @NotNull
    @NotBlank
    private String province;

    @NotNull
    @NotBlank
    private String zip;

    @NotNull(message = "country field must not be null")
    @NotBlank(message = "country field must not be blank")
    @JsonProperty(required = true)
    private String country;
}
