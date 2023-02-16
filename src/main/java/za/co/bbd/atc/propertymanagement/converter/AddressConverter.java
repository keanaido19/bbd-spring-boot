package za.co.bbd.atc.propertymanagement.converter;

import org.springframework.stereotype.Component;
import za.co.bbd.atc.propertymanagement.entity.AddressEntity;
import za.co.bbd.atc.propertymanagement.model.dto.AddressDTO;

@Component
public class AddressConverter {
    public AddressDTO convertEntityToDTO(AddressEntity addressEntity) {
        AddressDTO dto = new AddressDTO();

        if (null != addressEntity) {
            dto.setStreet(addressEntity.getStreet());
            dto.setCity(addressEntity.getCity());
            dto.setProvince(addressEntity.getProvince());
            dto.setZip(addressEntity.getZip());
            dto.setCountry(addressEntity.getCountry());
        }

        return dto;
    }
}
