package com.kyrie.leetcodeapp;

import com.kyrie.myleetcode.LeetCodeUtils;
import com.kyrie.myleetcode.model.ListNode;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@SuppressWarnings("SpellCheckingInspection")
public class ExampleUnitTest {
    @Test
    public void leetcode() {
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void leetcode189() {
        assertArrayEquals(new int[]{7, 1, 2, 3, 4, 5, 6}, LeetCodeUtils.leetcode189(new int[]{1, 2, 3, 4, 5, 6, 7}, 1));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, LeetCodeUtils.leetcode189(new int[]{1, 2, 3, 4, 5, 6, 7}, 0));
        assertArrayEquals(new int[]{6, 7, 1, 2, 3, 4, 5}, LeetCodeUtils.leetcode189(new int[]{1, 2, 3, 4, 5, 6, 7}, 2));
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, LeetCodeUtils.leetcode189(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
        assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, LeetCodeUtils.leetcode189(new int[]{1, 2, 3, 4, 5, 6, 7}, 4));
        assertArrayEquals(new int[]{3, 4, 5, 6, 7, 1, 2}, LeetCodeUtils.leetcode189(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7, 1}, LeetCodeUtils.leetcode189(new int[]{1, 2, 3, 4, 5, 6, 7}, 6));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, LeetCodeUtils.leetcode189(new int[]{1, 2, 3, 4, 5, 6, 7}, 7));
        assertArrayEquals(new int[]{2, 1}, LeetCodeUtils.leetcode189(new int[]{1, 2}, 1));
        assertArrayEquals(new int[]{2, 1}, LeetCodeUtils.leetcode189(new int[]{1, 2}, 3));
    }

    @Test
    public void leetcode7() {
        assertEquals(321, LeetCodeUtils.leetcode7(123));
        assertEquals(0, LeetCodeUtils.leetcode7(1534236469));
    }

    @Test
    public void leetcode387() {
        assertEquals(0, LeetCodeUtils.leetcode387("z"));
        assertEquals(-1, LeetCodeUtils.leetcode387("cc"));
        assertEquals(-1, LeetCodeUtils.leetcode387("aabba"));
        assertEquals(8, LeetCodeUtils.leetcode387("aabbaabbc"));
    }

    @Test
    public void leetcode242() {
        assertEquals(false, LeetCodeUtils.leetcode242("aa","aac"));
        assertEquals(true, LeetCodeUtils.leetcode242("anagram","nagaram"));
        assertEquals(false, LeetCodeUtils.leetcode242("rat","car"));
    }

    @Test
    public void leetcode125() {
        assertEquals(true, LeetCodeUtils.leetcode125("A man, a plan, a canal: Panama"));
        assertEquals(false, LeetCodeUtils.leetcode125("race a car"));
        assertEquals(false, LeetCodeUtils.leetcode125("0P"));
        assertEquals(false, LeetCodeUtils.leetcode125("9;8'4P?X:1Q8`dOfJuJXD6FF,8;`Y4! YBy'Wb:ll;;`;\"JI0c2uvD':!LAk:s\"!'0.!2B55.T1VI?00Du?1,l``RFsc?Y?9vD5 K'3'1b!N8hn:'l. R:9:o`m1r.M2mrJ?`Wjv1`G6i6G`1vjW`?Jrm2M.r1m`o:::R .l':nh8N!b1'3'K 5Dv9?Y?csFR``l,1?uD00?IV1T.55B2!.0'!\"s:kAL!:'Dvu2c0IJ\";`;;ll9bW'yBY !4Y`;8,FF6DXJuJfOd`8Q1:X?P4'8;9"));
    }

    @Test
    public void leetcode8() {
        assertEquals(42, LeetCodeUtils.leetcode8("42"));
        assertEquals(42, LeetCodeUtils.leetcode8("42   -42"));
        assertEquals(-42, LeetCodeUtils.leetcode8("     -42"));
        assertEquals(0, LeetCodeUtils.leetcode8(""));
        assertEquals(0, LeetCodeUtils.leetcode8("+"));
        assertEquals(0, LeetCodeUtils.leetcode8("words and 987"));
        assertEquals(Integer.MIN_VALUE, LeetCodeUtils.leetcode8("-91283472332"));
        assertEquals(Integer.MIN_VALUE + 1, LeetCodeUtils.leetcode8("-2147483647"));
        assertEquals(Integer.MAX_VALUE, LeetCodeUtils.leetcode8("92233720368547758070"));
        assertEquals(1, LeetCodeUtils.leetcode8("+1"));
        assertEquals(0, LeetCodeUtils.leetcode8("+-2"));
    }

    @Test
    public void leetcode28() {
        assertEquals(2, LeetCodeUtils.leetcode28("hello", "ll"));
        assertEquals(-1, LeetCodeUtils.leetcode28("aaaaa", "bba"));
        assertEquals(0, LeetCodeUtils.leetcode28("aaaaa", ""));
        assertEquals(0, LeetCodeUtils.leetcode28("", ""));
        assertEquals(0, LeetCodeUtils.leetcode28("a", "a"));
        assertEquals(4, LeetCodeUtils.leetcode28("mississippi", "issip"));
        assertEquals(9, LeetCodeUtils.leetcode28("mississippi", "pi"));
    }

    @Test
    public void leetcode38() {
        assertEquals("1", LeetCodeUtils.leetcode38(1));
        assertEquals("11", LeetCodeUtils.leetcode38(2));
        assertEquals("111221", LeetCodeUtils.leetcode38(5));
        assertEquals("312211", LeetCodeUtils.leetcode38(6));
    }

    @Test
    public void leetcode14() {
        assertEquals("fl", LeetCodeUtils.leetcode14(new String[]{"flower","flow","flight"}));
        assertEquals("", LeetCodeUtils.leetcode14(new String[]{"dog","racecar","car"}));
        assertEquals("a", LeetCodeUtils.leetcode14(new String[]{"aa","a"}));
        assertEquals("a", LeetCodeUtils.leetcode14(new String[]{"asdfasdf","ac","acccccc"}));
    }

    @Test
    public void leetcode234() {
        assertEquals(false, LeetCodeUtils.leetCode234(ListNode.createNode(new int[]{1,2})));
        assertEquals(true, LeetCodeUtils.leetCode234(ListNode.createNode(new int[]{1,2,1,2,3,2,1,2,1})));
    }

    @Test
    public void leetcode904() {
        assertEquals(3, LeetCodeUtils.leetcode904(new int[]{1,2,1}));
        assertEquals(3, LeetCodeUtils.leetcode904(new int[]{0,1,2,2}));
        assertEquals(5, LeetCodeUtils.leetcode904(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }

    @Test
    public void leetcode70() {
        assertEquals(2, LeetCodeUtils.leetcode90(2));
        assertEquals(3, LeetCodeUtils.leetcode90(3));
        assertEquals(5, LeetCodeUtils.leetcode90(4));
    }

    @Test
    public void leetcode121() {
        assertEquals(5, LeetCodeUtils.leetcode121(new int[]{7,1,5,3,6,4}));
        assertEquals(0, LeetCodeUtils.leetcode121(new int[]{7,6,4,3,1}));
        assertEquals(1, LeetCodeUtils.leetcode121(new int[]{1,2}));
        assertEquals(4, LeetCodeUtils.leetcode121(new int[]{3,3,5,0,0,3,1,4}));
    }

    @Test
    public void leetcode53() {
        assertEquals(1, LeetCodeUtils.leetcode53(new int[]{1}));
        assertEquals(3, LeetCodeUtils.leetcode53(new int[]{1, 2}));
        assertEquals(6, LeetCodeUtils.leetcode53(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void leetcodet198() {
        assertEquals(2, LeetCodeUtils.leetcode198(new int[]{1,2}));
        assertEquals(4, LeetCodeUtils.leetcode198(new int[]{2,1,1,2}));
    }
}