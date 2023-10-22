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
import ru.example.mysecondtestappspringboot.cleanController.CleanExceptions;
import ru.example.mysecondtestappspringboot.cleanController.CleanResponse;
import ru.example.mysecondtestappspringboot.model.*;
import ru.example.mysecondtestappspringboot.service.*;

;

@RestController
@Slf4j
public class MyController {
    private final ValidationService validationService;
    private final UnsupportedService unsupportedService;
    private final ModifyResponseService modifyResponseService;
    private final QuarterlyBonus quarterlyBonus;
    //private final ModifyRequestService modifyRequestService;
    @Autowired
    public MyController(ValidationService validationService,
                        UnsupportedService unsupportedService,
                        @Qualifier("ModifyOperationUidResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("ModifySystemNameRequestService") ModifyRequestService modifyRequestService,
                        QuarterlyBonus quarterlyBonus) {
        this.validationService = validationService;
        this.unsupportedService = unsupportedService;
        this.modifyResponseService = modifyResponseService;
        this.quarterlyBonus = quarterlyBonus;
        // this.modifyRequestService = modifyRequestService;
    }

    @PostMapping("/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) {

        log.info("request {}", request);

        Response response = CleanResponse.rsp(request, quarterlyBonus);

        //request.setSystemTime(response.getSystemTime());

        log.info("response {}", response);

        CleanExceptions.cleanExceptions(validationService, unsupportedService,
                bindingResult, request, response);

        modifyResponseService.modify(response);
        //modifyRequestService.modify(request);

        log.info("response {}", response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

