package sword;
import java.util.*;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class S06 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr1 = Arrays.copyOfRange(arr, 4,5);



        Deque<Integer> list = new LinkedList<>();

        int[] arr2 = new int[50];
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        // exit
        if ( pre.length == 0 && vin.length == 0)
            return null;

        // construct
        int rootValue = pre[0];

        int rootIndex = findRootIndex(rootValue, vin);
        int[] leftVin = Arrays.copyOfRange(vin, 0, rootIndex);
        int[] rightVin = Arrays.copyOfRange(vin, rootIndex + 1, vin.length);

        int[] leftPre = Arrays.copyOfRange(pre, 1, 1 + leftVin.length);
        int[] rightPre = Arrays.copyOfRange(pre, pre.length - rightVin.length, pre.length);

        TreeNode rootNode = new TreeNode(rootValue);
        rootNode.left = reConstructBinaryTree(leftPre, leftVin);
        rootNode.right = reConstructBinaryTree(rightPre, rightVin);

        return rootNode;
    }

    public int findRootIndex(int target, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i])
                return i;
        }

        return 65535;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}