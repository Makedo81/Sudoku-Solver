import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FieldSetter {

    private FirstStepFieldSetter firstStepFieldSetter = new FirstStepFieldSetter();
    private PossibleChecker possibleChecker = new PossibleChecker();
    private Counter counter = new Counter();

    public void setField(Board board, SudokuElement sudokuElement, int x, int y) {
        Integer value = sudokuElement.getPossibleElementsList().get(0);
        List<Integer> possibleListToEliminate = new ArrayList<>();
        if (!firstStepFieldSetter.checkEverySinglePossible(board, sudokuElement, x, y) && sudokuElement.getValue() == -1 ) {
            counter.eliminatePossibleInAllFields(board);
            for (int i = 0; i < sudokuElement.getPossibleElementsList().size(); i++) {
                Integer number = sudokuElement.getPossibleElementsList().get(i);
                if (!possibleChecker.checkPossibleIn2SectionsInRow(board, x, y, number)) {
                    System.out.println(" 1 Setting field with " + number);
                    sudokuElement.setValue(number);
                }
                if (possibleChecker.checkPossibleIn2SectionsInRow(board, x, y, number)) {
                    for (int k = 0; k < sudokuElement.getPossibleElementsList().size(); k++) {
                        possibleListToEliminate.add(number);
                    }
                }
                if (sudokuElement.getPossibleElementsList().containsAll(possibleListToEliminate)) {
                    Random random = new Random();
                    int randomPossibleValue = random.nextInt(sudokuElement.getPossibleElementsList().size());
                    System.out.println(" 2 Setting field with " + randomPossibleValue);
                    sudokuElement.setValue(sudokuElement.getPossibleElementsList().get(randomPossibleValue));
                }
           }
        } else {
            if (sudokuElement.getValue() == -1) {
                for (int  i = 0; i < sudokuElement.getPossibleElementsList().size(); i++) {
                    Integer number = sudokuElement.getPossibleElementsList().get(i);
                    if (possibleChecker.checkPossibleIn2SectionsInRow(board, x, y, number)) {
                        for (int k = 0; k < sudokuElement.getPossibleElementsList().size(); k++) {
                            possibleListToEliminate.add(number);
                        }
                    }
                    if (sudokuElement.getPossibleElementsList().containsAll(possibleListToEliminate)) {
                        sudokuElement.getPossibleElementsList().removeAll(possibleListToEliminate);
                        System.out.println(" 3 Setting field with " + value);
                        sudokuElement.setValue(value);
                    }
                }
            }
        }
    }
}
