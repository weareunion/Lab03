package cpsc2150.MyDeque;

import java.util.Scanner;

public class DequeApp {
    public static void main(String[] args) {
        IDeque q = null;

        System.out.println("Do you want to use an array (A) or list (L)?\n");


        boolean invalid_in = true;

        while (invalid_in){
            Scanner s = new Scanner(System.in);
            char in = s.next().charAt(0);
            switch (in){
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
        }

        /*
        You will add in code here to ask the user whether they want an
        array implementation or a list implementation. Then use their
        answer to initialize q appropriately
        */
        Character x = 'a';
        q.enqueue(x);
        x = 'k';
        q.enqueue(x);
        x = 'j';
        q.enqueue(x);
        x = '1';
        q.enqueue(x);
        x = 'f';
        q.enqueue(x);

        System.out.println("---- METHOD 1 DEQUEUE & ENQUEUE  ----\n");
        for (int i = 0; i < q.length(); i++) {
            Character c = q.dequeue();
            System.out.println("EN/DEQUEUE: " + i + ": " + c + "\n");
            q.enqueue(c);
        }

        System.out.println("---- METHOD 2 REMOVE LAST & INJECT !WILL BE REVERSED ----\n");
        for (int i = 0; i < q.length(); i++) {
            Character c = q.removeLast();
            System.out.println("REM/INJECT: " + i + ": " + c + "\n");
            q.inject(c);
        }

    }
}
