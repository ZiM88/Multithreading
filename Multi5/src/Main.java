public class Main {
    volatile static int i = 0;

    public static void main(String[] args) {
        new MyThreadWrite().start();
        new MyThreadRead().start();
    }

    static class MyThreadWrite extends Thread {
        @Override
        public void run() {
            while (i < 5) {
                System.out.println("increment i to " + (++i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThreadRead extends Thread {
        @Override
        public void run() {
            int localVAr = i;
            while (localVAr < 5) {
                if (localVAr != i) {
                    System.out.println("new value of i is " + i);
                    localVAr = i;
                }
            }
        }
    }
}
