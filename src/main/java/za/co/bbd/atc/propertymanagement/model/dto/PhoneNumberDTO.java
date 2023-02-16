package za.co.bbd.atc.propertymanagement.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhoneNumberDTO {
    private String countryCode;
    private String phoneNumber;
}
