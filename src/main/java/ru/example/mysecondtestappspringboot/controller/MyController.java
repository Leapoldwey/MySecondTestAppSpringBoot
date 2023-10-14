package ru.example.mysecondtestappspringboot.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.example.mysecondtestappspringboot.exeption.UnsupportedCodeException;
import ru.example.mysecondtestappspringboot.exeption.ValidationFailedException;
import ru.example.mysecondtestappspringboot.model.*;
import ru.example.mysecondtestappspringboot.service.ModifyRequestService;
import ru.example.mysecondtestappspringboot.service.ModifyResponseService;
import ru.example.mysecondtestappspringboot.service.ValidationService;
import ru.example.mysecondtestappspringboot.util.DateTimeUtil;

import java.util.Date;;

@RestController
@Slf4j
public class MyController {
    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;
    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifyOperationUidResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("ModifySystemNameRequestService") ModifyRequestService modifyRequestService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
    }

    @PostMapping("/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) {

        log.info("request {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCode.EMPTY)
                .errorMessage(ErrorMessage.EMPTY)
                .build();
        request.setSystemTime(response.getSystemTime());

        log.info("response {}", response);

        try {
            validationService.isValid(bindingResult);

            if (request.getUid().equals("123")) {
                throw new UnsupportedCodeException();
            }

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
        modifyResponseService.modify(response);
        modifyRequestService.modify(request);

        log.info("response {}", response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

