package ru.kasamael.service;

import ru.kasamael.model.dto.GenerateContentDTO;

public interface MailContentGeneratorService {

    String generateContentFromMailSendDTO(GenerateContentDTO generateContentDTO);
}
