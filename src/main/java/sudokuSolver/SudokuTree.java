package sudokuSolver;

import java.util.LinkedList;

public class SudokuTree {

	Node<Board> root = null;

	int nodeCount = 0;

	public SudokuTree(Board puzzle) {

		LinkedList<Node<Board>> queue = new LinkedList<>();
		root = new Node<Board>(puzzle);
		queue.add(root);
		while (queue.peekFirst() != null) {
			Node<Board> n = queue.remove();
			++nodeCount;

			int row = n.value().rowFirstEmpty();
			int col = n.value().colFirstEmpty();
			if (row == -1) {
				continue;
			}
			
			for (int i=1; i<=puzzle.getSize(); i++) {
				Node<Board> copy;
				if(n.value().getClass().getName().contains("Diagonal")){
					copy = new Node<>(new DiagonalBoard((DiagonalBoard) n.value()));
				}
				else {
					copy = new Node<>(new BasicBoard((BasicBoard) n.value()));
				}
				copy.value().getBoard()[row][col] = i;
				if (copy.value().isValid()) {
					n.addChild(copy);
					queue.add(copy);
				}
			}
		}
		System.out.println("Number of nodes in the tree: "+nodeCount+"\n");
	}

	public Node<Board> root() {
		return root;
	}

	public int nodeCount() {
		return nodeCount;
	}
}
