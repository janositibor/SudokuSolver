package sudokuSolver;

public class Service {
    public static int counter=1;
    public Board findSolution(Node<Board> nodeToCheck){
        counter++;
        if(nodeToCheck.children().size()>0) {
            for (Node<Board> childrenNode : nodeToCheck.children()) {
                Board temp=findSolution(childrenNode);
                if ( temp!= null){
                    return temp;
                }
            }
        }
        else {
            if (nodeToCheck.value().isComplete()) {
                System.out.println("Found a solution!");
                return nodeToCheck.value();
            }
        }
        return null;
    }
}
