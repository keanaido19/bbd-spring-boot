package za.co.bbd.atc.propertymanagement.converter.property;

import lombok.RequiredArgsConstructor;
import za.co.bbd.atc.propertymanagement.converter.AddressConverter;
import za.co.bbd.atc.propertymanagement.dto.property.HouseDTO;
import za.co.bbd.atc.propertymanagement.dto.property.LotDTO;
import za.co.bbd.atc.propertymanagement.entity.property.HouseEntity;
import za.co.bbd.atc.propertymanagement.entity.property.LotEntity;
import za.co.bbd.atc.propertymanagement.entity.property.PropertyEntity;

import java.util.List;

@RequiredArgsConstructor
public class HouseConverter {
    private final AddressConverter addressConverter;
    public HouseDTO convertEntityToDTO(HouseEntity houseEntity) {
        HouseDTO dto = new HouseDTO();
        dto.setHouseID(houseEntity.getId());

        PropertyEntity propertyEntity = houseEntity.getPropertyEntity();
        dto.setAddress(addressConverter.convertEntityToDTO(propertyEntity.getAddressEntity()));
        dto.setPropertyID(propertyEntity.getId());

        return dto;
    }

    public List<HouseDTO> convertEntityListToDTOlist(List<HouseEntity> houseEntityList) {
        return houseEntityList.stream().map(this::convertEntityToDTO).toList();
    }
}
