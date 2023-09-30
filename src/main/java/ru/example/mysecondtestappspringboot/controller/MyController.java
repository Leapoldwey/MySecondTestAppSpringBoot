package ru.example.mysecondtestappspringboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.example.mysecondtestappspringboot.exeption.UnsupportedCodeException;
import ru.example.mysecondtestappspringboot.exeption.ValidationFailedException;
import ru.example.mysecondtestappspringboot.model.*;
import ru.example.mysecondtestappspringboot.service.ValidationService;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class MyController {
    private final ValidationService validationService;

    @Autowired
    public MyController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping("/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(simpleDateFormat.format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCode.EMPTY)
                .errorMessage(ErrorMessage.EMPTY)
                .build();
        try {
            validationService.isValid(bindingResult);

            if (request.getUid().equals("123")) {
                throw new UnsupportedCodeException();
            }

        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCode.VALIDATION_CODE);
            response.setErrorMessage(ErrorMessage.VALIDATION_MESSAGE);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e) {
            response.setCode(Codes.UNSUPPORTED);
            response.setErrorCode(ErrorCode.UNSUPPORTED_CODE);
            response.setErrorMessage(ErrorMessage.UNSUPPORTED_MESSAGE);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCode.UNKNOWN_CODE);
            response.setErrorMessage(ErrorMessage.UNKNOWN_MESSAGE);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

