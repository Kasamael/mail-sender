package ru.kasamael.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kasamael.model.dto.MailSendDTO;

@RestController
@RequestMapping("/mail/api/")
@RequiredArgsConstructor
public class MailController {


    @PostMapping("/send")
    public void sendMailNotification(@RequestBody MailSendDTO mailSendDTO) {

    }
}
