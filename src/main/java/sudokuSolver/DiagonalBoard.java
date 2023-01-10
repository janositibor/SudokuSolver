package sudokuSolver;

public class DiagonalBoard extends BasicBoard{
    public DiagonalBoard(Integer[][] initial) {
        super(initial);
    }

        public DiagonalBoard(DiagonalBoard toCopy) {
        this(toCopy.getBoard());
    }
    @Override
    public boolean isValid() {
        for (int i = 0; i< getSize(); i++) {
            if (!isValid(row(i))) {
                return false;
            }
            if (!isValid(col(i))) {
                return false;
            }
        }

        for (int i = 0; i< getSize(); i++) {
            if (!isValid(grid(i))) {
                return false;
            }
        }

        for (int i=0; i<2; i++) {
            if (!isValid(diagonal(i))) {
                return false;
            }
        }

        return true;
    }

    private Integer[] diagonal(int index) {
        Integer[] diagonal = new Integer[getSize()];
        for (int i = 0; i< getSize(); i++) {
            if(index==1){
                diagonal[i] = getBoard()[i][i];
            }
            else{
                diagonal[i] = getBoard()[i][getSize()-1-i];
            }

        }
        return diagonal;
    }
}
