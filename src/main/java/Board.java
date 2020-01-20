import java.util.ArrayList;
import java.util.List;

public class Board extends Prototype {

    public final static int MIN_INDEX = 0;
    public final static int MAX_INDEX = 8;
    private List<Row> rowList = createRowsList();
    int xInput,yInput,valueInput;

    public List<Row> getRowList() {
        return rowList;
    }

    private List<Row> createRowsList() {
        List<Row> list = new ArrayList<>();
        for (int i = MIN_INDEX; i <= MAX_INDEX; i++) {
            list.add(new Row());
        }
        return list;
    }

    public int setX(int a) { return a; }
    public int setY(int b) { return b; }
    public int setValue(int c){ return c; }

    public String toString() {

        String result = "";
        for (int k = MIN_INDEX; k <= MAX_INDEX; k++) {
            result += (MAX_INDEX-k)+ 1 + "|";
            for (int n = MIN_INDEX; n <= MAX_INDEX; n++) {
                SudokuElement sudokuElement1 =  this.getRowList().get(n).getSudokuElementList().get(k);
                if (MAX_INDEX-k==setY(yInput) && n==setX(xInput)) {
                    SudokuElement sudokuElement =  this.getRowList().get(n).getSudokuElementList().get(k);
                    sudokuElement.setValue(setValue(valueInput));
                    result += "_"  + sudokuElement.getValue() + "_";
                }else
                    try {
                        Board clonedBoard = (Board) this.clone();
                        int  number = clonedBoard.getRowList().get(n).getSudokuElementList().get(k).getValue();
                        if (this.getRowList().get(n).getSudokuElementList().get(k).getValue()> 0 ) {
                            result += "_" + number + "_";
                        }
                        else if (sudokuElement1.getValue()==-1){
                            result += "_" +  sudokuElement1.getValue() + "_";
                        }
                        result += "|";

                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
            }
            result += "\n";
        }
        return result;
    }
}


