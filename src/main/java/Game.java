import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<SudokuElement> list = new ArrayList<>();
    private Counter counter = new Counter();
    private ValueChecker valueChecker = new ValueChecker();
    private FieldSetter fieldSetter = new FieldSetter();

    private void isFieldEmpty(Board board) {

        if (counter.eliminatePossibleInAllFields(board)) {
            for (int x = board.MIN_INDEX; x <= board.MAX_INDEX; x++) {
                for (int y = board.MIN_INDEX; y <= board.MAX_INDEX; y++) {
                    boolean isEmpty = valueChecker.checkValue(board, x, y);
                    SudokuElement sudokuElement = board.getRowList().get(x).getSudokuElementList().get(y);
                    do {
                        counter.eliminatePossibleInAllFields(board);
                        if (isEmpty) {
                            if (sudokuElement.getPossibleElementsList().size() == 0) {
                                sudokuElement.setValue(0);
                            } else
                                fieldSetter.setField(board, sudokuElement, x, y);
                        }
                    }
                    while (checkAll(board, x, y));
                    counter.changeNullToEmpty(board);
                    System.out.println(board);
                }
            }
        }
    }

    private boolean checkAll(Board board, int a, int b) {
        SudokuElement sudokuElement = board.getRowList().get(a).getSudokuElementList().get(b);
        if (sudokuElement.getValue() < 0) {
            list.add(sudokuElement);
        }
        return list.size() > 0;
    }

    public boolean resolveSudoku(Board board) {
        boolean result = false;
        isFieldEmpty(board);
        if (counter.countEmpty(board).size() > 0) {
            result = true;
        }
        return result;
    }
}
