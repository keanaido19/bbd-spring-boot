package za.co.bbd.atc.propertymanagement.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NamesDTO {
    @NotNull
    @NotBlank
    String firstName;

    String lastName;
}
