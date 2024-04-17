package uz.pdp.g33hateoas.controller.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.g33hateoas.ErrorResponseDTO;

@RestControllerAdvice
public class GlobalExceptionControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResponseDTO handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ErrorResponseDTO("NOT_FOUND", ex.getMessage());
    }
}
