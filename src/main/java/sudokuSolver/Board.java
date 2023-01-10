package sudokuSolver;

public interface Board {
    int rowFirstEmpty();
    int colFirstEmpty();
    boolean isValid();
    boolean isComplete();
    int getSize();
    Integer[][] getBoard();
}
