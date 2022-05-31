package concurrent.executor;

public class CancelTask {
    public static void main(String[] args) throws InterruptedException {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();

        task2.start();
        Thread.sleep(5000);
        task2.cancel();
        Thread.sleep(5000);


    }

    public static class Task1 implements Runnable {
        public static volatile boolean cancelled = false;

        @Override
        public void run() {
            while (!cancelled) {
                // cancel sleep
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("running");
            }
        }

        public void cancel() {
            cancelled = true;
        }
    }

    public static class Task2 extends Thread {
        @Override
        public void run() {
            System.out.println("task2 start");

            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(20000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("task2 interrupted...");
            } finally {
                System.out.println("sweep floor");
            }
            System.out.println("task2 end");
        }

        public void cancel() {
            interrupt();
        }
    }
}
