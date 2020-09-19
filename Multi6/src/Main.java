import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10_000; i++) {
            new MyThreaad().start();
        }
        Thread.sleep(1000);
        System.out.println(atomicInteger.get());
    }

    static class MyThreaad extends Thread {
        @Override
        public void run() {
            atomicInteger.incrementAndGet();
        }
    }
}
