import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Row extends Prototype {

    private List<SudokuElement> sudokuElementList = createSudokuElementsList();

    public List<SudokuElement> createSudokuElementsList() {
        List<SudokuElement> sudokuElementList = new ArrayList<>();
        for (int n = 0; n <= 8; n++) {
            SudokuElement sudokuElement = new SudokuElement();
            sudokuElementList.add(sudokuElement);
            sudokuElement.setPossibleElementsList(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).collect(Collectors.toList()));
        }
        return sudokuElementList;
    }

    public List<SudokuElement> getSudokuElementList() {
        return sudokuElementList;
    }
}
