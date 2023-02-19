package za.co.bbd.atc.propertymanagement.dto.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import za.co.bbd.atc.propertymanagement.dto.AddressDTO;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class EstateDTO extends PropertyDTO {
    private Integer propertyID;

    private Integer estateID;

    private String name;

    private AddressDTO address;

    private List<LotDTO> estateLots;
}
