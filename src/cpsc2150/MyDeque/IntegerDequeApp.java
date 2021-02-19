package cpsc2150.MyDeque;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegerDequeApp {
    public static void main(String[] args) {
        IDeque q = null;

        System.out.println("Do you want to use an array (A) or list (L)?\n");


        boolean invalid_in = true;

        while (invalid_in) {
            Scanner s = new Scanner(System.in);
            int in = s.nextInt();
            switch (in) {
                case 'A':
                case 'a':
                    q = new ArrayDeque();
                    invalid_in = false;
                    break;
                case 'L':
                case 'l':
                    q = new ListDeque();
                    invalid_in = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again... \n");
                    break;
            }


            boolean finished = false;
            while (!finished) {
                System.out.println("What would you like to do?\n 1.) Add to the end of the deque.\n 2.) Add to the front of the deque.\n 3.) Remove from the front.\n 4.) Remove from the end of the Deque.\n 5.) Peek at the front of the Deque.\n 6.) Peek at the end of the Deque.\n 7.) Insert into a position in the deque. \n 8.) Remove a value from any position in the deque and return it.\n 9.) Peek at a value in any position in the deque.\n 10.) Returns the length of the deque.\n 11.) Clears the deque.\n 12.) Exit.\n");
                Scanner input = new Scanner(System.in);
                int output;
                int val = input.nextInt();
                switch (val) {
                    case 1:
                        System.out.println("What would you like to insert?");
                        assert q != null;

                        q.enqueue(s.nextInt());
                        stringItUp(q);
                        break;
                    case 2:
                        System.out.println("What would you like to insert?");
                        q.inject(s.nextInt());
                        stringItUp(q);

                        break;
                    case 3:
                        if (q.length() <= 0) {
                            System.out.println("The list is empty.");
                            break;
                        }
                        q.dequeue();
                        stringItUp(q);
                        break;
                    case 4:
                        if (q.length() <= 0) {
                            System.out.println("The list is empty.");
                            break;
                        }
                        q.removeLast();
                        stringItUp(q);
                        break;
                    case 5:
                        if (q.length() <= 0) {
                            System.out.println("The list is empty.");
                            break;
                        }
                        System.out.println(q.peek());
                        break;
                    case 6:
                        if (q.length() <= 0) {
                            System.out.println("The list is empty.");
                            break;
                        }
                        System.out.println(q.endOfDeque());
                        break;
                    case 7:

                        System.out.println("What would you like to insert?");

                        output = s.nextInt();
                        System.out.println("What position would you like to insert at?");
                        int index = s.nextInt();
                        /*int index = 0;
                        while (true) {

                                index = s.nextInt();
                                if ((index > 0 && index <= q.length())){
                                    break;
                                }

                            System.out.println("Invalid input. Must be an integer and in range of 1 to " + (q.length()));
                        }*/
                        q.insert(output, index);
                        stringItUp(q);
                        break;
                    case 8:
                        if (q.length() <= 0) {
                            System.out.println("The list is empty.");
                            break;
                        }
                        System.out.println("What position would you like to remove from?");
                        index = 0;
                        while (true) {

                            index = s.nextInt();
                            if ((index >= 0 && index <= q.length())) {
                                break;
                            }

                            System.out.println("Invalid input. Must be an integer and in range of 0 to " + (q.length()));
                        }
                        System.out.println(q.remove(index - 1));
                        stringItUp(q);
                        break;
                    case 9:
                        if (q.length() <= 0) {
                            System.out.println("The list is empty.");
                            break;
                        }
                        System.out.println("What position would you like to peek at?");
                        index = 0;
                        while (true) {

                            index = s.nextInt();
                            if ((index >= 0 && index <= q.length())) {
                                break;
                            }

                            System.out.println("Invalid input. Must be an integer and in range of 1 to " + (q.length()));
                        }
                        System.out.println(q.get(index - 1));
                        break;
                    case 10:
                        System.out.println(q.length());
                        break;
                    case 11:
                        q.clear();
                        stringItUp(q);
                        break;
                    case 12:
                        finished = true;
                        break;

                }
            }
        }
    }
    private static void stringItUp (IDeque q){
        String output;
        output = q.toString();
        System.out.println(output);
    }
}
