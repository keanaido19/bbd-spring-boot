package za.co.bbd.atc.propertymanagement.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class PhoneNumberDTO {
    @NotNull
    @NotBlank
    private String countryCode;

    @NotNull
    @NotBlank
    private String phoneNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumberDTO that = (PhoneNumberDTO) o;
        return Objects.equals(countryCode, that.countryCode) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, phoneNumber);
    }
}
