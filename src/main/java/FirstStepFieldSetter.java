import java.util.List;
import java.util.Random;

public class FirstStepFieldSetter {

    private PossibleChecker possibleChecker = new PossibleChecker();
    private PossibleSectionChecker possibleSectionChecker = new PossibleSectionChecker();
    private boolean done = false;

    public boolean checkEverySinglePossible(Board board, SudokuElement sudokuElement, int x, int y) {

        for (int i = 0; i < sudokuElement.getPossibleElementsList().size(); i++) {
            Integer number = sudokuElement.getPossibleElementsList().get(i);
            List<Integer> checkedPossibleList = possibleSectionChecker.checkPossibleIn3Sections(board, x, y, number);
            if (!possibleChecker.checkPossibleInRow(board, x, y, number, sudokuElement)&& sudokuElement.getValue()==-1
                    && !possibleChecker.checkPossibleIn2SectionsInRow(board, x, y,number)) {
                System.out.println("4 Setting field with " + number);
                sudokuElement.setValue(number);
                done = true;

            }  if (checkedPossibleList.size() == 1 && sudokuElement.getValue()==-1) {
                System.out.println("5 Setting field with " + checkedPossibleList.get(0));
                sudokuElement.setValue(checkedPossibleList.get(0));
                done = true;

            } if (checkedPossibleList.size() == 2 && sudokuElement.getPossibleElementsList().size()== 2 && sudokuElement.getValue()==-1 ) {
                boolean foundInOtherPossibleList = possibleChecker.checkPossibleInRow(board, x, y, number, sudokuElement);

                if (!foundInOtherPossibleList) {
                    checkedPossibleList.remove(number);
                    checkedPossibleList.remove(possibleSectionChecker.checkPossibleInCurrentSection(board, x, y, number));
                }
                Random random = new Random();
                int randomPossibleValue = random.nextInt(checkedPossibleList.size());
                System.out.println(" 6 Setting field with " + randomPossibleValue);
                sudokuElement.setValue(sudokuElement.getPossibleElementsList().get(randomPossibleValue));
                done = true;

            }  if (checkedPossibleList.size() == 2 && sudokuElement.getPossibleElementsList().size()> 2
                    && sudokuElement.getValue()==-1 ) {
                possibleSectionChecker.checkPossibleIn3Sections(board,x,y,number);
                done = true;
            }else done = false;
        }
        return done;
    }
}
