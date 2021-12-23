package ru.kasamael.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailSendDTO {

    private String subject;
    private String receiver;
    private BigDecimal amount;
    private PersonInfoDTO recipientInfo;
    private PersonInfoDTO payerInfo;
}
