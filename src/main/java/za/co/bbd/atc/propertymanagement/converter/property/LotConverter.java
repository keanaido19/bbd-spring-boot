package za.co.bbd.atc.propertymanagement.converter.property;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.bbd.atc.propertymanagement.converter.AddressConverter;
import za.co.bbd.atc.propertymanagement.dto.property.LotDTO;
import za.co.bbd.atc.propertymanagement.entity.property.LotEntity;
import za.co.bbd.atc.propertymanagement.entity.property.PropertyEntity;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LotConverter {
    private final AddressConverter addressConverter;
    public LotDTO convertEntityToDTO(LotEntity lotEntity) {
        LotDTO dto = new LotDTO();
        dto.setLotID(lotEntity.getId());
        dto.setLotNumber(lotEntity.getNumber());

        PropertyEntity propertyEntity = lotEntity.getPropertyEntity();
        dto.setAddress(addressConverter.convertEntityToDTO(propertyEntity.getAddressEntity()));
        dto.setPropertyID(propertyEntity.getId());

        return dto;
    }

    public List<LotDTO> convertEntityListToDTOlist(List<LotEntity> lotEntityList) {
        return lotEntityList.stream().map(this::convertEntityToDTO).toList();
    }
}
