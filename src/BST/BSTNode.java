package BST;

public class BSTNode<E> {
    E data;
    BSTNode<E> left;
    BSTNode<E> right;

    public BSTNode(E data)
    {
        this.data = data;
        left = null;
        right = null;
    }

    public BSTNode(E data, BSTNode<E> left, BSTNode<E> right)
    {
        this.left = left;
        this.right = right;
        this.data = data;
    }
}
