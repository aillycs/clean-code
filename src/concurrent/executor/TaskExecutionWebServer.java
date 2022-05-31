package concurrent.executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class TaskExecutionWebServer {
    public static final int NTHREADS = 100;
    public static final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        start();
    }

    public static void start() throws IOException {
        ServerSocket socket = new ServerSocket(80);
//        Runtime.getRuntime().addShutdownHook();
        while (!exec.isShutdown()) {
            try {
                final Socket connection = socket.accept();
                exec.execute(() -> handleRequest(connection));
            } catch (RejectedExecutionException e) {
                if (!exec.isShutdown()) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void stop() throws InterruptedException {
        exec.shutdown();
        exec.awaitTermination(5, TimeUnit.SECONDS);
    }

    private static void handleRequest(Socket connection) {
        return;
    }
}
