package leetcode.dataStructure.problems;

import java.util.Arrays;
import java.util.LinkedList;

public class LC300LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] seq = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(seq, -1);
        int res = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // dp[i] = Math.max(dp[i], dp[j]+1);
                    if (dp[j]+1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        seq[i] = j;
                    }
                }

            }
//            res = Math.max(res, dp[i]);
            if (dp[i] > res) {
                res = dp[i];
                index = i;
            }
        }

        while (index > 0) {
            System.out.print(nums[index] + " ");
            index = seq[index];
        }
        System.out.println();
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,9,2,5,3,7,101,18};
        Integer[] arrs = new Integer[]{1,2,null,3};
        System.out.println(lengthOfLIS(arr));
        // 输出找到的LIS
    }
}
