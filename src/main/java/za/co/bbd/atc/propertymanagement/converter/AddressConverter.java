package za.co.bbd.atc.propertymanagement.converter;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import za.co.bbd.atc.propertymanagement.dto.AddressDTO;
import za.co.bbd.atc.propertymanagement.entity.AddressEntity;

@Component
public class AddressConverter {

    @SneakyThrows
    public AddressEntity convertDTOtoEntity(AddressDTO addressDTO) {

        if(null == addressDTO.getStreet() ||
        null == addressDTO.getCity() ||
        null == addressDTO.getProvince() ||
        null == addressDTO.getZip() ||
        null == addressDTO.getCountry()) return null;

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet(addressDTO.getStreet());
        addressEntity.setCity(addressDTO.getCity());
        addressEntity.setProvince(addressDTO.getProvince());
        addressEntity.setZip(addressDTO.getZip());
        addressEntity.setCountry(addressDTO.getCountry());
        return addressEntity;
    }

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
