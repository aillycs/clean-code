package leetcode.dataStructure.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法
 */
public class LC46Permutations {
    public static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        permute(arr);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> tmpResult = new ArrayList<>();
        recursive(nums, 0, tmpResult);
        return result;
    }

    /**
     *
     * @param nums  输入的数组
     * @param index 当前在处理排列的第几个元素（层数）
     * @param tmpResult 截至目前的排列
     */
    public static void recursive(int[] nums, int index, List<Integer> tmpResult) {
        // 递归出口
        if (index == nums.length) {
            List<Integer> item = new ArrayList<>(tmpResult);
            print(item);
            result.add(item);
            return;
        }

        // 循环全部，找出没选过的，作为第index个元素
        for (int i = 0; i < nums.length; i++) {
            if (!tmpResult.contains(nums[i])) {
                // 选择
                tmpResult.add(nums[i]);
                // 递归
                recursive(nums, index+1, tmpResult);
                // 回溯
                tmpResult.remove(tmpResult.size()-1);
            }
        }
    }

    private static void print(List<Integer> item) {
        item.stream().forEach(System.out::print);
        System.out.println();
    }
}
