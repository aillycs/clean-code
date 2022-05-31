package leetcode.dataStructure;

import java.util.*;

public class MyHashMap<K, V> {

    final static int initSize = 8;
    Node<K, V>[] slots;

    public MyHashMap() {
        slots = new Node[initSize];
    }

    public V put(K key, V value) {
        int index = getIndex(key);

        if (slots[index] != null) {
            // insert from head
            // find first
            Node<K, V> pointer = slots[index];
            while (pointer != null) {
                if (pointer.key.equals(key)) {
                    pointer.value = value;
                    return value;
                } else {
                    pointer = pointer.next;
                }
            }
            // insert node if not found
            Node<K, V> node = new Node<>(key, value);
            Node<K, V> head = slots[index];
            node.next = head.next;
            head.next = node;
        } else {
            slots[index] = new Node<>(key, value);;
        }

        return value;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V>  pointer = slots[index];
        while (pointer != null) {
            if (pointer.key.equals(key)) {
                return pointer.value;
            } else {
                pointer = pointer.next;
            }
        }
        return null;
    }

    private int getIndex(K key) {
        if (key == null)
            return 0;
        return key.hashCode() & Integer.MAX_VALUE % initSize;
    }

    public static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        MyHashMap<String, String> myMap = new MyHashMap<>();
        myMap.put("name", "Tom");
        myMap.put("age", "17");
        myMap.put("age", "27");
        myMap.put("watch", "casio");
        System.out.println("name is: " + myMap.get("name"));
        System.out.println("age is: " + myMap.get("age"));
        System.out.println("watch is: " + myMap.get("casio"));
        List<int[]> result = new ArrayList<>();
        String a = "ss";
        int[] b;
        Deque<Integer> stack = new LinkedList<>();
        char[] arr = a.toCharArray();
        String.valueOf(arr);
        StringBuffer sb;
        Set<Integer> ss = new TreeSet<>();
        int[] iaa = new int[5];
        Arrays.sort(iaa);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.poll();

    }
}
