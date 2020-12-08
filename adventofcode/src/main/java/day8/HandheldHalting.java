package day8;

import java.util.List;

public class HandheldHalting {

    public static int calculateAccumulatorFor(List<Instruction> instructions) {

        int accumulator = 0;
        int index = 0;

        while (true) {

            Instruction instruction = instructions.get(index);
            String operation = instruction.getOperation();

            if (instruction.isAlreadyExecuted()) {
                break;
            }

            if (operation.equals("nop")) {
                index = index + 1;
                instruction.setAlreadyExecuted(true);
            }

            if (operation.equals("acc")) {
                index = index + 1;
                accumulator = accumulator + instruction.getArgument();
                instruction.setAlreadyExecuted(true);
            }

            if (operation.equals("jmp")) {
                index = index + instruction.getArgument();
                instruction.setAlreadyExecuted(true);
            }
        }

        return accumulator;
    }
}
