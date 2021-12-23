package ru.kasamael.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kasamael.config.properties.MailProperties;
import ru.kasamael.model.dto.GenerateContentDTO;
import ru.kasamael.model.dto.MailMessageDTO;
import ru.kasamael.model.dto.MailSendDTO;
import ru.kasamael.model.enums.NotificationType;
import ru.kasamael.service.MailContentGeneratorService;
import ru.kasamael.service.MailService;
import ru.kasamael.service.RequestHandlerService;
import ru.kasamael.util.MailSendDTOMapper;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class RequestHandlerServiceImpl implements RequestHandlerService {

    private final MailProperties mailProperties;
    private final MailService mailService;
    private final MailContentGeneratorService mailContentGeneratorService;

    @Override
    public void handle(MailSendDTO mailSendDTO) {
        Map<String, Object> argsFromMailSendDTO = MailSendDTOMapper.createArgsFromMailSendDTO(mailSendDTO);
        String content = mailContentGeneratorService.generateContentFromMailSendDTO(GenerateContentDTO.builder()
                .args(argsFromMailSendDTO)
                .notificationType(NotificationType.PAYMENT_ORDER)
                .build());
        mailService.send(MailMessageDTO.builder()
                .content(content)
                .sender(mailProperties.getSender())
                .subject(mailSendDTO.getSubject())
                .receiver(mailSendDTO.getReceiver())
                .build());
    }
}
