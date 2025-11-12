package ex_gpt;

public class PongThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Pong");
            try {
                Thread.sleep(300);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
