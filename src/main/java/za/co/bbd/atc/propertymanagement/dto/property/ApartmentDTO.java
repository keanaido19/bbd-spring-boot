package za.co.bbd.atc.propertymanagement.dto.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import za.co.bbd.atc.propertymanagement.dto.AddressDTO;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ApartmentDTO extends PropertyDTO {
    private Integer propertyID;

    private Integer apartmentID;

    private String Name;

    private AddressDTO address;

    private List<LotDTO> apartmentLots;
}
