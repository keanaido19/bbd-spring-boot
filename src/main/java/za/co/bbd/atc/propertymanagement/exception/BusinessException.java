package za.co.bbd.atc.propertymanagement.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    private List<ErrorModel> errors;
    private HttpStatus httpStatus;

    public BusinessException(List<ErrorModel> errorModelList, HttpStatus httpStatus) {
        this.errors = errorModelList;
        this.httpStatus = httpStatus;
    }
}
