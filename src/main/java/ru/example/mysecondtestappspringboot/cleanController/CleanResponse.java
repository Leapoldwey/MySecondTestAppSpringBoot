package ru.example.mysecondtestappspringboot.cleanController;

import ru.example.mysecondtestappspringboot.model.*;
import ru.example.mysecondtestappspringboot.service.QuarterlyBonus;
import ru.example.mysecondtestappspringboot.util.DateTimeUtil;

import java.util.Date;

public class CleanResponse {
    public static Response rsp(Request request, QuarterlyBonus quarterlyBonus) {
        return Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .quarterlyBonus(quarterlyBonus.calculate(request.getSalary(), Positions.TL,
                        request.getBonus(), request.getWorkDays()))
                .errorCode(ErrorCode.EMPTY)
                .errorMessage(ErrorMessage.EMPTY)
                .build();
    }
}
