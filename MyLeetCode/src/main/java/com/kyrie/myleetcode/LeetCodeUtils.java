package com.kyrie.myleetcode;

public class LeetCodeUtils {
    public static int[] leetcode189(int[] nums, int k) {
        final int length = nums.length;
        k = (k + length) % length;
        int i = 0;
        int cur = nums[i];
        int start = i;
        //cnt代表当前次数，当次数达到了长度时，表示得到了结果
        for (int cnt  = 0; cnt  < length; cnt ++) {
            i = (i + k) % length;
            //替换cur和目标位置的值
            int t = nums[i];
            nums[i] = cur;
            //当下一个要替换的目标i是起始位置，则往后挪一位
            //如nums = {1,2,3,4} , k = 2
            //当i又等于0时，表示位置0和2都已经替换过了，不往后挪一位的话就无法操作位置1和3里的数值了
            if (i == start) {
                i++;
                i = i % length;
                start++;
                cur = nums[i];
            } else {
                cur = t;
            }
        }
        return nums;
    }
}
