package com.kyrie.leetcodeapp;

import com.kyrie.myleetcode.LeetCodeUtils;

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
}