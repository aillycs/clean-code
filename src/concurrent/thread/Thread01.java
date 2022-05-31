package concurrent.thread;

public class Thread01 {

    public static class T1 extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static class T2 implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void testJoin() {
        // test join
        System.out.println("===== test join ======");
        Thread task1 = new Thread(()-> System.out.println("task1 join: " + Thread.currentThread().getName()));
        Thread task2 = new Thread(()-> {
            try {
                task1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task2 join: " + Thread.currentThread().getName());
        });
        task2.start();
        task1.start();

    }

    public static void main(String[] args) {
        new T1().start();
        T2 t2 = new T2();
        new Thread(t2).start();
        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();

        // pool
//        Executors.newCachedThreadPool().execute(t2);
        testJoin();

    }
}
