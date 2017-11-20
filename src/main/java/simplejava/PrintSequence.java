package simplejava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gbalasubramanian on 18/11/17.
 */
public class PrintSequence {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        PrintNumber one = new PrintNumber("1");
        PrintNumber two = new PrintNumber("2", one);
        PrintNumber three = new PrintNumber("3",two);
        one.parent = three;
        executorService.execute(one);
        executorService.execute(two);
        executorService.execute(three);

    }
}

class PrintNumber implements Runnable {
    public String number;
    public Runnable parent;

    public PrintNumber(String number) {
        this.number = number;
    }

    public PrintNumber(String number, Runnable parent) {
        this.number = number;
        this.parent = parent;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(number);
            try {
                synchronized (this) {
                    notify();
                }
                synchronized (parent) {
                    parent.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
