package concurrent;

import java.util.concurrent.locks.LockSupport;

public class PrintChar {

    static char[] nums = new char[]{'1','2','3','4','5'};

    static char[] letters = new char[]{'A', 'B', 'C', 'D', 'E'};

    static Thread t1, t2;

    public static void main(String[] args) {
        t1 = new Thread(()->{
            for ( char i : nums) {
                System.out.print(i);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(()->{
            for ( char i : letters) {
                LockSupport.park();
                System.out.print(i);
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
