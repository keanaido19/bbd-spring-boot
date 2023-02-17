package za.co.bbd.atc.propertymanagement.dto.property;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.bbd.atc.propertymanagement.dto.AddressDTO;

@Data
@NoArgsConstructor
public class LotDTO {
    private Integer lotID;

    private String lotNumber;

    private AddressDTO address;

    private Integer propertyID;
}
