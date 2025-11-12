import ex_gpt.CustomThread;

import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args) {
        var currenThread = Thread.currentThread();
        System.out.println(currenThread);
        printThreadState(currenThread);
//
//        currenThread.setName("MainGuy");
//        currenThread.setPriority(Thread.MAX_PRIORITY);
//        printThreadState(currenThread);

        CustomThread customThread = new CustomThread();
        customThread.start();


        // using the runnable interface
        Runnable myRunnable = () -> {
            for (int i = 1; i <= 8; i++) {
                System.out.println(" 2 ");
                try {
                    TimeUnit.SECONDS.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread myThread = new Thread(myRunnable);
        myThread.start();


        for (int i = 1; i <= 3; i++) {
            System.out.println(" 0 ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printThreadState(Thread thread) {
        System.out.println("____________________");
        System.out.println("Thread ID: " + thread.getId());
        System.out.println("Thread Name: " + thread.getName());
        System.out.println("Thread Priority: " + thread.getPriority());
        System.out.println("Thread State: " + thread.getState());
        System.out.println("Thread Group: " + thread.getThreadGroup());
        System.out.println("Thread is alive: " + thread.isAlive());
        System.out.println("____________________");
    }
}
