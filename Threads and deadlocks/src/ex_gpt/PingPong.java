package ex_gpt;

public class PingPong {
    public static void main(String[] args) {
        PingThread pingThread = new PingThread();
        PongThread pongThread = new PongThread();
        pingThread.start();
        pongThread.start();


    }
}
