package ru.kasamael.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ru.kasamael.model.dto.MailMessageDTO;
import ru.kasamael.service.MailService;


@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private static final String ENCODING_UTF_8 = "UTF_8";

    private final JavaMailSender javaMailSender;

    @Override
    public void send(MailMessageDTO mailMessageDTO) {
        javaMailSender.send(mimeMessage -> {

            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, ENCODING_UTF_8);
            messageHelper.setFrom(mailMessageDTO.getSender());
            messageHelper.setTo(mailMessageDTO.getReceiver());
            messageHelper.setText(mailMessageDTO.getContent(), true);
            messageHelper.setSubject(mailMessageDTO.getSubject());
        });
    }


}
