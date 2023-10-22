package ru.example.mysecondtestappspringboot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    /***
     * Уникальный идентификатор сообщение
     */
    private String uid;
    /***
     * Уникальный идентификатор операции
     */
    private String operationUid;
    /***
     * Время создания сообщения
     */
    private String systemTime;
    /***
     * Состояние ответа
     */
    private Codes code;
    /***
     * Годовая премия
     */
    private Double quarterlyBonus;
    /***
     * Код ошибки
     */
    private ErrorCode errorCode;
    /***
     * Сообщение ошибки
     */
    private ErrorMessage errorMessage;
}
