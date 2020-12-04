package day2;

import lombok.Data;

@Data
public class PasswordEntry {

    private final PasswordRule passwordRule;
    private final String letter;
    private final String password;
}
