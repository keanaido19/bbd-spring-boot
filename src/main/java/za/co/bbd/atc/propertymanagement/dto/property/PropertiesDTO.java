package za.co.bbd.atc.propertymanagement.dto.property;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PropertiesDTO {
    private List<HouseDTO> houses;

    private List<ApartmentDTO> apartments;

    private List<EstateDTO> estates;
}
