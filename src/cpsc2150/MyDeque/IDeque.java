package cpsc2150.MyDeque;

/**
 * A deque containing characters.
 * A deque is a data structure a double-ended queue that allows you
 * to insert and remove from both ends.
 * This deque is bounded by MAX_LENGTH
 *
 * @define DATATYPE A datatype such as an array or a list
 * @invariant DATATYPE.length >= 0 AND DATATYPE.length <= MAX_LENGTH
 */
public interface IDeque {
    /**
     * The constant MAX_LENGTH.
     */
    public static final int MAX_LENGTH = 100;

    /**
     * Enqueue.
     *
     * @param x the character to be inserted
     * @pre [A containing DATATYPE, such as an array, must exist and be initialized] AND [DATATYPE.length < MAX_LENGTH-1]
     * @post [Adds x to the end of the deque]
     */
    public void enqueue(Character x);

    /**
     * Dequeue character and adjust DATATYPE to move element 1 to element 0;
     * @pre [A containing DATATYPE, such as an array, that exists, contains at least one element, and is initialized.]
     * @post [removes and returns the Character at the front of the deque]
     * @return the character at DATATYPE[0]
     */
    public Character dequeue();

    /**
     * Inject character to the front.
     *
     * @param x the character to be inserted
     * @pre [A containing DATATYPE, such as an array, must exist and be initialized] AND [DATATYPE.length < MAX_LENGTH-1]
     * @post [x is added to front of the DATATYPE]
     */
    public void inject(Character x);

    /**
     * Dequeue character from back and adjust DATATYPE.
     * @pre [A containing DATATYPE, such as an array, that exists, contains at least one element, and is initialized.]
     * @post [removes and returns the Character at the back of the deque]
     * @return the character at DATATYPE[DATATYPE.length-1]
     */
    public Character removeLast();

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
}
