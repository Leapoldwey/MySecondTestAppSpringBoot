package ru.example.mysecondtestappspringboot.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @NotBlank(message = "uid не может быть пустым")
    @Size(max = 32, message = "uid не должен превышать 32 символа")
    private String uid;
    @NotBlank(message = "operationUid не может быть пустым")
    @Size(max = 32, message = "operationUid не может превышать 32 символа")
    private String operationUid;
    private Systems systemName;
    @NotBlank(message = "systemTime не может быть пустым")
    private String systemTime;
    private String source;
    @Min(value = 1, message = "communicationId не может быть меньше 1")
    @Max(value = 100000, message = "communicationId не может быть больше 100000")
    private int communicationId;
    private int templateId;
    private int productCode;
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
