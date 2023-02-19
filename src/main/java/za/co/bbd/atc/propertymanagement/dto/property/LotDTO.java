package za.co.bbd.atc.propertymanagement.dto.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import za.co.bbd.atc.propertymanagement.dto.AddressDTO;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class LotDTO extends PropertyDTO {
    private Integer propertyID;

    private Integer lotID;

    private String lotNumber;

    private AddressDTO address;
}
