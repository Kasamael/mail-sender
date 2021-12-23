package ru.kasamael;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import ru.kasamael.model.dto.GenerateContentDTO;
import ru.kasamael.model.enums.NotificationType;
import ru.kasamael.service.impl.MailContentGeneratorServiceImpl;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(value = MockitoJUnitRunner.class)
public class MailContentGeneratorServiceTest {

    private static final String RESULT_CONTENT = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            "<section>\n" +
            "    <tr>\n" +
            "        <td>\n" +
            "           Сумма <span>10000</span>\n" +
            "        </td>\n" +
            "    </tr>\n" +
            "</section>\n" +
            "</body>\n" +
            "</html>";

    MailContentGeneratorServiceImpl service;

    private SpringTemplateEngine htmlTemplateEngine;

    @Before
    public void setUp() {
        ClassLoaderTemplateResolver classLoaderTemplateResolver = new ClassLoaderTemplateResolver();
        classLoaderTemplateResolver.setTemplateMode(TemplateMode.HTML);
        classLoaderTemplateResolver.setCheckExistence(true);
        classLoaderTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        classLoaderTemplateResolver.setPrefix("/templates/");
        classLoaderTemplateResolver.setSuffix(".html");
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(classLoaderTemplateResolver);
        templateEngine.addDialect(new LayoutDialect());

        htmlTemplateEngine = templateEngine;

        service = new MailContentGeneratorServiceImpl(htmlTemplateEngine);
    }

    /**
     * Может не работать из-за символов перехода строки
     */
    @Test
    public void buildContent() {
        Map<String, Object> args = new HashMap<>();
        args.put("amount", 10_000);
        String content = service.generateContentFromMailSendDTO(GenerateContentDTO.builder().args(args).notificationType(NotificationType.PAYMENT_ORDER).build());
        assertThat(content).isEqualTo(RESULT_CONTENT);
    }
}
