package cpsc2150.MyDeque;

import java.util.*;
public class ListDeque implements IDeque {
    // this time store the deque in a list
// myQ.get(0) is the front of the deque
    private List<Character> myQ;

    public ListDeque() {
        myQ = new ArrayList<>();
    }


    @Override
    public void enqueue(Character x) {
        myQ.add(x);
    }

    @Override
    public Character dequeue() {
        Character hold = myQ.get(0);
        for (int i = 0; i < myQ.size()-1; i++) {
            myQ.set(i,myQ.get(i+1));
        }
        myQ.remove(myQ.size()-1);
        return hold;
    }

    @Override
    public void inject(Character x) {
        myQ.add(x);
        for (int i = myQ.size()-1; i > 0; i--) {
            myQ.set(i,myQ.get(i-1));
        }

        myQ.set(0, x);
    }

    @Override
    public Character removeLast() {
        return myQ.remove(myQ.size()-1);
    }

    @Override
    public int length() {
        return myQ.size();
    }

    @Override
    public void clear() {
        for (int i = 0; i < myQ.size(); i++) {
            removeLast();
        }
    }

// complete the class
}
