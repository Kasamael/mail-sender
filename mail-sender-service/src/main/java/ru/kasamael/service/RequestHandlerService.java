package ru.kasamael.service;

import ru.kasamael.model.dto.MailSendDTO;

public interface RequestHandlerService {

    void handle(MailSendDTO mailSendDTO);
}
