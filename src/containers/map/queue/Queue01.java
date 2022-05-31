package containers.map.queue;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Queue01 {

    public static void main(String[] args) throws InterruptedException {
       BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
       blockingQueue.take();
       Deque<String> deque = new LinkedList<>();
       Queue<String> queue = new LinkedList<>();
       deque.offer("offer");
       deque.poll();
       deque.pop();
    }
}
