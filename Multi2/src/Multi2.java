public class Multi2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread main");
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("thread 0");
    }
}
