package za.co.bbd.atc.propertymanagement.dto.property;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.bbd.atc.propertymanagement.dto.AddressDTO;

import java.util.List;

@Data
@NoArgsConstructor
public class EstateDTO {
    private Integer estateID;

    private String name;

    private AddressDTO address;

    private List<LotDTO> estateLots;

    private Integer propertyID;
}
