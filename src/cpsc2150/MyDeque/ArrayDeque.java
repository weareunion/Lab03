package cpsc2150.MyDeque;

/**
 * The type Array deque.
 */

/**
 *
 * @Invariant DATATYPE.length >= 0 AND DATATYPE.length <= MAX_LENGTH
 * @Correspondance DATATYPE.length = myLength;
 *                 DATATYPE = myQ[0..myLength-1];
 */
public class ArrayDeque<T> extends AbsDeque<T> {
    // where the data is stored. myQ[0] is the front of the deque
    private T[] myQ;
    // tracks how many items in the deque
    // also used to find the end of the deque
    private int myLength;

    /**
     * Instantiates a new Array deque.
     * @post [An array of size MAX_LENGTH is created in this.myQ] AND this.myLength = 0
     */
    public ArrayDeque() {
        this.myQ = (T[]) new Object[MAX_LENGTH];
        this.myLength = 0;
    }

    @Override
    public void enqueue(T x) {
        myQ[myLength++] = x;
    }

    @Override
    public T dequeue() {
        T hold = myQ[0];
        if (myLength-- >= 0) System.arraycopy(myQ, 1, myQ, 0, myLength);
        myQ[myLength] = null;
        return hold;
    }

    @Override
    public void inject(T x) {
        if (myLength >= 0) System.arraycopy(myQ, 0, myQ, 1, myLength);
        myQ[0] = x;
        myLength++;
    }

    @Override
    public T removeLast() {
        return myQ[--myLength];
    }

    @Override
    public int length() {
        return myLength;
    }

    @Override
    public void clear() {
        int x = myLength;
        for (int i = 0; i < x; i++) {
            removeLast();
        }
    }
}