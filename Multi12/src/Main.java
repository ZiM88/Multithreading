import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Thread1().start();
        new Thread2().start();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            Lock lock = new ReentrantLock();
            lock.lock();
            System.out.println(getName() + "  start working");
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " stop working");
            lock.unlock();
            System.out.println(getName() + " lock is released");
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            Lock lock = new ReentrantLock();
            System.out.println(getName() + " begin working");
            while (true) {
                if (lock.tryLock()) {
                    System.out.println(getName() + " working");
                    break;
                } else {
                    System.out.println(getName() + " wating");
                }
            }
        }
    }
}
