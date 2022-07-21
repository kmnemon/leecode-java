package x01_two_sum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testTwoSum(){
        int[] nums = {9, 2, 3, 5, 7, 1};
        Solution s = new Solution();

        int[] index = s.twoSum(nums, 9);

        assertEquals(1, index[0]);
        assertEquals(4, index[1]);
    }

    @Test
    public void testTwoSumEqual(){
        int[] nums = {3, 3};
        Solution s = new Solution();

        int[] index = s.twoSum(nums, 6);

        assertEquals(0, index[0]);
        assertEquals(1, index[1]);
    }

    @Test
    public void testTwoSumNagetive(){
        int[] nums = {-1, -2, -3, -4, -5};
        Solution s = new Solution();

        int[] index = s.twoSum(nums, -8);

        assertEquals(2, index[0]);
        assertEquals(4, index[1]);
    }

    @Test
    public void testTwoSumNagetiveAndPositive(){
        int[] nums = {-1, -2, -3, -4, -5, 0, 0, 0, 0, 1, 9, 6};
        Solution s = new Solution();

        int[] index = s.twoSum(nums, -1);

        assertEquals(1, index[0]);
        assertEquals(9, index[1]);
    }

    @Test
    public void testTwoSumNagetiveAndPositive2(){
        int[] nums = {-3, 4, 3, 90};
        Solution s = new Solution();

        int[] index = s.twoSum(nums, 0);

        assertEquals(0, index[0]);
        assertEquals(2, index[1]);
    }


}
