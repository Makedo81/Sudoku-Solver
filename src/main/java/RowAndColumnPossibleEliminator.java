import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RowAndColumnPossibleEliminator {

    public List<Integer> createNumbersToEliminateList(Board board, int x, int y) {
        List<Integer> numbersToEliminate = new ArrayList<>();

        for (int k = x; k <= x; k++) {
            for (int n = 0; n <= 8; n++) {
                final SudokuElement valueForCurrent = board.getRowList().get(k).getSudokuElementList().get(n);
                final SudokuElement valueForCurrent1 = board.getRowList().get(n).getSudokuElementList().get(y);
                if (valueForCurrent.getValue() != -1) {
                    numbersToEliminate.add(valueForCurrent.getValue());
                }
                if (valueForCurrent1.getValue() != -1) {
                    numbersToEliminate.add(valueForCurrent1.getValue());
                }
            }
        }
        return numbersToEliminate.stream().distinct().collect(Collectors.toList());
    }
}

