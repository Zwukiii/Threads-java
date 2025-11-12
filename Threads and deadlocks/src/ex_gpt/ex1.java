package ex_gpt;

public class ex1 {
    public static void main(String[] args) {
        System.out.println("MyThread starting...");
        CustomThread thread = new CustomThread();
        thread.start();
    }
}
