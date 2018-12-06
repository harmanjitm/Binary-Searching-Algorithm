package utility;

public class DLLNode<E> {
    DLLNode next;
    DLLNode prev;
    E value;

    public DLLNode(E value)
    {
        this.value = value;
    }
}