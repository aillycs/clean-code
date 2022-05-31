package concurrent.thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ThreadLocal01 {
    public static void main(String[] args) {
        ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<>();

        new Thread(() -> dateFormatThreadLocal.get()).start();

        List<Integer> list = new ArrayList<>();

    }
}
