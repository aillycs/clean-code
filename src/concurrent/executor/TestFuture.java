package concurrent.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestFuture {
    public static ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        Future<List<String>> futureRes = pool.submit(new CalcTask());

        try {
            List<String> result = futureRes.get();
            result.forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            futureRes.cancel(true);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static class CalcTask implements Callable<List<String>> {
        @Override
        public List<String> call() throws Exception {
            Thread.sleep(5000);
            List<String> res = new ArrayList<>();
            res.add("alpha");
            res.add("beta");
            return res;
        }
    }
}
