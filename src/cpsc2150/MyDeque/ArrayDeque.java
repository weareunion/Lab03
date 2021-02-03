package cpsc2150.MyDeque;

/**
 * The type Array deque.
 */
public class ArrayDeque implements IDeque {
    // where the data is stored. myQ[0] is the front of the deque
    private Character[] myQ;
    // tracks how many items in the deque
    // also used to find the end of the deque
        private int myLength;

    /**
     * Instantiates a new Array deque.
     * @post [An array of size MAX_LENGTH is created in this.myQ] AND this.myLength = 0
     */
    public ArrayDeque() {
        this.myQ = new Character[MAX_LENGTH];
        this.myLength = 0;
    }

    @Override
    public void enqueue(Character x) {
        myQ[myLength++] = x;
    }

    @Override
    public Character dequeue() {
        Character hold = myQ[0];
        if (myLength-- >= 0) System.arraycopy(myQ, 1, myQ, 0, myLength);
        myQ[myLength] = null;
        return hold;
    }

    @Override
    public void inject(Character x) {
        if (myLength >= 0) System.arraycopy(myQ, 0, myQ, 1, myLength);
        myQ[0] = x;
        myLength++;
    }

    @Override
    public Character removeLast() {
        return myQ[--myLength];
    }

    @Override
    public int length() {
        return myLength;
    }

    @Override
    public void clear() {
        for (int i = 0; i < myLength; i++) {
            removeLast();
        }
    }
}
