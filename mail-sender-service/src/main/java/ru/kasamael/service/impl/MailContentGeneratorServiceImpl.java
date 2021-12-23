package ru.kasamael.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;
import ru.kasamael.model.dto.ContextWrapper;
import ru.kasamael.model.dto.GenerateContentDTO;
import ru.kasamael.service.MailContentGeneratorService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MailContentGeneratorServiceImpl implements MailContentGeneratorService {

    public static final String CTX = "ctx";

    @Resource(name = "htmlTemplateEngine")
    private final ITemplateEngine htmlTemplateEngine;

    @Override
    public String generateContentFromMailSendDTO(GenerateContentDTO generateContentDTO) {
        Context context = new Context(Locale.getDefault(), new HashMap<String, Object>() {{
            put(CTX, new ContextWrapper(generateContentDTO.getArgs()));
        }});
        return htmlTemplateEngine.process(generateContentDTO.getNotificationType().name().toLowerCase(), context);
    }
}
