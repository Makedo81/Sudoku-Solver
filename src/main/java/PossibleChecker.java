import java.util.List;
import java.util.stream.Collectors;

public class PossibleChecker {

    public boolean checkPossibleInRow(Board board, int x,int y, int number, SudokuElement sudokuElement) {
        boolean foundInOtherPossibleList = false;
        for (int k = x; k <= x; k++) {
            SudokuElement sudokuElement1 = board.getRowList().get(k).getSudokuElementList().get(y);
            if (sudokuElement.getValue() == -1) {
                List<SudokuElement> filtratedSudokuElementListInRow = board.getRowList().get(x).getSudokuElementList().stream()
                        .filter(r -> r.getValue() == -1)
                        .filter(u -> u != sudokuElement1)
                        .collect(Collectors.toList());
                foundInOtherPossibleList = filtratedSudokuElementListInRow.stream()
                        .map(SudokuElement::getPossibleElementsList)
                        .anyMatch(a -> a.contains(number));
            }
        }
        return foundInOtherPossibleList;
    }

    public boolean checkPossibleIn2SectionsInRow(Board board, int x, int y, Integer number) {
        boolean foundInOtherPossibleList = false;
        switch (y) {
            case (0):
            case (1):
            case (2):
                for (int b = 3; b <= 5; b++) {
                    foundInOtherPossibleList = checkIfExistInOtherPossibleList(board,x,b,number);
                    if(!foundInOtherPossibleList){
                for ( b = 6; b <= 8; b++) {
                    foundInOtherPossibleList = checkIfExistInOtherPossibleList(board,x,b,number);
                }}}
                break;
            case (3):
            case (4):
            case (5):
                for (int b = 0; b <= 2; b++) {
                    foundInOtherPossibleList = checkIfExistInOtherPossibleList(board,x,b,number);
                    if(!foundInOtherPossibleList){
                for ( b = 6; b <= 8; b++) {
                    foundInOtherPossibleList = checkIfExistInOtherPossibleList(board,x,b,number);
                }}}
                break;
            case (6):
            case (7):
            case (8):
                for (int b = 0; b <= 2; b++) {
                    foundInOtherPossibleList = checkIfExistInOtherPossibleList(board,x,b,number);
                      if(!foundInOtherPossibleList){
                for (b = 3; b <= 5; b++) {
                    foundInOtherPossibleList = checkIfExistInOtherPossibleList(board,x,b,number);
                }}}
                break;
                default:return foundInOtherPossibleList;
        }
        return foundInOtherPossibleList;
    }

    public boolean checkIfExistInOtherPossibleList(Board board, int x, int y, int number) {
        boolean foundInOtherPossibleList = false;
        SudokuElement sudokuElement = board.getRowList().get(x).getSudokuElementList().get(y);
        if (sudokuElement.getValue() == -1) {
            if (sudokuElement.getPossibleElementsList().contains(number) && (sudokuElement.getValue() == -1)) {
                foundInOtherPossibleList = true;
            }
        }
        return foundInOtherPossibleList;
    }
}
