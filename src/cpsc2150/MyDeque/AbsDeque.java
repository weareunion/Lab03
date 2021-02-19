package cpsc2150.MyDeque;

public class AbsDeque<T> implements IDeque<T>{
    @Override
    public void enqueue(T x) {

    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public void inject(T x) {

    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public void clear() {

    }

    /**
     * string representation of values in deque
     *
     * @pre [NONE]
     * @post return string containing entire deque
     * @return stop
     */
    @Override
    public String toString(){
        String print = "<";

        for(int i=0; i<length(); i++){
            T temp=get(i);
            print += temp + ", ";
        }
        String stop = null;
        if(print.length()>2){stop = print.substring(0,print.length()-2);stop += ">";}
        else{stop = "<>";}

        return stop;
    }
}
