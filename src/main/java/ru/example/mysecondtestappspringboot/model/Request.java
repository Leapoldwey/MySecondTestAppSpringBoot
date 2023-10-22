package ru.example.mysecondtestappspringboot.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.Position;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    /***
     * Уникальный идентификатор сообщение
     */
    @NotBlank(message = "uid не может быть пустым")
    @Size(max = 32, message = "uid не должен превышать 32 символа")
    private String uid;
    /***
     * Уникальный идентификатор операции
     */
    @NotBlank(message = "operationUid не может быть пустым")
    @Size(max = 32, message = "operationUid не может превышать 32 символа")
    private String operationUid;
    /***
     * Имя системы отправителя
     */
    private String systemName;
    /***
     * Время создания сообщения
     */
    @NotBlank(message = "systemTime не может быть пустым")
    private String systemTime;
    /***
     * Наименование ресурса
     */
    private String source;
    /***
     * Коэффициент позиции (должность)
     */
    private Position position;
    /***
     * Заработная плата
     */
    private Double salary;
    /***
     * Коэффициент прибыли
     */
    private Double bonus;
    /***
     * Количеств отработанных дней
     */
    private Integer workDays;
    /***
     * Уникальный идентификатор коммуникации
     */
    @Min(value = 1, message = "communicationId не может быть меньше 1")
    @Max(value = 100000, message = "communicationId не может быть больше 100000")
    private int communicationId;
    /***
     * Уникальный идентификатор шаблона
     */
    private int templateId;
    /***
     * Код продукта
     */
    private int productCode;
    /***
     * Смс код
     */
    private int smsCode;

    @Override
    public String toString() {
        return "Request{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                '}';
    }
}
