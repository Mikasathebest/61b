interface Deque<Item> {
    /** Add an item of type Item to the front of the deque*/
    void addFirst(Item item);

    /** Adds an item of type Item to the back of the deque*/
    void addLast(Item item);

    /** check if deque is empty*/
    boolean isEmpty();
    
    int size();

    /** Prints the items in the deque from first to last, separated by a space.*/
    void printDeque();

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, return null. */
    Item removeFirst();

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.*/
    Item removeLast();

    /** Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth.
     * If no such item exists, returns null. Must not alter the deque!*/
    Item get(int index);
}
