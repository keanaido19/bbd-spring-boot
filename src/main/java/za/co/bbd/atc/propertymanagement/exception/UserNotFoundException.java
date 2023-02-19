package za.co.bbd.atc.propertymanagement.exception;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserNotFoundException extends RuntimeException {
    private List<ErrorModel> errors;
    private final HttpStatus httpStatus = HttpStatus.NOT_FOUND;

    public UserNotFoundException(Integer id) {
        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode("USER_NOT_FOUND");
        errorModel.setMessage("Unable to locate User of ID: " + id);
        errorModelList.add(errorModel);
        this.errors = errorModelList;
    }
}
