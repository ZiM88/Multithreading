package Multi;

public class Main {
    public static void main(String[] args) throws Exception {
//        MyThread myThread = new MyThread();
//        myThread.start();
//        System.out.println(Thread.currentThread().getName());
//
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread2 = new Thread(myRunnable);
//        thread2.start();
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("thread name: " + Thread.currentThread().getName() + " i = " + i);
        }
//        System.out.println(Thread.currentThread().getName());
    }
}
//class MyRunnable implements Runnable{
//    @Override
//    public void run(){
//        System.out.println(Thread.currentThread().getName());
//    }
//}