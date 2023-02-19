package za.co.bbd.atc.propertymanagement.converter.property;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.bbd.atc.propertymanagement.converter.AddressConverter;
import za.co.bbd.atc.propertymanagement.dto.property.HouseDTO;
import za.co.bbd.atc.propertymanagement.entity.property.HouseEntity;
import za.co.bbd.atc.propertymanagement.entity.property.PropertyEntity;

import java.util.List;

@RequiredArgsConstructor
@Component
public class HouseConverter {
    private final AddressConverter addressConverter;

    public HouseDTO convertEntityToDTO(PropertyEntity propertyEntity) {
        HouseEntity houseEntity = propertyEntity.getHouseEntity();
        HouseDTO dto = new HouseDTO();
        dto.setPropertyType("HOUSE");
        dto.setHouseID(houseEntity.getId());

        dto.setAddress(addressConverter.convertEntityToDTO(propertyEntity.getAddressEntity()));
        dto.setPropertyID(propertyEntity.getId());

        return dto;
    }

    public HouseDTO convertEntityToDTO(HouseEntity houseEntity) {
        HouseDTO dto = new HouseDTO();
        dto.setPropertyType("HOUSE");
        dto.setHouseID(houseEntity.getId());


        PropertyEntity propertyEntity = houseEntity.getPropertyEntity();
        dto.setAddress(addressConverter.convertEntityToDTO(propertyEntity.getAddressEntity()));
        dto.setPropertyID(propertyEntity.getId());

        return dto;
    }

    public List<HouseDTO> convertEntityListToDTOlist(List<HouseEntity> houseEntities) {
        return houseEntities.stream().map(this::convertEntityToDTO).toList();
    }

}
