package cpsc2150.MyDeque;

import java.util.*;
/**
 * @Invariants DATATYPE.length >= 0 AND DATATYPE.length <= MAX_LENGTH
 * @Correspondance DATATYPE.length = myQ.size();
 *                 DATATYPE = myQ[0..myLength-1];
 */

public class ListDeque<T> extends AbsDeque<T> {
    // this time store the deque in a list
// myQ.get(0) is the front of the deque
    private List<T> myQ;

    public ListDeque() {
        myQ = new ArrayList<>();
    }


    @Override
    public void enqueue(T x) {
        myQ.add((T)x);
    }

    @Override
    public T dequeue() {
        T hold = myQ.get(0);
        for (int i = 0; i < myQ.size()-1; i++) {
            myQ.set(i,myQ.get(i+1));
        }
        myQ.remove(myQ.size()-1);
        return hold;
    }

    @Override
    public void inject(T x) {
        myQ.add(x);
        for (int i = myQ.size()-1; i > 0; i--) {
            myQ.set(i,myQ.get(i-1));
        }

        myQ.set(0, x);
    }

    @Override
    public T removeLast() {
        return myQ.remove(myQ.size()-1);
    }

    @Override
    public int length() {
        return myQ.size();
    }

    @Override
    public void clear() {
        myQ.clear();
    }

// complete the class
}