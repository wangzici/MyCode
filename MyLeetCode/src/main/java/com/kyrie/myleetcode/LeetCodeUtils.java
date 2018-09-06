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

    public static String leetcode334(String s) {
        char[] arrays = s.toCharArray();
        final int length = arrays.length;
        for(int i=0; i < length/2 ; i++){
            char temp = arrays[i];
            arrays[i] = arrays[length - i - 1];
            arrays[length - i - 1] = temp;
        }
        return new String(arrays);
    }

    public static int leetcode7(int x) {
        //solution 1
        /*String s = x + "";
        char[] arrays = s.toCharArray();
        final int length = arrays.length;
        int i = 0;
        int j = length - 1;
        while (i < j){
            if (i == 0 && arrays[i] == '-') {
                i++;
                continue;
            }
            char temp = arrays[i];
            arrays[i] = arrays[j];
            arrays[j] = temp;
            i++;
            j--;
        }
        try {
            return Integer.parseInt(new String(arrays));
        } catch (NumberFormatException e) {
            return 0;
        }*/

        //solution 2
        int result = 0;
        int next = x;
        int pop;
        do {
            pop = next % 10;
            next = next / 10;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            } else if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            result = result * 10 + pop;
        } while (next != 0);
        return result;
    }
}
