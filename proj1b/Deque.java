public interface Deque<Item>{
    /** Add an item of type Item to the front of the deque*/
    public void addFirst(Item item);

    /** Adds an item of type Item to the back of the deque*/
    public void addLast(Item item);

    /** check if deque is empty*/
    public boolean isEmpty();
    
    public int size();

    /** Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque();

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, return null. */
    public Item removeFirst();

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.*/
    public Item removeLast();

    /** Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth.
     * If no such item exists, returns null. Must not alter the deque!*/
    public Item get(int index);
}
