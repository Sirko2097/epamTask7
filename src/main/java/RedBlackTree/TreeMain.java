package RedBlackTree;

public class TreeMain {
    public static void main(String[] args) {
        Tree<Integer, Integer> tree = new Tree<>();
        tree.putElem(1,1);
        tree.putElem(2,2);
        tree.putElem(3,3);
        tree.putElem(4,4);
        tree.putElem(5,5);

        tree.printTree();

    }
}
