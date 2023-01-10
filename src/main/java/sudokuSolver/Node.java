package sudokuSolver;

import java.util.ArrayList;

public class Node<T> {

	private T value;

	private ArrayList<Node<T>> children = new ArrayList<>();

	public Node(T v) {
		value = v;
	}

	public void addChild(Node<T> n) {
		children.add(n);
	}

	public ArrayList<Node<T>> children() {
		return children;
	}

	public T value() {
		return value;
	}
	public void value(T v) {
		value = v;
	}

	@Override
	public String toString() {
		return "Node{" +
				"value=" + value +
				", children=" + children +
				'}';
	}
}
