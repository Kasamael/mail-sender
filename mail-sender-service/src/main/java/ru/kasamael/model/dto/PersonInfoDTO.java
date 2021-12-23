package ru.kasamael.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfoDTO {

    private String name;
    private String inn;
    private String kpp;
    private String bank;
    private String bankAccountNumber;
    private String bik;
    private String accountNumber;
}
