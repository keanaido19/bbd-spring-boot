package za.co.bbd.atc.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

    @JsonProperty(required = true)
    private String street;

    @JsonProperty(required = true)
    private String city;

    @JsonProperty(required = true)
    private String province;

    @JsonProperty(required = true)
    private String zip;

    @JsonProperty(required = true)
    private String country;
}
