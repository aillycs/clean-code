package concurrent.lock;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithLock {
    private Lock lock;

    private BigDecimal balance;

    public AccountWithLock(BigDecimal balance) {
        lock = new ReentrantLock(true);
        this.balance = balance;
    }

    public static void transfer(AccountWithLock fromAcct, AccountWithLock toAcct, BigDecimal amount, long timeOut, TimeUnit timeUnit) {
        while (true) {
            if (fromAcct.lock.tryLock()) {
                try {
                    if (toAcct.lock.tryLock()) {
                        try {
                            fromAcct.balance.subtract(amount);
                            toAcct.balance.add(amount);

                        } finally {
                            toAcct.lock.unlock();
                        }
                    }

                } finally {
                    fromAcct.lock.unlock();
                }
            }


            try {
                Thread.sleep(timeOut);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        AccountWithLock account1 = new AccountWithLock(new BigDecimal("100.05"));
        AccountWithLock account2 = new AccountWithLock(new BigDecimal("200.95"));
        transfer(account1, account1, BigDecimal.TEN, 5000, TimeUnit.MILLISECONDS);

    }

}
