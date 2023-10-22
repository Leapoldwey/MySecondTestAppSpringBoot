package ru.example.mysecondtestappspringboot.cleanController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import ru.example.mysecondtestappspringboot.exeption.UnsupportedCodeException;
import ru.example.mysecondtestappspringboot.exeption.ValidationFailedException;
import ru.example.mysecondtestappspringboot.model.*;
import ru.example.mysecondtestappspringboot.service.UnsupportedService;
import ru.example.mysecondtestappspringboot.service.ValidationService;
@Slf4j
public class CleanExceptions {
    public static ResponseEntity<Response> cleanExceptions(ValidationService validationService,
                                                           UnsupportedService unsupportedService,
                                          BindingResult bindingResult, Request request, Response response) {
        try {
            validationService.isValid(bindingResult);
            unsupportedService.unsupp(request);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCode.VALIDATION_CODE);
            response.setErrorMessage(ErrorMessage.VALIDATION_MESSAGE);
            log.info("response {}", response);
            log.error("ValidationFailedException", e);
            System.err.println("Message: " + bindingResult.getFieldError().getDefaultMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e) {
            response.setCode(Codes.UNSUPPORTED);
            response.setErrorCode(ErrorCode.UNSUPPORTED_CODE);
            response.setErrorMessage(ErrorMessage.UNSUPPORTED_MESSAGE);
            log.info("response {}", response);
            log.error("UnsupportedCodeException", e);
            System.err.println(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCode.UNKNOWN_CODE);
            response.setErrorMessage(ErrorMessage.UNKNOWN_MESSAGE);
            log.info("response {}", response);
            log.error("Exception", e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }
}
