import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        Game game = new Game();
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        List<Integer> valuesList = new ArrayList<>();

        System.out.println("Type x,y,x or sudoku if you want to see result ");
            do {
                System.out.println("Type x");
                board.xInput = sc.nextInt() - 1;
                board.setX(board.xInput);
                xList.add( board.xInput);

                System.out.println("Type y");
                board.yInput = sc.nextInt() - 1;
                board.setY(board.yInput);
                yList.add( board.yInput);

                System.out.println("Type value");
                board.valueInput = sc.nextInt();
                board.setValue(board.valueInput);
                valuesList.add( board.valueInput);
                System.out.println(board);
                System.out.println("Type x,y,x or sudoku if you want to solve the game ");
            } while (sc.hasNextInt() && !sc.nextLine().equals("sudoku"));
                game.resolveSudoku(board);
                int counter1 = 1000;
                do {
                counter1--;
                    if(game.resolveSudoku(board)){
                    System.out.println(counter1);
                        for (int x = 0; x <= 8; x++) {
                        for (int y = 0; y <= 8; y++) {
                        SudokuElement sudokuElement = board.getRowList().get(x).getSudokuElementList().get(y);
                        sudokuElement.setValue(-1);
                        sudokuElement.setPossibleElementsList(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).collect(Collectors.toList()));
                    }
                }
                    for (int i = 0; i < xList.size(); i++) {
                        board.xInput = xList.get(i);
                        board.setX(board.xInput);
                        board.yInput = yList.get(i);
                        board.setY(board.yInput);
                        board.valueInput = valuesList.get(i);
                        board.setValue(board.valueInput);
                        System.out.println("Creating new board. Setting value on board " + "\n" + board);
                    }
                game.resolveSudoku(board);
                }
            }
            while (counter.countEmpty(board).size()>0 && counter1>0);
            if(counter.countEmpty(board).size()==0) {
                System.out.println("Sudoku solved in " + (1000 - counter1) + " attempt");
            }else System.out.println("Sudoku is not solved");
        }
}

