import javax.naming.NameNotFoundException;

public class LinkedListDeque<T> {
    private int size;
    private Node sentinel;


    public class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(Node prev, T item, Node next){
            prev = prev;
            item = item;
            next = next;
        }
    }
    /** Creates an empty LinkedListDeque. */
    public LinkedListDeque() {
        Node p = new Node(null, null, null);
        p.prev = p;
        p.next = p;
        sentinel = p;
        size = 0;
    }

    public LinkedListDeque(T item) {

        Node p = new Node(null, item, null);
        p.prev = sentinel;
        p.next = sentinel;
        sentinel.next = p;
        sentinel.prev = p;
        size = 1;
    }

    /** Add an item of type T to the front of the deque*/
    public void addFirst(T item){
        Node p = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
        size += 1;
    }

    /** Adds an item of type T to the back of the deque*/
    public void addLast(T item){
        Node p = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
        size += 1;
    }

    /** check if deque is empty*/
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){
        return size;
    }


    /** Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque(){
        Node p = sentinel.next;
        while(p != sentinel){
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, return null. */
    public T removeFirst(){
        if (sentinel.next.item != null){
            T res = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.next.prev = sentinel;
            return res;
        }
        return null;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.*/
    public T removeLast(){
        if (sentinel.prev.item != null){
            T res = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            return res;
        }
        return null;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth.
     * If no such item exists, returns null. Must not alter the deque!*/
    public T get(int index){
        if (index >= size){
            return null;
        }
        int i = 0;
        Node p = sentinel.next;
        while(i != index){
            i += 1;
            p = p.next;
        }
        return p.item;
    }

    /** Same as get, but uses recursion*/
    public T getRecursive(int index){
        if (index > size){
            return null;
        }
        if (index == 0){
            return sentinel.next.item;
        }

        return getRecursive(index - 1);
    }


}