public class LinkedListDeque<T> {
    private int size;
    private Node sentinel;

    private class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
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

//    public LinkedListDeque(T item) {
//        Node s = new Node(null, item, null);
//        Node p = new Node(null, item, null);
//        s.next = p;
//        s.prev = p;
//        p.prev = s;
//        p.next = s;
//        sentinel = s;
//        size = 1;
//    }

    /** Add an item of type T to the front of the deque*/
    public void addFirst(T item) {
        Node p = new Node(null, item, null);

        if (size == 0) {
            p.prev = sentinel;
            p.next = sentinel;
            sentinel.prev = p;
            sentinel.next = p;
        } else {
            p.prev = sentinel;
            p.next = sentinel.next;
            sentinel.next.prev = p;
            sentinel.next = p;

        }
        size += 1;
    }

    /** Adds an item of type T to the back of the deque*/
    public void addLast(T item) {
        Node p = new Node(null, item, null);

        if (size == 0) {
            p.prev = sentinel;
            p.next = sentinel;
            sentinel.prev = p;
            sentinel.next = p;
        } else {
            p.prev = sentinel.prev;
            p.next = sentinel;
            sentinel.prev.next = p;
            sentinel.prev = p;
        }
        size += 1;
    }

    /** check if deque is empty*/
    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }


    /** Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        Node p = sentinel.next;

        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.print("\n");
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, return null. */
    public T removeFirst() {
        if (sentinel.next.item != null) {
            T res = sentinel.next.item;
            // Remove first item pointer
//            sentinel.next.prev = null;

            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;

            size -= 1;
            return res;
        }
        return null;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.*/
    public T removeLast() {
        if (size > 0) {

            Node last = sentinel.prev;
            T res = last.item;
            last.prev.next = sentinel;
            sentinel.prev = last.prev;
            size -= 1;
            return res;
        } else {
            return null;
        }

    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth.
     * If no such item exists, returns null. Must not alter the deque!*/
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int i = 0;
        Node p = sentinel.next;
        while (i != index) {
            i += 1;
            p = p.next;
        }
        return p.item;
    }

    /** Same as get, but uses recursion*/
    public T getRecursive(int index) {
        return getRecursiveHelper(index).item;
    }

    private Node getRecursiveHelper(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        if (index == 0) {
            return sentinel.next;
        } else {
            Node p = getRecursiveHelper(index - 1);
            p = p.next;
            return p;
        }
    }
}
