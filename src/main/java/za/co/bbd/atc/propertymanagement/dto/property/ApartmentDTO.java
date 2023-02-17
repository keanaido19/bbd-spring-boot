package za.co.bbd.atc.propertymanagement.dto.property;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.bbd.atc.propertymanagement.dto.AddressDTO;

import java.util.List;

@Data
@NoArgsConstructor
public class ApartmentDTO {
    private Integer apartmentID;

    private String Name;

    private AddressDTO address;

    private List<LotDTO> apartmentLots;

    private Integer propertyID;
}
