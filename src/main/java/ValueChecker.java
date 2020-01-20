public class ValueChecker {

    public boolean checkEmptyValues(Board board, int a, int b) {
        SudokuElement sudokuElement = board.getRowList().get(a).getSudokuElementList().get(b);
        if (sudokuElement.getValue() < 0) {
            return true;
        } else return false;
    }

    public boolean checkValue(Board board, int a, int b) {
        SudokuElement sudokuElement = board.getRowList().get(a).getSudokuElementList().get(b);
        if (sudokuElement.getValue() < 0) {
            return true;
        } else return false;
    }

    public boolean checkNullValues(Board board, int a, int b) {
        SudokuElement sudokuElement = board.getRowList().get(a).getSudokuElementList().get(b);
        if (sudokuElement.getValue() == 0) {
            return true;
        } else return false;
    }
}
