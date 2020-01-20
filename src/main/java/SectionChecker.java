import java.util.ArrayList;
import java.util.List;

public class SectionChecker {

    public List<Integer> createEmptySudokuList(Board board, int x, int y) {
        List<Integer> list = new ArrayList<>();
        if (x <= 2 &&  y <= 2) {
            for (int a = board.MIN_INDEX; a <= 2; a++) {
                for (int b = board.MIN_INDEX; b <=2; b++) {
                    addSudokuWithValueToList( board,a,b,list);
                }
            }
        }
        if  (x <= 2 && y >= 3  && y <= 5) {
            for (int a = 0; a <= 2; a++) {
                for (int b = 3; b <= 5; b++) {
                    addSudokuWithValueToList( board,a,b,list);
                }
            }
        }
        if (x <= 2 && y <= 8 && y >= 6) {
            for (int a = 0; a <=2; a++) {
                for (int b = 6; b <= 8; b++) {
                    addSudokuWithValueToList( board,a,b,list);
                }
            }
        }
        if (x >= 3 &&  x <= 5 &&  y <= 2) {
            for (int a = 3; a <= 5; a++) {
                for (int b = 0; b <=2; b++) {
                    addSudokuWithValueToList( board,a,b,list);
                }
            }
        }
        if (x >= 3 && x <= 5 && y >= 3 &&  y <= 5 ) {
            for (int a = 3; a <= 5; a++) {
                for (int b = 3; b <= 5; b++) {
                    addSudokuWithValueToList( board,a,b,list);
                }
            }
        }
        if (x >= 3 && x <= 5 && y <= 8 &&  y >= 6) {
            for (int a = 3; a <=5; a++) {
                for (int b = 6; b <= 8; b++) {
                    addSudokuWithValueToList( board,a,b,list);
                }
            }
        }
        if (x >= 6 &&  x <= 8 &&   y <= 2) {
            for (int a = 6; a <= 8; a++) {
                for (int b = 0; b <=2; b++) {
                    addSudokuWithValueToList( board,a,b,list);
                }
            }
        }
        if (x >= 6 && x <= 8 &&  y >= 3 &&  y <= 5 ) {
            for (int a = 6; a <= 8; a++) {
                for (int b = 3; b <= 5; b++) {
                    addSudokuWithValueToList( board,a,b,list);
                }
            }
        }
        if (x >= 6 && x <= 8 &&  y >= 6 &&  y <= 8) {
            for (int a = 6; a <=8; a++) {
                for (int b = 6; b <= 8; b++) {
                    addSudokuWithValueToList( board,a,b,list);
                }
            }
        }
        return list;
    }

    private void addSudokuWithValueToList(Board board, int a, int b, List<Integer> list){
        SudokuElement sudokuElement = board.getRowList().get(a).getSudokuElementList().get(b);
        if (sudokuElement.getValue() != -1) {
            list.add(sudokuElement.getValue());
        }
    }
}
