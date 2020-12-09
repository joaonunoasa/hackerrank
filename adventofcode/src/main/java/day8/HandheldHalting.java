package day8;

import java.util.ArrayList;
import java.util.List;

public class HandheldHalting {

    public static int calculateAccumulatorFor(List<Instruction> originalInstructions) {

        List<Instruction> clonedFromOriginalInstructions = clone(originalInstructions);
        boolean sequenceOfInstructionsContainInfiniteLoop = checkIfSequenceOfInstructionsContainInfiniteLoop(clonedFromOriginalInstructions);

        while (sequenceOfInstructionsContainInfiniteLoop) {
            boolean foundAnInstructionToBeChanged = false;
            int index = 0;
            while (!foundAnInstructionToBeChanged) {
                Instruction candidateInstruction = originalInstructions.get(index);
                String candidateOperation = candidateInstruction.getOperation();
                if (candidateOperation.equals("nop") && !candidateInstruction.isAlreadyTriedToReverted()) {
                    candidateInstruction.setOperation("jmp");
                    candidateInstruction.setAlreadyTriedToReverted(true);
                    foundAnInstructionToBeChanged = true;

                    clonedFromOriginalInstructions = clone(originalInstructions);
                    sequenceOfInstructionsContainInfiniteLoop = checkIfSequenceOfInstructionsContainInfiniteLoop(clonedFromOriginalInstructions);

                    if (sequenceOfInstructionsContainInfiniteLoop) {
                        candidateInstruction.setOperation("nop");
                    }
                }

                if (candidateOperation.equals("jmp") && !candidateInstruction.isAlreadyTriedToReverted()) {
                    candidateInstruction.setOperation("nop");
                    candidateInstruction.setAlreadyTriedToReverted(true);
                    foundAnInstructionToBeChanged = true;

                    clonedFromOriginalInstructions = clone(originalInstructions);
                    sequenceOfInstructionsContainInfiniteLoop = checkIfSequenceOfInstructionsContainInfiniteLoop(clonedFromOriginalInstructions);

                    if (sequenceOfInstructionsContainInfiniteLoop) {
                        candidateInstruction.setOperation("jmp");
                    }
                }

                index++;
            }
        }

        int accumulator = 0;

        for (Instruction instruction: clonedFromOriginalInstructions) {
            if (instruction.isAlreadyExecuted() && instruction.getOperation().equals("acc")) {
                accumulator = accumulator + instruction.getArgument();
            }
        }

        return accumulator;
    }

    private static List<Instruction> clone(List<Instruction> originalInstructions) {

        List<Instruction> cloned = new ArrayList<>();

        for (Instruction instruction : originalInstructions) {
            cloned.add(new Instruction(instruction.getOperation(), instruction.getArgument(), instruction.isAlreadyExecuted(), instruction.isAlreadyTriedToReverted()));
        }

        return cloned;
    }

    private static boolean checkIfSequenceOfInstructionsContainInfiniteLoop(List<Instruction> instructions) {

        int index = 0;

        while (index < instructions.size()) {

            Instruction instruction = instructions.get(index);
            String operation = instruction.getOperation();

            if (instruction.isAlreadyExecuted()) {
                return true;
            }

            if (operation.equals("nop")) {
                index = index + 1;
            }

            if (operation.equals("acc")) {
                index = index + 1;
            }

            if (operation.equals("jmp")) {
                index = index + instruction.getArgument();
            }

            instruction.setAlreadyExecuted(true);
        }

        return false;
    }
}
