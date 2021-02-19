package cpsc2150.MyDeque;

/**
 * A deque containing characters.
 * A deque is a data structure a double-ended queue that allows you
 * to insert and remove from both ends.
 * This deque is bounded by MAX_LENGTH
 *
 * @define DATATYPE A datatype such as an array or a list
 * @constraints DATATYPE.length >= 0 AND DATATYPE.length <= MAX_LENGTH
 */
public interface IDeque<T> {
    /**
     * The constant MAX_LENGTH.
     */
    public static final int MAX_LENGTH = 100;

    /**
     * Enqueue.
     *
     * @param x the character to be inserted
     * @pre [A containing DATATYPE, such as an array, must exist and be initialized] AND [DATATYPE.length <= MAX_LENGTH-1]
     * @post [Adds x to the end of the deque]
     */
    public void enqueue(T x);

    /**
     * Dequeue character and adjust DATATYPE to move element 1 to element 0;
     *
     * @return the character at DATATYPE[0]
     * @pre [A containing DATATYPE, such as an array, that exists, contains at least one element, and is initialized.]
     * @post [removes and returns the Character at the front of the deque] AND [Deque remains unchanged]
     */
    public T dequeue();

    /**
     * Inject character to the front.
     *
     * @param x the character to be inserted
     * @pre [A containing DATATYPE, such as an array, must exist and be initialized] AND [DATATYPE.length <= MAX_LENGTH-1]
     * @post [x is added to front of the DATATYPE]
     */
    public void inject(T x);

    /**
     * Dequeue character from back and adjust DATATYPE.
     *
     * @return the character at DATATYPE[DATATYPE.length-1]
     * @pre [A containing DATATYPE, such as an array, that exists, contains at least one element, and is initialized.]
     * @post [removes and returns the Character at the back of the deque]
     */
    public T removeLast();

    /**
     * Get the length of the dequeue
     *
     * @return DATATYPE.length
     */
    public int length();

    /**
     * Removes every element from the list
     *
     * @post DATATYPE.length = 0
     */
    public void clear();

    /**
     * returns the character at the front of the deque but does not remove it from the deque
     *
     * @return Character at front of the Deque
     * @pre [NONE]
     * @post return char at front of deque
     * @return get(0)
     */
    default T peek() {
        return get(0);
    }

    /**
     * returns the character at the end of the deque but does not remove it from the deque
     *
     * @pre [NONE]
     * @post returns char at back of deque
     * @return character at back of deque
     */
    default T endOfDeque() {
        return get(length()-1);
    }

    /**
     * inserts c at position pos in the deque Pos index starts at 1, so the item at the very front of the deque is pos 1.
     *
     * @pre 0<pos AND length()+1>pos
     * @post char c will be inserted at position pos
     * @param c: char to be inserted
     * @param pos: position at which char will be entered
     */
    default void insert(T c, int pos){
        for (int i = 0; i<length(); i++) {
            if(pos!=i+1){
                enqueue(dequeue());
            }else{
                enqueue(c);
            }
        }
        return;
    }

    /**
     * removes whatever character was in position pos in the deque and returns it
     *
     * @pre 0<pos AND length()+1>pos
     * @post char at position is removed
     * @param pos: position where char should be removed from
     * @return char at position
     */
    default T remove(int pos){
        T retval = null;
        for (int i = 0; i < length(); i++) {
            if(pos!=i){
                enqueue((T) dequeue());
            }else retval = (T) dequeue();
        }
        if(pos!=length()) {
            enqueue((T) dequeue());
        }
        return retval;
    }



    /**
     * returns whatever character was in position pos in the deque and without removing it.
     *
     * @pre 0<pos AND length()+1>pos
     * @post returns char at pos
     * @param pos: position where char should be gotten from
     * @return char at pos
     */
    default T get(int pos){
        T X;
        T returnChar=null;
        T temp = null;
        for(int i =0; i<length(); i++){

            temp=(T) dequeue();
            X=temp;
            if(pos==i){
                returnChar=temp;
            }
            enqueue(X);
        }

        return returnChar;
    }
}