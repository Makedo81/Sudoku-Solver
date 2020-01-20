import java.util.ArrayList;
import java.util.List;

public class SudokuElement extends Prototype {

    public static final int Empty = -1;
    public int value = Empty;
    public List<Integer> possibleElementsList = new ArrayList<>();

    public SudokuElement() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getPossibleElementsList() {
        return possibleElementsList;
    }

    public void setPossibleElementsList(List<Integer> possibleElementsList) {
        this.possibleElementsList = possibleElementsList;
    }
}
