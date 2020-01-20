import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PossibleSectionChecker {


    private SudokuElement sudokuElement;
    private PossibleChecker possibleChecker = new PossibleChecker();

    public List<SudokuElement> createEmptySudokuListInCurrentSection(Board board, int y, int x) {
        List<SudokuElement> emptySudokuInSectionList = new ArrayList<>();
        if (y <= 2) {
            for (int b = board.MIN_INDEX; b <= 2; b++) {
                sudokuElement = board.getRowList().get(x).getSudokuElementList().get(b);
                if (sudokuElement.getValue() == -1) {
                    emptySudokuInSectionList.add(sudokuElement);
                }
            }
        }
        if (y >= 3 && y <= 5) {
            for (int b = 3; b <= 5; b++) {
                sudokuElement = board.getRowList().get(x).getSudokuElementList().get(b);
                if (sudokuElement.getValue() == -1) {
                    emptySudokuInSectionList.add(sudokuElement);
                }
            }
        }
        if (y <= 8 && y >= 6) {
            for (int b = 6; b <= 8; b++) {
                sudokuElement = board.getRowList().get(x).getSudokuElementList().get(b);
                if (sudokuElement.getValue() == -1) {
                    emptySudokuInSectionList.add(sudokuElement);
                }
            }
        }
        return emptySudokuInSectionList;
    }

    public List<Integer> checkPossibleIn3Sections(Board board, int x, int y, Integer number) {
        List<Integer> list = new ArrayList<>();
        SudokuElement checkedSudoku = board.getRowList().get(x).getSudokuElementList().get(y);
        List<SudokuElement> emptySudokuElementsList = createEmptySudokuListInCurrentSection(board, y, x);

        if (y <= 2) {
            for (int b = board.MIN_INDEX; b <= 2; b++) {
                if (sudokuElement.getValue() == -1) {
                    addToList(board,x,  y, list,number);
                }
            }
        }
        if (emptySudokuElementsList.size() == 1 && sudokuElement == checkedSudoku) {
            list.addAll(emptySudokuElementsList.get(0).getPossibleElementsList());
        }
        if (y >= 3 && y <= 5) {
            for (int b = 3; b <= 5; b++) {
                if (sudokuElement.getValue() == -1) {
                    addToList(board,x,  y, list,number);
                }
            }
        }
        if (emptySudokuElementsList.size() == 1 && sudokuElement == checkedSudoku) {
            list.addAll(emptySudokuElementsList.get(0).getPossibleElementsList());
        }
        if (y <= 8 && y >= 6) {
            for (int b = 6; b <= 8; b++) {
                if (sudokuElement.getValue() == -1) {
                    addToList(board,x,  y, list,number);
                }
            }
        }
        if (emptySudokuElementsList.size() == 1 && sudokuElement == checkedSudoku) {
            list.addAll(emptySudokuElementsList.get(0).getPossibleElementsList());
        }
        List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());
        return distinctList;
    }

    public List<Integer> checkPossibleInCurrentSection(Board board, int x, int y, Integer number) {
        List<Integer> list = new ArrayList<>();
        if (y <= 2) {
            for (int b = board.MIN_INDEX; b <= 2; b++) {
                addSudokuWithValueToList(board,  b,x,  y, list, number);
            }
        }
        if (y >= 3 && y <= 5) {
            for (int b = 3; b <= 5; b++) {
                addSudokuWithValueToList(board,  b,x,  y, list, number);
            }
        }
        if (y <= 8 && y >= 6) {
            for (int b = 6; b <= 8; b++) {
                addSudokuWithValueToList(board,  b,x,  y, list, number);
            }
        }
        List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());
        return distinctList;
    }

    private void addSudokuWithValueToList(Board board, int b,int x, int y, List<Integer> list,int number){
        SudokuElement s = board.getRowList().get(x).getSudokuElementList().get(y);
        sudokuElement = board.getRowList().get(x).getSudokuElementList().get(b);
        if (sudokuElement.getValue() == -1 && sudokuElement != s) {
            addToList(board,x,y,list,number);
        }
    }
    private void addToList(Board board,int x, int y, List<Integer> list,int number){
        boolean foundInOtherPossibleList = possibleChecker.checkPossibleInRow(board, x, y, number, sudokuElement);
        if (!foundInOtherPossibleList) {
            list.add(number);
        }
    }
}


