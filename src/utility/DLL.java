package utility;

import java.util.NoSuchElementException;

public class DLL<E> implements List<E>{

    private DLLNode head;
    private DLLNode tail;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if(toAdd == null)
        {
            throw new NullPointerException();
        }
        else if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        else if(index == 0 && size == 0)
        {
            add(toAdd);
            return true;
        }
        else if(index == 0)
        {
            DLLNode node = new DLLNode(toAdd);
            node.next = head.next;
            node.prev = null;
            head = node;
            size++;
            return true;
        }
        else if(index == size)
        {
            add(toAdd);
            return true;
        }

        DLLNode node = new DLLNode(toAdd);
        DLLNode current = head;
        for(int i=0;i<index;i++)
        {
            current = current.next;
        }
        DLLNode prev = current.prev;
        prev.next = node;
        node.prev = prev;
        node.next = current;
        current.prev = node;
        size++;
        return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if(toAdd == null)
        {
            throw new NullPointerException();
        }
        if(head == null)
        {
            DLLNode node =  new DLLNode(toAdd);
            tail = node;
            node.prev = null;
            head = node;
            size++;
            return true;
        }
        else
        {
            DLLNode node = new DLLNode(toAdd);
            DLLNode temp = head;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
            tail = node;
            size++;
            return true;
        }
    }

    @Override
    public boolean addAll(List<? extends E> toAdd) throws NullPointerException {
        for(int i=0;i<toAdd.size();i++)
        {
            if(toAdd.get(i) == null)
            {
                throw new NullPointerException();
            }
        }
        if(tail == null && toAdd.size() != 0)
        {
            DLLNode node = new DLLNode(toAdd.get(0));
            head = node;
            tail = node;
            size++;
            for(int i=1;i<toAdd.size();i++)
            {
                DLLNode newNode = new DLLNode(toAdd.get(i));
                tail.next = newNode;
                newNode.next = null;
                newNode.prev = tail;
                tail = newNode;
                size++;
            }
            return true;
        }
        else
        {
            for(int i=0;i<toAdd.size();i++)
            {
                DLLNode newNode = new DLLNode(toAdd.get(i));
                tail.next = newNode;
                newNode.next = null;
                newNode.prev = tail;
                tail = newNode;
                size++;
            }
            return true;
        }
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        DLLNode current = head;
        for(int i=0;i<index;i++)
        {
            current = current.next;
        }
        return (E) current.value;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0)
        {
            E toReturn = (E) head.value;
            head.prev = null;
            head = head.next;
            size--;
            return toReturn;
        }
        else if(index == size-1)
        {
            E toReturn = (E) tail.value;
            tail = tail.prev;
            tail.next = null;
            size--;
            return toReturn;
        }
        else {
            E toReturn;
            DLLNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            toReturn = (E) current.value;
            DLLNode prev = current.prev;
            DLLNode next = current.next;
            prev.next = current.next;
            next.prev = prev;
            size--;
            return toReturn;
        }
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if(toRemove == null)
        {
            throw new NullPointerException();
        }
        DLLNode current = head;
        while(current != null && !current.value.equals(toRemove))
        {
            current = current.next;
        }
        if(current!=null)
        {
            if(current.prev != null)
            {
                current.prev.next = current.next;
            }
            else
            {
                head = current.next;
            }
            if(current.next != null)
            {
                current.next.prev = current.prev;
            }
            else
            {
                tail = current.prev;
            }
            size--;
            return (E) current.value;
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if(toChange == null)
        {
            throw new NullPointerException();
        }
        if(index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        DLLNode current = head;
        while(index>0)
        {
            current = current.next;
            index--;
        }
        E toReturn = (E) current.value;
        current.value = toChange;
        return toReturn;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if(toFind == null)
        {
            throw new NullPointerException();
        }
        DLLNode current = head;
        while ((current != null) && (!current.value.equals(toFind)))
        {
            current = current.next;
        }
        return current != null;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        return null;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        DLLNode current = head;
        int count = 0;
        while(!current.value.equals(tail.value))
        {
            array[count] = (E) current.value;
            count++;
            current = current.next;
        }
        return array;
    }

    @Override
    public Iterator<E> iterator() {
        return new DLLIterator();
    }

    private class DLLIterator implements Iterator<E>
    {
        //Attributes
        private DLLNode current = head;

        @Override
        public boolean hasNext()
        {
            return current != null;
        }

        @Override
        public E next() throws NoSuchElementException
        {
            try
            {
                if(!hasNext()) throw new NoSuchElementException();
                E toReturn = (E) current.value;
                current = current.next;
                if(toReturn == null)
                {
                    throw new NoSuchElementException();
                }
                return toReturn;
            }
            catch(IndexOutOfBoundsException e)
            {
                throw new NoSuchElementException();
            }
        }
    }
}