package co.cpl.CustomExecption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorMessage> methodHttpClientErrorException(HttpServletRequest request, HttpClientErrorException e) {
        ErrorMessage errorMessage = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                Objects.requireNonNull(e.getMessage()).replace(String.valueOf(e.getStatusCode().value()) + " ", ""));
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> methodException(HttpServletRequest request, Exception e) {
        ErrorMessage errorMessage = new ErrorMessage(500, e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
