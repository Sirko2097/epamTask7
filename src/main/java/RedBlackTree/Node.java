package RedBlackTree;

public class Node<K, V> {
    K key;
    V value;

    Node<K, V> leftChild;
    Node<K, V> rightChild;
    Node<K, V> parent;
    boolean isLeftChild = false;
    Colours colour;


    Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.parent = null;
    }

    @Override
    public String toString() {
        return key + " = " + value;
    }

    public enum  Colours {
        RED,
        BLACK
    }



}
