package com.revature;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    private static int money = 500;

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(Thread.currentThread().getName());

        Counter ctr1 = new Counter();
        Counter ctr2 = new Counter();
        // for threads t1 and t2 I want to run whatever the Counter
        // class defined for it's run() method
        Thread t1 = new Thread(ctr1);
        Thread t2 = new Thread(ctr2);

        t1.setName("Stephen");
        t2.setName("Marielle");

        t1.start();
        t2.start();

        Thread t3 = new Thread(() -> withdraw(250));
        Thread t4 = new Thread(() -> withdraw(300));

        t3.setName("Aurynie");
        t4.setName("Marielle");

        t3.start();
        t4.start();
    }

    private synchronized static void withdraw(int amount) {

        try {
            if (money > amount) {
                System.out.println(Thread.currentThread().getName() + " is wihdrawing " + amount);
                Thread.sleep(100);
                money = money - amount;
            }
            System.out.println("Money left in account: " + money);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}

class Counter implements Runnable {
    private int ctr = 0;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (ctr < 10) {
            System.out.println(Thread.currentThread().getName() + " counts " + ctr);
            ctr++;
        }
        System.out.println(Thread.currentThread().getName() + " is done counting");
    }

}
