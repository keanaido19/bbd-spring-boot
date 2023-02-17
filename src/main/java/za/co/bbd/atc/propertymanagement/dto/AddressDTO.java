package za.co.bbd.atc.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

    @NotNull(message = "street field must not be null")
    @NotBlank(message = "street field must not be blank")
    @JsonProperty(required = true)
    private String street;

    @NotNull(message = "city field must not be null")
    @NotBlank(message = "city field must not be blank")
    @JsonProperty(required = true)
    private String city;

    @NotNull(message = "province field must not be null")
    @NotBlank(message = "province field must not be blank")
    @JsonProperty(required = true)
    private String province;

    @NotNull(message = "zip field must not be null")
    @NotBlank(message = "zip field must not be blank")
    @JsonProperty(required = true)
    private String zip;

    @NotNull(message = "country field must not be null")
    @NotBlank(message = "country field must not be blank")
    @JsonProperty(required = true)
    private String country;
}
