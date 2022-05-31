package sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class S05 {
    /**
     * 描述
     * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
     *
     * 如输入{1,2,3}的链表如下图:
     *
     * 返回一个数组为[3,2,1]
     *
     * 0 <= 链表长度 <= 10000
     */

    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> st = new Stack<>();
        ListNode ptr = listNode;
        while(ptr != null) {
            st.push(ptr.val);
            ptr = ptr.next;
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(!st.empty()) {
            res.add(st.pop());
        }
        return res;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();

        ListNode ptr = listNode;
        int size = 0;
        while(ptr != null) {
            res.add(ptr.val);
            ptr = ptr.next;
            size++;
        }
        // reverse arr
        int s = 0;

        for (int i = 0, j = size-1; j > i; i++, j--) {
            s = res.get(i);
            res.set(i, res.get(j));
            res.set(j, s);
        }

        return res;
    }

    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();

        ListNode ptr = listNode;
        while(ptr != null) {
            res.add(0, ptr.val);
            ptr = ptr.next;
        }

        return res;
    }

    public ArrayList<Integer> result = new ArrayList<>();

//    public ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {
//        // 递归
//        if(listNode!=null){
//            printListFromTailToHead4(listNode.next);
//            result.add(listNode.val);
//        }
//
//        Arrays.copyOfRange()
//        return result;
//    }


    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
