package concurrent.thread;

public class Thread02 {

    public void block() {
        synchronized (Thread02.class) {
            System.out.println(Thread.currentThread() + " into block");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Task implements Runnable {
        Thread02 t;

        public Task(Thread02 t) {
            this.t = t;
        }

        @Override
        public void run() {
           t.block();
        }
    }

    public static void main(String[] args) {
        Thread02 thread02 = new Thread02();
        Thread02 thread022 = new Thread02();


        Task t1 = new Task(thread02);
        Task t2 = new Task(thread022);

        for (int i = 0; i < 5; i++) {
            new Thread(t1).start();
            new Thread(t2).start();
        }
    }
}
