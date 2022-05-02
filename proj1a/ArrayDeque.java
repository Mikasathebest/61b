// Create a circular ArrayDeque
public class ArrayDeque <T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    private int refactor = 2;

    /** Create an empty Array Deque.
     *  This Array is not traditional array.
     *  It uses two pointers nextFirst, nextLast to store the start point and the end point.
     * */
    public  ArrayDeque(){
        items = (T[]) new Object[8];
        // random initialize
        nextFirst = 5;
        nextLast = nextFirst + 1;
        size = 0;
    }

    /** Private helper.
     * Resize the array when encounter below cases:
     * 1. Array is full:
     *  Create a new array: {null, 1, 2, 3, null, null}
     *  nextFirst points to 0; nextLast points to 4 --- size + 1.
     * 2. nextFirst or nextLast point needs to update.
     *      a. nextFirst points to the tail of the array. Expand the array and refresh it.
     *      b. nextLast points to the
     * */
    private void resize(int resizer) {
        T[] p = (T[]) new Object[resizer];
        int start = addOne(nextFirst);
        int end = minusOne(nextLast);

        // Expand the array
        if (nextFirst == end) {
            System.arraycopy(items, start, p, 1, items.length - start);
            System.arraycopy(items, 0, p, items.length - start + 1, start);
            nextFirst = 0;
            nextLast = size + 1;
            items = p;
        }
        else{
            // Reduce the array to save memory. When usage ratio < 0.25.
            if (nextFirst < nextLast) {
                System.arraycopy(items, start, p, 1, size);
            }
            else { // nextFirst > nextLast
                System.arraycopy(items, start, p, 1, items.length - start);
                System.arraycopy(items, 0, p, items.length - start + 1, size - items.length + start);

            }
            items = p;
            nextFirst = 0;
            nextLast = size + 1;
        }
    }

    /** Private helper function to move pointer.*/
    private int addOne(int index){
        if (index == items.length -1){
            index = 0;
        }
        else{
            index += 1;
        }
        return index;
    }

    /** Private helper function to minus pointer. */
    private int minusOne(int index){
        if (index == 0){
            index = items.length - 1;
        }
        else{
            index -= 1;
        }
        return index;
    }

    /** Adds an item of type int to the front of the deque.*/
    public void addFirst(T item) {
        if (size == items.length){
            resize(size * refactor);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    /** Adds an item of type int to the back of the deque.*/
    public void addLast(T item){
        if(size == items.length){
            resize(size * refactor);
        }
        items[nextLast] = item;
        nextLast = addOne(nextLast);
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
        if (size == 0){
            System.out.println("Empty array!");
        }
        else{
            int i = addOne(nextFirst);
            for(int j = 0; j < size; j++){
                System.out.print(items[i] + " ");
                i = addOne(i);
            }
        }
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public T removeFirst(){
        if (size >= 1){
            T res = items[addOne(nextFirst)];
            items[addOne(nextFirst)] = null;
            nextFirst = addOne(nextFirst);
            size -= 1;

            // Resize the array to save memory.
            if (items.length > 16 && size == items.length / 4){
                resize(items.length / refactor);
            }
            return res;
        }
        else{
            return null;
        }
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.*/
    public T removeLast(){
        if (size >= 1){
            T res = items[minusOne(nextLast)];
            items[minusOne(nextLast)] = null;
            nextLast = minusOne(nextLast);
            size -= 1;

            if (items.length > 16 && size == items.length / 4){
                resize(items.length / refactor);
            }
            return res;
        }
        else{
            return  null;
        }
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index){
        if (index > size -1 || index < 0){
            return null;
        }
        else{
            index = (index + addOne(nextFirst)) % items.length;
            return items[index];
        }
    }

//    public static void main(String[] args){
//        ArrayDeque1<Integer> ll1 = new ArrayDeque1<>();
//        ll1.addFirst(4);
//        //ll1.printDeque();
//        ll1.addFirst(3);
//        ll1.addFirst(2);
//        ll1.addFirst(1);
//        ll1.addLast(5);
//        //ll1.printDeque();
//        ll1.addFirst(0);
//        ll1.addLast(6);
//        ll1.addLast(7);
//        ll1.addLast(8);
//        ll1.addLast(9);
//        ll1.addLast(10);
//        ll1.printDeque();
//
//        System.out.println(ll1.get(5));
//
//    }
}
