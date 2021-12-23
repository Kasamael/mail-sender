package ru.kasamael.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("mail-service")
public class MailProperties {

    private String sender;
}
