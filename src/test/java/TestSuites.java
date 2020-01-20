import org.junit.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestSuites {

    @Test
    public void testingInputs() {

        //Given
        SudokuElement sudokuElement = new SudokuElement();
        sudokuElement.setValue(-1);
        sudokuElement.setPossibleElementsList(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).collect(Collectors.toList()));
        Board board = new Board();

        //when
        board.getRowList().get(2).getSudokuElementList().get(1).setValue(8);
        board.getRowList().get(2).getSudokuElementList().get(3).setValue(2);
        board.getRowList().get(2).getSudokuElementList().get(4).setValue(1);
        board.getRowList().get(2).getSudokuElementList().get(5).setValue(5);
        board.getRowList().get(2).getSudokuElementList().get(6).setValue(3);
        board.getRowList().get(2).getSudokuElementList().get(5).setPossibleElementsList(Stream.of(1, 2, 6, 7, 8, 9).collect(Collectors.toList()));
        board.getRowList().get(2).getSudokuElementList().get(8).setValue(6);
        board.getRowList().get(8).getSudokuElementList().get(5).setValue(9);

        //then
        Assert.assertEquals(9, board.getRowList().size());
        Assert.assertEquals(9, board.getRowList().get(8).getSudokuElementList().get(5).getValue());
        Assert.assertEquals(-1, board.getRowList().get(2).getSudokuElementList().get(0).getValue());
        Assert.assertEquals(6, board.getRowList().get(2).getSudokuElementList().get(5).getPossibleElementsList().size());
    }

    @org.junit.Test
    public void testingPossibleCheckersClassMethod() {

        //given
        SudokuElement sudokuElement = new SudokuElement();
        sudokuElement.setValue(-1);
        Board board1 = new Board();

        SudokuElement s1 = board1.getRowList().get(2).getSudokuElementList().get(0);
        s1.setPossibleElementsList(Stream.of(1, 6, 7, 8, 9).collect(Collectors.toList()));
        SudokuElement s2 =board1.getRowList().get(2).getSudokuElementList().get(1);
        s2.setPossibleElementsList(Stream.of(1, 6, 7, 8, 9).collect(Collectors.toList()));
        SudokuElement s3 =board1.getRowList().get(2).getSudokuElementList().get(2);
        s3.setPossibleElementsList(Stream.of(1, 6, 7, 8, 9).collect(Collectors.toList()));

        SudokuElement s4 =board1.getRowList().get(2).getSudokuElementList().get(3);
        s4.setPossibleElementsList(Stream.of(1, 6, 7, 8, 9).collect(Collectors.toList()));
        SudokuElement s5 =board1.getRowList().get(2).getSudokuElementList().get(4);
        s5.setPossibleElementsList(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).collect(Collectors.toList()));
        SudokuElement s6 =board1.getRowList().get(2).getSudokuElementList().get(5);
        s6.setPossibleElementsList(Stream.of(1, 6, 7, 8, 9).collect(Collectors.toList()));

        SudokuElement s7 =board1.getRowList().get(2).getSudokuElementList().get(6);
        s7.setPossibleElementsList(Stream.of(1, 6, 7, 8, 9).collect(Collectors.toList()));
        SudokuElement s8 =board1.getRowList().get(2).getSudokuElementList().get(7);
        s8.setPossibleElementsList(Stream.of(1, 6, 7, 8, 9).collect(Collectors.toList()));
        SudokuElement s9 =board1.getRowList().get(2).getSudokuElementList().get(8);
        s9.setPossibleElementsList(Stream.of(1, 6, 7, 8, 9).collect(Collectors.toList()));

        //when
        PossibleChecker possibleChecker = new PossibleChecker();

        boolean result1 = possibleChecker.checkPossibleInRow(board1, 2, 4,4, s4);
        boolean result2 = possibleChecker.checkPossibleInRow(board1, 2, 4,5, s1);
        boolean result3 = possibleChecker.checkPossibleIn2SectionsInRow(board1, 2,4, 4);
        //checking if exist in selected sudoku element possible element list
        boolean result4 = possibleChecker.checkIfExistInOtherPossibleList(board1,2,6,5);
        boolean result5 = possibleChecker.checkIfExistInOtherPossibleList(board1,2,4,4);

        //then
        Assert.assertFalse(result1);
        Assert.assertFalse(result2);
        Assert.assertFalse(result3);
        Assert.assertFalse(result4);
        Assert.assertTrue(result5);
    }
}