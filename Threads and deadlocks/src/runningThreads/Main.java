package runningThreads;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread running");

        try {
            System.out.println("Main thread paused for one second");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(() -> {
            String tName = Thread.currentThread().getName();
            System.out.println(tName + " should take 10 dots to run.");
            for (int i = 1; i <= 10; i++) {
                System.out.println(". ");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("\nWhoops!! " + tName + " interrupted");
                    System.out.println("A1. State = " + Thread.currentThread().getState());
                    return;
                }
            }
            System.out.println("\n" + tName + " completed.");
        }, "WorkThread");

        Thread installThread = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(250);
                    System.out.println("Installation step " + (i + 1) + " is completed-");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "InstallThread");

        System.out.println(thread.getName() + " starting");
        thread.start();

        Thread threadMonitor = new Thread(() -> {
            long now = System.currentTimeMillis();
            while (thread.isAlive()) {
                try {
                    Thread.sleep(1000);
                    System.out.println("B. State = " + thread.getState());
                    if (System.currentTimeMillis() - now > 2000) {
                        thread.interrupt();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "MonitorThread");

        threadMonitor.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!thread.isInterrupted()) {
            installThread.start();
        } else {
            System.out.println("Previous thread was interrupted, " + installThread.getName() + " can’t run.");
        }
    }
}
