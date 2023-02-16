package za.co.bbd.atc.propertymanagement.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {
    private String street;
    private String city;
    private String province;
    private String zip;
    private String country;
}
