package RedBlackTree;



import java.util.LinkedList;
import java.util.Queue;

import static RedBlackTree.Node.Colours.BLACK;
import static RedBlackTree.Node.Colours.RED;


public class Tree<K extends Comparable<K>, V> {
    private Node<K, V> root;
    private int size;


    public void putElem(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        if (root == null) {
            root = newNode;
            root.colour = BLACK;
            size++;
            return;
        }
        put(root, newNode);
    }

    private void put(Node<K, V> parent, Node<K, V> child) {
        if (child.key.compareTo(parent.key) > 0) {
            if (parent.rightChild == null) {
                parent.rightChild = child;
                child.parent = parent;
                child.isLeftChild = false;
                size++;
                return;
            }
            put(parent.rightChild, child);
        } else if (child.key.compareTo(parent.key) < 0) {
                if (parent.leftChild == null) {
                    parent.leftChild = child;
                    child.parent = parent;
                    child.isLeftChild = true;
                    size++;
                    return;
                }
                put(parent.leftChild, child);
        }
        checkColour(child);
    }

    private void  checkColour(Node<K, V> node) {
        if (node == root)
            return;

        if (node.colour == RED && node.parent.colour == RED) {
            changeTree(node);
            return;
        }
        checkColour(node.parent);
    }

    private void changeTree(Node<K, V> node) {
        if (node.parent.isLeftChild) {
            if (node.parent.parent.rightChild == null || node.parent.parent.rightChild.colour == BLACK) {
                rotate(node);
                return;
            }
            node.parent.parent.rightChild.colour = BLACK;
            node.parent.parent.colour = RED;
            node.parent.colour = BLACK;
            root.colour = BLACK;
        } else {
            if (node.parent.parent.leftChild == null || node.parent.parent.leftChild.colour == BLACK) {
                rotate(node);
                return;
            }
            node.parent.parent.leftChild.colour = BLACK;
            node.parent.parent.colour = RED;
            node.parent.colour = BLACK;
            root.colour = BLACK;
        }
    }

    private void rotate(Node<K, V> node) {
        if (node.isLeftChild) {
            if (node.parent.isLeftChild) {
                rRotation(node.parent.parent);
                node.colour = RED;
                node.parent.colour = BLACK;
                if (node.parent.rightChild != null) {
                    node.parent.rightChild.colour = RED;
                }
            } else {
                rLeftRotation(node.parent.parent);
                node.colour = BLACK;
                node.rightChild.colour = RED;
                node.leftChild.colour = RED;
            }
        } else {
            if (!node.parent.isLeftChild) {
                lRotation(node.parent.parent);
                node.colour = RED;
                node.parent.colour = BLACK;
                if (node.parent.leftChild != null) {
                    node.parent.leftChild.colour = RED;
                }
            } else {
                lRightRotation(node.parent.parent);
                node.colour = BLACK;
                node.leftChild.colour = RED;
                node.rightChild.colour = RED;
            }
        }
    }

    private void lRotation(Node<K, V> node) {
        Node<K, V> elem = node.rightChild;
        node.rightChild = elem.leftChild;

        if (node.rightChild != null) {
            node.rightChild.parent = node;
            node.rightChild.isLeftChild = false;
        }

        if (node.parent == null) {
            root = elem;
            elem.parent = null;
        } else {
            elem.parent = node.parent;
            if (node.isLeftChild) {
                elem.isLeftChild = true;
                elem.parent.leftChild = elem;
            } else {
                elem.isLeftChild = false;
                elem.parent.rightChild = elem;
            }
        }

        elem.leftChild = node;
        node.isLeftChild = true;
        node.parent = elem;
    }

    private void rRotation(Node<K, V> node) {
        Node<K, V> elem = node.leftChild;
        node.leftChild = elem.rightChild;

        if (node.leftChild != null) {
            node.leftChild.parent = node;
            node.leftChild.isLeftChild = true;
        }

        if (node.parent == null) {
            root = elem;
            elem.parent = null;
        } else {
            elem.parent = node.parent;
            if (node.isLeftChild) {
                elem.isLeftChild = true;
                elem.parent.leftChild = elem;
            } else {
                elem.isLeftChild = false;
                elem.parent.rightChild = elem;
            }
        }

        elem.rightChild = node;
        node.isLeftChild = false;
        node.parent = elem;
    }

    private void rLeftRotation(Node<K, V> node) {
        rRotation(node.rightChild);
        lRotation(node);
    }

    private void lRightRotation(Node<K, V> node) {
        lRotation(node.leftChild);
        rRotation(node);
    }

    public boolean remove(K key) {
        throw new UnsupportedOperationException();
    }

    public void printQueue() {
        Queue<Node<K, V>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<K, V> node = queue.remove();
            System.out.println(node);
            if (node.leftChild != null) {
                queue.add(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.add(node.rightChild);
            }
        }
    }

    public void printTree() {
        Node<K, V> node = root;
        printTree(node, 0);
    }

    private void printTree(Node<K, V> node, int lvl) {
        if (node != null) {
            for (int i = 0; i < lvl; i++) {
                System.out.println(" ");
            }
            System.out.println(node.key + " (" + node.colour + ")");
            lvl++;
            printTree(node.leftChild, lvl);
            printTree(node.rightChild, lvl);
        }
    }

    public V get(K key) {
        Node<K, V> node = root;
        if (root.key.equals(key)) {
            System.out.println("Root: " + node.colour);
            return node.value;
        } else {
            while (true) {
                if (key.compareTo(node.key) > 0) {
                    node = node.rightChild;
                    if (node == null) {
                        break;
                    }
                }

                if (key.compareTo(node.key) < 0) {
                    node = node.leftChild;
                    if (node == null) {
                        break;
                    }
                }

                if (node.key.equals(key)) {
                    if (node.isLeftChild){
                        System.out.println("Left: " + node.colour);
                    } else {
                        System.out.println("Right: " + node.colour);
                    }
                    return node.value;
                }
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }
}
