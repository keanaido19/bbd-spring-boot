package za.co.bbd.atc.propertymanagement.dto.property;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.bbd.atc.propertymanagement.dto.AddressDTO;

@Data
@NoArgsConstructor
public class HouseDTO {
    private Integer houseID;

    private AddressDTO address;

    private Integer propertyID;
}
