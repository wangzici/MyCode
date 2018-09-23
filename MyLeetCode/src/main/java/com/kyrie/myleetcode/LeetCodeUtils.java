package com.kyrie.myleetcode;

import com.kyrie.myleetcode.model.ListNode;
import com.kyrie.myleetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public void leetCode237(ListNode node) {
        //传入的node是要被删除的node
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
    }

    public ListNode leetcode19(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        head = newHead;
        ListNode lastNode = head;
        ListNode firstNode = head;
        for (int i = 0; i < n; i++) {
            lastNode = lastNode.next;
        }
        while (lastNode.next != null) {
            firstNode = firstNode.next;
            lastNode = lastNode.next;
        }
        if (firstNode.next == null) {
            return null;
        }
        firstNode.next = firstNode.next.next;
        return head.next;
    }

    public ListNode leetcode206(ListNode head) {
        //solution 1 迭代
        /*ListNode mPre = null;
        ListNode mCur = head;
        while (mCur != null) {
            ListNode mNext = mCur.next;
            mCur.next = mPre;

            mPre = mCur;
            mCur = mNext;
        }
        return mPre;*/

        //solution 2 递归
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = leetcode206(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public ListNode leetcode21(ListNode l1, ListNode l2) {
        ListNode newListNode = new ListNode(0);
        ListNode newHead = newListNode;
        /*while(l1 != null || l2 != null){
            if (l1 != null && (l2 == null || l2.val > l1.val)) {
                newListNode.next = l1;
                l1 = l1.next;
            }else {
                newListNode.next = l2;
                l2 = l2.next;
            }
            newListNode = newListNode.next;
        }*/
        while (l1 != null && l2 != null) {
            if (l2.val > l1.val) {
                newListNode.next = l1;
                l1 = l1.next;
            } else {
                newListNode.next = l2;
                l2 = l2.next;
            }
            newListNode = newListNode.next;
        }
        if (l1 != null) {
            newListNode.next = l1;
        } else {
            newListNode.next = l2;
        }
        return newHead.next;
    }

    public static boolean leetCode234(ListNode head) {
        //solution 1
        ListNode slowNode = head;
        ListNode fastHead = head;
        if (head == null || head.next == null) {
            return true;
        }
        while (fastHead.next != null && fastHead.next.next != null) {
            fastHead = fastHead.next.next;
            slowNode = slowNode.next;
        }

        ListNode mPre = slowNode;
        ListNode mCur = slowNode.next;
        while (mCur != null) {
            ListNode mNext = mCur.next;
            mCur.next = mPre;

            mPre = mCur;
            mCur = mNext;
        }
        slowNode.next = null;
        while (head != null) {
            if (mPre.val != head.val) {
                return false;
            }
            mPre = mPre.next;
            head = head.next;
        }
        return true;

        /*0ms大神解法*/
        //此解法正确性未知
        /*if(head==null||head.next==null) return true;//空链表和长度1的链表返回true
        if(head.next.next==null){
            if(head.val==head.next.val) return true;
            return false;
        }
        //长度3以上的链表比较
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next!=null){
            if(fast.next.val==slow.val){
                if(fast.next.next!=null) return false;
                fast.next=null;
                slow = slow.next;
                fast = slow.next;
                if(fast==null||fast.val==slow.val){
                    return true;
                }
            }else{
                fast=fast.next;
            }
        }
        return false;*/
    }

    public boolean leetcode141(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public int leetcode104(TreeNode root) {
        //solution 1
//        return root == null ? 0 : (1 + Math.max(leetcode104(root.left) , leetcode104(root.right)));

        //solution 2
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            result++;
            final int size = q.size();
            for(int i = 0;i < size;i++){
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
        return result;
    }

    public static int leetcode904(int[] tree) {
        int result1 = 0;
        int result2 = 0;
        int resultMax = 0;
        int f1 = -1;
        int f2 = -1;
        int pre = -1;
        int lastChangeIndex = 0;
        final int length = tree.length;
        if(length <= 2){
            return length;
        }
        for(int i = 0;i < length;i++){
            if(tree[i] == f1){
                result1++;
            }else if(tree[i] == f2){
                result2++;
            }else if(f1 == -1){
                f1 = tree[i];
                result1++;
            }else if(f2 == -1){
                f2 = tree[i];
                result2++;
            }else{
                resultMax = resultMax < (result1 + result2) ? (result1 + result2) : resultMax;
                if(pre != f1){
                    f1 = f2;
                }
                result1 = i - lastChangeIndex;
                result2 = 1;
                f2 = tree[i];
            }
            if(tree[i] != pre){
                lastChangeIndex = i;
            }
            pre = tree[i];
        }
        resultMax = resultMax < (result1 + result2) ? (result1 + result2) : resultMax;
        return resultMax;
    }

    public boolean leetcode98(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        /*Stack<TreeNode> stack = new Stack<>();
        while (stack.size() != 0 || node != null) {
            if (node == null) {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            } else {
                stack.push(node);
                node = node.left;
            }
        }*/
        for (int i = 0; i < list.size() - 1 ; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void inorder(TreeNode node,List<Integer> list){
        if(node == null) return;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }

    public boolean leetcode101(TreeNode root) {
        //solution 1
        //return root != null && isTreeSymmetric(root.left,root.right);

        //solution2
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root.left);
        queue2.offer(root.right);
        while (queue1.size() != 0 && queue2.size() != 0) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if(node1 == null && node2 == null){
                continue;
            } else if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            queue1.offer(node1.left);
            queue1.offer(node1.right);
            queue2.offer(node2.right);
            queue2.offer(node2.left);
        }
        return true;
    }

    public boolean isTreeSymmetric(TreeNode left, TreeNode right){
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isTreeSymmetric(left.left, right.right) && isTreeSymmetric(left.right, right.left);
    }

    public List<List<Integer>> leetcode201(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        //solution 1
        /*LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> integers;
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            //此处一定要重新new一个ArrayList，否则使用重复的话会导致存储在result里的ArrayList也被修改
            integers = new ArrayList<>();
            //注意此处一定要先把size取出来，因为在循环中也会修改queue的size
            //并且取出来了之后，就不用再重复创建一个新的Queue来区分相邻的两层
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                integers.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(integers);
        }
        return result;*/
        addLevel(root, 1, result);
        return result;
    }

    private void addLevel(TreeNode node,int length,List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (result.size() < length) {
            result.add(new ArrayList<Integer>());
        }
        result.get(length - 1).add(node.val);
        length++;
        addLevel(node.left, length,result);
        addLevel(node.right, length, result);
    }

    public TreeNode leetcode108(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        /*final int size = nums.length;
        TreeNode node = new TreeNode(nums[size/2]);

        if (nums.length > 2) {
            node.left = leetcode108(Arrays.copyOfRange(nums, 0, size / 2));
            node.right = leetcode108(Arrays.copyOfRange(nums, size / 2 + 1, size));
        } else if (nums.length == 2) {
            node.left = new TreeNode(nums[0]);
        }
        return node;*/

        //solution2
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(nums[start]);
        } else {
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode((nums[mid]));
            node.left = sortedArrayToBST(nums, start, mid - 1);
            node.right = sortedArrayToBST(nums, mid + 1, end);
            return node;
        }
    }

    public int leetcode908(int[] A, int K) {
        if(A.length <= 1){
            return 0;
        }
        int max = findMax(A);
        int min = findMin(A);
        if(max - min <= K * 2){
            return 0;
        }else{
            return max - min - 2 * K;
        }
    }

    private int findMax(int[] A){
        int max = Integer.MIN_VALUE;
        for(int a : A){
            max = max < a ? a : max;
        }
        return max;
    }

    private int findMin(int[] A){
        int min = Integer.MAX_VALUE;
        for(int a : A){
            min = min > a ? a : min;
        }
        return min;
    }
}
