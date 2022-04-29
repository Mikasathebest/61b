public class ArrayDeque <Item>{
    private Item[] items;
    private int size;

    /** Create an empty Array Deque*/
    public void ArrayDeque(){
        items = (Item[]) new Object[100];
        size = 0;
    }

    /** Adds an item of type Item to the front of the deque.*/
    public void addFirst(Item item){
        Item[] p = (Item[]) new Object[size+1];
        p[0] = item;
        System.arraycopy(item, 0, p, 1, size);
        items = p;
        size += 1;
    }

    private void resize(int a){
        Item[] p = (Item[]) new Object[a];
        System.arraycopy(items, 0, p, 0, size);
        items = p;
    }

    /** Adds an item of type Item to the back of the deque.*/
    public void addLast(Item item){
        int Refactor = 2;
        if(size == items.length){
            resize(size * Refactor);
        }
        items[size] = item;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    /** Returns the number of items in the deque.*/
    public int size(){
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque(){
        int i;
        for (i=0;i<size; i++){
            System.out.print(items[i] + " ");
        }
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public Item removeFirst(){
        if (size >= 1){
            Item res = items[0];
            Item[] p = (Item[]) new Object[size-1];
            System.arraycopy(items, 1, p, 0,size-1);
            items = p;
            size -= 1;
            return res;
        }
        else{
            return null;
        }
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.*/
    public Item removeLast(){
        if (size >= 1){
            Item res = items[size - 1];
            Item[] p = (Item[]) new Object[size-1];
            System.arraycopy(items, 0, p, 0,size-1);
            items = p;
            size -= 1;
            return res;
        }
        else{
            return  null;
        }
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null. Must not alter the deque!
     */
    public Item get(int index){
        if (index <= size-1){
            return items[index];
        }
        else{
            return null;
        }
    }
}
