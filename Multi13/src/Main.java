import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static int accaunt = 0;

    public static void main(String[] args) throws InterruptedException {
    }

    static class AccauntPlus extends Thread {
        @Override
        public void run() {
            lock.lock();
            accaunt += 10;
            condition.signal();
            lock.unlock();
        }
    }

    static class AccauntMinus extends Thread {
        @Override
        public void run() {
            if (accaunt < 10) {
                try {
                    lock.lock();
                    System.out.println(accaunt);
                    condition.await();
                    System.out.println(accaunt);
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            accaunt -= 10;
            System.out.println(accaunt);
        }
    }
}
