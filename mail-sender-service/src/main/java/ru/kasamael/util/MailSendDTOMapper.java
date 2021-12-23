package ru.kasamael.util;

import lombok.experimental.UtilityClass;
import ru.kasamael.model.dto.MailSendDTO;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class MailSendDTOMapper {

    public Map<String, Object> createArgsFromMailSendDTO(MailSendDTO mailSendDTO) {
        Map<String, Object> args = new HashMap<>();
        args.put("amount", mailSendDTO.getAmount());
        args.put("recipientInfo_name", mailSendDTO.getRecipientInfo().getName());
        args.put("recipientInfo_inn", mailSendDTO.getRecipientInfo().getInn());
        args.put("recipientInfo_kpp", mailSendDTO.getRecipientInfo().getKpp());
        args.put("recipientInfo_bank", mailSendDTO.getRecipientInfo().getBank());
        args.put("recipientInfo_bankAccountNumber", mailSendDTO.getRecipientInfo().getBankAccountNumber());
        args.put("recipientInfo_bik", mailSendDTO.getRecipientInfo().getBik());
        args.put("recipientInfo_accountNumber", mailSendDTO.getRecipientInfo().getAccountNumber());
        args.put("payerInfo_name", mailSendDTO.getPayerInfo().getName());
        args.put("payerInfo_inn", mailSendDTO.getPayerInfo().getInn());
        args.put("payerInfo_kpp", mailSendDTO.getPayerInfo().getKpp());
        args.put("payerInfo_bank", mailSendDTO.getPayerInfo().getBank());
        args.put("payerInfo_bankAccountNumber", mailSendDTO.getPayerInfo().getBankAccountNumber());
        args.put("payerInfo_bik", mailSendDTO.getPayerInfo().getBik());
        args.put("payerInfo_accountNumber", mailSendDTO.getPayerInfo().getAccountNumber());
        return args;
    }
}
