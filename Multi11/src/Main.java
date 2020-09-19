import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws Exception {
        Resource resource = new Resource();
        resource.i = 5;
        resource.j = 5;
        MyThread myThread = new MyThread();
        myThread.setName("one");
        MyThread myThread2 = new MyThread();
        myThread.start();
        myThread2.start();
        myThread.join();
        myThread2.join();
        System.out.println(resource.i);
        System.out.println(resource.j);
    }
}

class MyThread extends Thread {
    Resource resource;

    @Override
    public void run() {
        resource.changeI();
        resource.changej();
    }
}

class Resource {
    int i;
    int j;

    Lock lock = new ReentrantLock();

    void changeI() {
        lock.lock();
        int i = this.i;
        if (Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        i++;
        this.i = i;
    }

    void changej() {
        int j = this.j;
        if (Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        j++;
        this.j = j;
        lock.unlock();
    }
}