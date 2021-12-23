package ru.kasamael.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kasamael.model.enums.NotificationType;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerateContentDTO {

    private Map<String, Object> args;
    private NotificationType notificationType;
}
