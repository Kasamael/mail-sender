package ru.kasamael.service;

import ru.kasamael.model.dto.MailMessageDTO;

public interface MailService {

    void send(MailMessageDTO mailMessageDTO);
}
