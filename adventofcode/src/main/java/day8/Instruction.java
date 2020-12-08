package day8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Instruction {

    private String operation;
    private int argument;
    private boolean alreadyExecuted;
}
