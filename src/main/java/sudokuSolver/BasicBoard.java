package sudokuSolver;

//Board for 4x4, 6x6, 9x9 or 9x9 diagonal Sudoku.

public class BasicBoard implements Board{

	//nxn Sudoku board. Blanks are filled with 0's.
	private Integer[][] board;

	// size can be either 4, 6, or 9
	private int size;

	/*
	4x4 => 2x2 grids.
	6x6 => 2x3 grids.
	9x9 => 3x3
	*/

	private int rowsPerGrid;
	private int colsPerGrid;

	//	Constructor with an initial two-dimensional array.
	public BasicBoard(Integer[][] initial) {

		size = initial.length;

		board = new Integer[size][size];
		for (int row=0; row<size; row++) {
			for (int col=0; col<size; col++) {
				board[row][col]= initial[row][col];
			}
		}

		// Establish grid dimensions
		if (size==4) {
			rowsPerGrid = 2;
			colsPerGrid = 2;
		} else if (size==6){
			rowsPerGrid = 2;
			colsPerGrid = 3;
		} else if (size==9) {
			rowsPerGrid = 3;
			colsPerGrid = 3;
		}
	}

	public BasicBoard(BasicBoard toCopy) {
		this(toCopy.getBoard());
	}

	@Override
	public String toString() {
		String result = "";
		for (int row=0; row<size; row++) {
			for (int col=0; col<size; col++) {
				result += "  " + board[row][col];
			}
			result += "\n";
		}
		return result;
	}

	public int rowFirstEmpty() {
		for (int row=0; row<size; row++) {
			for (int col=0; col<size; col++) {
				if (board[row][col] == 0) {
					return row;
				};
			}
		}
		return -1;
	}

	public int colFirstEmpty() {
		for (int row=0; row<size; row++) {
			for (int col=0; col<size; col++) {
				if (board[row][col] == 0) {
					return col;
				};
			}
		}
		return -1;
	}

	// Check basic violation rules
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

		return true;
	}

	public boolean isComplete() {
		for (int i=0; i<size; i++) {
			if (!isComplete(row(i))) {
				return false;
			}
			if (!isComplete(col(i))) {
				return false;
			}
		}

		for (int i=0; i<size; i++) {
			if (!isComplete(grid(i))) {
				return false;
			}
		}

		return true;
	}

	public int getSize() {
		return size;
	}

	protected boolean isValid(Integer[] values) {
		int[] histo = new int[values.length+1];
		for (Integer value : values) {
			histo[value] += 1;
		}

		for (int i=1;i<=values.length; i++) {
			if (histo[i]>1) {
				return false;
			}
		}

		return true;
	}

	private boolean isComplete(Integer[] values) {
		int count = values.length;
		for (Integer val : values) {
			if (val != 0) {
				count--;
			}
		}
		return count==0;
	}

	protected Integer[] grid(int grid) {
		Integer[] values = new Integer[size];
		int row = (int)(grid/rowsPerGrid)*rowsPerGrid;
		int col = (grid%(size/colsPerGrid))*colsPerGrid;
		int overflow = col+colsPerGrid;
		for (int i=0; i<size; i++) {
			values[i] = board[row][col];
			col++;
			if (col==overflow) {
				row++;
				col = (grid%(size/colsPerGrid))*colsPerGrid;
			}
		}
		return values;
	}


	protected Integer[] row(int r) {
		Integer[] row = new Integer[size];
		for (int i=0; i<size; i++) {
			row[i] = board[r][i];
		}
		return row;
	}

	protected Integer[] col(int c) {
		Integer[] col = new Integer[size];
		for (int i=0; i<size; i++) {
			col[i] = board[i][c];
		}
		return col;
	}

	public Integer[][] getBoard() {
		return board;
	}
}
