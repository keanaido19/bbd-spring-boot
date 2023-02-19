package za.co.bbd.atc.propertymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleUserNotFound(
            MethodArgumentNotValidException methodArgumentNotValidException
    ) {
        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
        List<ErrorModel> errorModelList = fieldErrors.stream()
                .map(fe -> {
                    ErrorModel errorModel = new ErrorModel();
                    errorModel.setCode(fe.getField());
                    errorModel.setMessage(fe.getDefaultMessage());
                    return errorModel;
                }).toList();

        return new ResponseEntity<>(errorModelList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException) {
        return new ResponseEntity<>(businessException.getErrors(), businessException.getHttpStatus());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<List<ErrorModel>> handleUserNotFound(UserNotFoundException userNotFoundException) {
        return new ResponseEntity<>(userNotFoundException.getErrors(), userNotFoundException.getHttpStatus());
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<List<ErrorModel>> handleSQLException(SQLException sqlException) {
        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode("SQL_ERROR_" + sqlException.getErrorCode());
        errorModel.setMessage(sqlException.getMessage());
        errorModelList.add(errorModel);
        return new ResponseEntity<>(errorModelList, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
