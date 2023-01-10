package sudokuSolver;

public class Main {

    // Collection of puzzles for testing
    static Integer[][] easy4x4 = {
		{0,3,4,0},
		{4,0,0,2},
		{1,0,0,3},
		{0,2,1,0}
	};
	static Integer[][] easy6x6 = {
		{0,0,3,0,1,0},
		{5,6,0,3,2,0},
		{0,5,4,2,0,3},
		{2,0,6,4,5,0},
		{0,1,2,0,4,5},
		{0,4,0,1,0,0}
	};
	static Integer[][] medium6x6 = {
		{2,6,0,5,0,1},
		{0,0,1,0,0,2},
		{4,0,0,0,6,0},
		{0,3,0,0,0,4},
		{1,0,0,4,0,0},
		{3,0,4,0,2,6}
	};
	static Integer[][] easy9x9 = {
		{0,1,0,6,0,0,0,9,0},
		{0,0,0,2,0,0,3,8,0},
		{0,3,8,0,4,0,0,0,0},
		{0,0,0,0,0,3,0,2,6},
		{9,6,1,0,0,5,0,7,0},
		{0,8,0,0,0,4,0,0,5},
		{0,0,0,9,0,1,6,0,0},
		{0,0,5,0,0,0,2,3,0},
		{7,4,0,0,8,0,0,0,0}
	};

	static Integer[][] test01 = {
			{2,0,0,5,0,0,8,0,0},
			{4,6,5,7,9,0,0,0,0},
			{0,9,0,3,6,0,7,0,0},
			{5,0,0,0,2,1,0,0,0},
			{3,0,8,6,0,0,4,0,0},
			{0,1,9,4,0,0,0,8,6},
			{6,0,0,9,0,3,5,0,0},
			{1,8,3,2,0,0,6,0,0},
			{0,0,0,0,0,6,3,7,8}
	};
	static Integer[][] diagonalTest01 = {
			{0,0,0,0,1,4,9,0,0},
			{0,0,0,0,3,0,0,0,0},
			{0,0,0,8,0,5,3,0,4},
			{1,4,0,6,0,0,0,0,9},
			{0,0,0,3,0,8,0,0,0},
			{7,0,0,0,0,1,0,3,2},
			{8,0,1,7,0,9,0,0,0},
			{0,0,0,0,5,0,0,0,0},
			{0,0,7,4,8,0,0,0,0}
	};

	public static void main(String[] args) {

		// Use one of the boards defined above (or create your own)
//		Board puzzle = new BasicBoard(test01);
		DiagonalBoard puzzle = new DiagonalBoard(diagonalTest01);
		System.out.println("Initial:\n"+puzzle);

		// Build a search tree to brute force the solution
		SudokuTree tree = new SudokuTree(puzzle);
		Node<Board> root = tree.root();

		// Use BFS or DFS to find solution in tree
		System.out.println(new Service().findSolution(root));
		
	} // end main
} // end class Main
