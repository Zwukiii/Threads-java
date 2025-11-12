package ex_gpt;


public class RunnableExample {
    public static void main(String[] args) {
        Runnable worker = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Worker: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("Worker finished");

        };
        Thread myThread = new Thread(worker);
        myThread.start();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Main still running...");
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main finished!");


        }
    }
}

