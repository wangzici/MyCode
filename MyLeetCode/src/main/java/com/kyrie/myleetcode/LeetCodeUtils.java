package com.kyrie.myleetcode;

public class LeetCodeUtils {
    public static int[] leetcode189(int[] nums, int k) {
        final int length = nums.length;
        k = (k + length) % length;
        int i = 0;
        int cur = nums[i];
        int start = i;
        //cnt代表当前次数，当次数达到了长度时，表示得到了结果
        for (int cnt = 0; cnt < length; cnt++) {
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
        for (int i = 0; i < length / 2; i++) {
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

    public static int leetcode387(String s) {
        //solution 1
        /*char[] arrays = s.toCharArray();
        Set<Character> repeatChars = new HashSet<Character>();
        final int length = arrays.length;
        for(int i = 0;i<length;i++){
            char cur = arrays[i];
            if(i == length -1){
                if(repeatChars.contains(cur)){
                    return -1;
                }else{
                    return i;
                }
            }
            for(int j = i + 1;j<length;j++){
                if(repeatChars.contains(cur) || cur == arrays[j]){
                    repeatChars.add(cur);
                    break;
                } else if(j == length -1){
                    return i;
                }
            }
        }
        return -1;*/

        //best solution
        int result = -1;
        for (char curChar = 'a'; curChar <= 'z'; curChar++) {
            int firstIndex = s.indexOf(curChar);
            int lastIndex = s.lastIndexOf(curChar);
            if (firstIndex != -1 && firstIndex == lastIndex) {
                result = (result == -1) ? firstIndex : Math.min(result, firstIndex);
            }
        }
        return result;
    }

    public static boolean leetcode242(String s, String t) {
        //solution 1
        /*final char[] arrayS = s.toCharArray();
        final char[] arrayT = t.toCharArray();
        final int lengthS = arrayS.length;
        final int lengthT = arrayT.length;
        if(lengthS != lengthT){
            return false;
        }
        for(char curChar = 'a';curChar <= 'z' ; curChar++){
            int numS = 0;
            int numT = 0;
            for(int i=0;i<lengthS;i++){
                if(curChar == arrayS[i]){
                    numS++;
                }
            }
            for(int i=0;i<lengthT;i++){
                if(curChar == arrayT[i]){
                    numT++;
                }
            }
            if(numS != numT){
                return false;
            }
        }
        return true;*/

        //使用api的简易方法
        /*if(s.length() != t.length()) return false;
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(ts);

        for(int i = 0; i < ss.length; i++){
            if(ss[i] != ts[i]) return false;
        }

        return true;*/

        //solution 2
        final char[] arrayS = s.toCharArray();
        final char[] arrayT = t.toCharArray();
        final int lengthS = arrayS.length;
        final int lengthT = arrayT.length;
        if (lengthS != lengthT) {
            return false;
        }
        int[] countS = new int[26];
        int[] countT = new int[26];
        for (int i = 0; i < lengthS; i++) {
            countS[arrayS[i] - 'a']++;
            countT[arrayT[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (countS[i] != countT[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean leetcode125(String s) {
        //solution 1
        //use more api like toLowerCase() and trim()
/*        char[] arrays = s.toLowerCase().trim().toCharArray();
        final int length = arrays.length;
        int start = 0;
        int end = length - 1;
        while(start < end){
            if (!isValid(arrays[start])) {
                start++;
            } else if (!isValid(arrays[end])) {
                end--;
            } else if (arrays[start] != arrays[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;*/

        //solution 2
        char[] arrays = s.toCharArray();
        final int length = arrays.length;
        int[] res = new int[length];
        int resLength = 0;
        for (char c : arrays) {
            int resultA = c - 'a';
            int resultB = c - 'A';
            if (resultA >= 0 && resultA <= 25) {
                res[resLength++] = c - 'a' + 10;
            } else if (resultB >= 0 && resultB <= 25) {
                res[resLength++] = c - 'A' + 10;
            } else if (c >= '0' && c <= '9') {
                res[resLength++] = c - '0';
            }
        }
        for (int i = 0; i < resLength / 2; i++) {
            if (res[i] != res[resLength - i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static int leetcode8(String str) {
        //solution 1
        /*boolean startNum = false;
        char[] chars = str.toCharArray();
        int result = 0;
        boolean isPositive = true;
        for(char c : chars){
            if (!startNum && (c == '-' || c == '+')) {
                startNum = true;
                if (c == '-') {
                    isPositive = false;
                }
            } else if(c >= '0' && c <= '9') {
                startNum = true;
                if (isPositive && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && c > '7'))) {
                    result = Integer.MAX_VALUE;
                    break;
                } else if (!isPositive && (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && c > '8'))) {
                    result = Integer.MIN_VALUE;
                    break;
                } else {
                    int t = Integer.parseInt(String.valueOf(c)) * (isPositive ? 1 : -1);
                    result = result * 10 + t;
                }
            } else if (startNum || c != ' ') {
                break;
            }
        }
        return result;*/

        //solution 2
        int index = 0;
        long out = 0;
        boolean isPositive = true;
        final int length = str.length();
        while (index < length && str.charAt(index) == ' ') {
            index++;
        }
        if (index < length && str.charAt(index) == '-') {
            isPositive = false;
            index++;
        } else if (index < length && str.charAt(index) == '+') {
            isPositive = true;
            index++;
        }
        while (index < length && Character.isDigit(str.charAt(index))) {
            final char c = str.charAt(index);
            out = out * 10 + c - '0';
            if (out > Integer.MAX_VALUE) {
                if (isPositive) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            index++;
        }
        if (!isPositive) {
            out *= -1;
        }
        return (int) out;
    }

    public static int leetcode28(String haystack, String needle) {
        //solution 1
        /*final int lengthH = haystack.length();
        final int lengthN = needle.length();
        if (lengthN == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int result = 0;
        boolean findFirst = false;
        while (i < lengthH) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (findFirst) {
                    i++;
                } else {
                    findFirst = true;
                    result = i;
                    i++;
                }
            } else {
                findFirst = false;
                j = 0;
                i = ++result;
            }
            if (j == lengthN) {
                return result;
            }
        }
        return -1;*/

        //solution 2
        final int lengthN = needle.length();
        if (lengthN == 0 || haystack.equals(needle)) {
            return 0;
        }
        if (haystack.contains(needle)) {
            final String[] split = haystack.split(needle);
            if (split.length == 0) {
                return 0;
            } else{
                return split[0].length();
            }
        }
        return -1;
    }

    public static String leetcode38(int n) {
        if (n == 1) {
            return "1";
        }
        String preResult = leetcode38(n - 1);
        StringBuilder stringBuilder = new StringBuilder();
        //solution 1
        /*int i = 1;
        char curChar = preResult.charAt(0);
        int curCount = 1;
        while (i < preResult.length()) {
            if (curChar == preResult.charAt(i)) {
                curCount++;
            } else {
                stringBuilder.append(curCount).append(curChar);
                curCount = 1;
                curChar = preResult.charAt(i);
            }
            i++;
        }
        stringBuilder.append(curCount).append(curChar);*/

        //solution 2
        //原理相同，不过这种循环方式思路更加清晰，代码量更少
        int i = 0;
        while (i < preResult.length()) {
            int index = i;
            while (i < preResult.length() && preResult.charAt(i) == preResult.charAt(index)) {
                i++;
            }
            stringBuilder.append(i - index).append(preResult.charAt(index));
        }
        return stringBuilder.toString();
    }

    public static String leetcode14(String[] strs) {
        //solution 1
        /*if (strs.length == 0) {
            return "";
        }
        String firstStr = strs[0];
        int result = firstStr.length();
        for (int i = 1; i < strs.length; i++) {
            final String curString = strs[i];
            int temp = 0;
            for (int j = 0; j < result && j < strs[i].length() && curString.charAt(j) == firstStr.charAt(j); j++) {
                temp++;
            }
            result = temp;
        }
        if (result == 0) {
            return "";
        }else {
            return firstStr.substring(0, result);
        }*/

        //solution 2
        if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(result)) {
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void leetCode237(ListNode node) {
        //传入的node是要被删除的node
        ListNode temp = node.next;
        if (temp == null) {
            node = null;
        } else {
            node.val = temp.val;
            node.next = temp.next;
            temp.next = null;
        }
    }

}
