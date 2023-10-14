package ru.example.mysecondtestappspringboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.example.mysecondtestappspringboot.model.Request;
import ru.example.mysecondtestappspringboot.model.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class DifferenceTime {
    public static void difference(Request request, Response response) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String strDateRequest = request.getSystemTime();
        String strDateResponse = response.getSystemTime();
        try {
            Date dateRequest = simpleDateFormat.parse(strDateRequest);
            Date dateResponse = simpleDateFormat.parse(strDateResponse);

            long difference = dateResponse.getTime() - dateRequest.getTime();

            log.info("Разница во времени {}", difference);
        } catch (Exception e) {
            log.error("Ошибка в расчете разницы времени", e);
        }
    }

}
