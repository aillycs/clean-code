package leetcode.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    public static void main(String[] args) {
        int[] arr = new int[]{8,9,7,5,1,Integer.MIN_VALUE,2};
        TreeNode root = initWithArr(arr);
        TreeNode x = root;

    }

    public static TreeNode initWithArr(int[] arr) {
        List<TreeNode> tree = new ArrayList<>();
        for (int i : arr) {
            if (i == Integer.MIN_VALUE) {
                tree.add(null);
            } else {
                tree.add(new TreeNode(i));
            }

        }

        for (int i = 0; i < tree.size(); i++) {
            TreeNode node = tree.get(i);
            if (node == null)
                break;
            if (i*2 + 1 >= arr.length) {
                node.left = null;
            } else  {
                node.left = tree.get(i*2 + 1);
            }

            if (i * 2 + 2 >= arr.length) {
                node.right = null;
            } else {
                node.right = tree.get(i*2 + 2);
            }
        }
        return tree.get(0);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
