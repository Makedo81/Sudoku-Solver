import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Counter {

    public final static int MIN_INDEX = 0;
    public final static int MAX_INDEX = 8;
    private RowAndColumnPossibleEliminator rowAndColumnPossibleEliminator = new RowAndColumnPossibleEliminator();
    private SectionChecker sectionChecker = new SectionChecker();
    private ValueChecker valueChecker = new ValueChecker();

    public boolean eliminatePossibleInAllFields(Board board) {

        int counter = 82;
        for (int x = MIN_INDEX; x <= MAX_INDEX; x++) {
            for (int y = MIN_INDEX; y <= MAX_INDEX; y++) {
                SudokuElement sudokuElement = board.getRowList().get(x).getSudokuElementList().get(y);
                boolean isEmpty = valueChecker.checkEmptyValues(board, x, y);
                do {
                    counter--;
                    if (isEmpty) {
                        List<Integer> possibleNumbersToEliminate = rowAndColumnPossibleEliminator.createNumbersToEliminateList(board, x, y);
                        possibleNumbersToEliminate.addAll(sectionChecker.createEmptySudokuList(board, x, y));
                        List<Integer> filtratedPossibleList = possibleNumbersToEliminate.stream().distinct().collect(Collectors.toList());
                        sudokuElement.getPossibleElementsList().removeAll(filtratedPossibleList);
                    }
                }
                while (counter == 0);
            }
        }
        return true;
    }

    public void changeNullToEmpty(Board board) {
        int counter = 82;
        for (int x = MIN_INDEX; x <= MAX_INDEX; x++) {
            for (int y = MIN_INDEX; y <= MAX_INDEX; y++) {
                boolean isNull = valueChecker.checkNullValues(board, x, y);
                do {
                    counter--;
                    if (isNull) {
                        board.getRowList().get(x).getSudokuElementList().get(y).setValue(SudokuElement.Empty);
                    }
                }
                while (counter == 0);
            }
        }
    }

    public List<Integer> countEmpty(Board board) {
        List<Integer> emptyValuesList = new ArrayList<>();
        int counter = 82;
        for (int x = MIN_INDEX; x <= MAX_INDEX; x++) {
            for (int y = MIN_INDEX; y <= MAX_INDEX; y++) {
                boolean isEmpty = valueChecker.checkEmptyValues(board, x, y);
                do {
                    counter--;
                    if (isEmpty) {
                        int k = 0;
                        emptyValuesList.add(k + 1);
                    }
                }
                while (counter == 0);
            }
        }
        return emptyValuesList;
    }
}
