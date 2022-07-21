package x01_two_sum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] n = nums.clone();
        Arrays.sort(n);

        Pair p = new Pair();
        boolean flag = searchTarget(n, target, p);
        if(flag) {
            return searchNums(nums, p.getA(), p.getB());
        }

        return new int[]{-1,-1};
    }

    private int[] searchNums(int[] nums, int a, int b){
        int index = 0;
        Pair p = new Pair();

        for(int item : nums){
            if( item == a) {
               p.a = index;
               break;
            }
            index++;
        }

        p.b = searchNumsReverse(nums, b);

        if( p.a < p.b){
            return new int[]{p.a, p.b};
        }else {
            return new int[]{p.b, p.a};
        }

    }

    private int searchNumsReverse(int[] nums, int n){
        int index = nums.length-1;
        while(index >=0){
            if( nums[index] == n){
                break;
            }
            index--;
        }
        return index;
    }

    private int searchLastNegative(int[] nums){
        int index = -1;
        for(int n : nums){
            if( n < 0){
                index++;
            }
        }
        return index;
    }

    private boolean searchTarget(int[] nums, int target, Pair p){
        int lastNegativeIndex = searchLastNegative(nums);
        if( target < 0){
            int fIndex = 0;
            int lIndex = lastNegativeIndex;
            while (fIndex < lIndex) {
                int secondIndex = fIndex + 1;
                if (compareAndFindPair(nums, target, p, fIndex, lIndex, secondIndex))
                    return true;
                fIndex++;
            }

            fIndex = 0;
            lIndex = nums.length-1;
            while (fIndex <= lIndex){
                int secondIndex = lastNegativeIndex + 1;
                if (compareAndFindPair(nums, target, p, fIndex, lIndex, secondIndex))
                    return true;
                fIndex++;
            }

        } else {
            int fIndex = lastNegativeIndex + 1;
            int lIndex = nums.length-1;
            while (fIndex < lIndex){
                int secondIndex = fIndex + 1;
                if (compareAndFindPair(nums, target, p, fIndex, lIndex, secondIndex))
                    return true;
                fIndex++;
            }

            fIndex = 0;
            lIndex = lastNegativeIndex;
            while (fIndex <= lIndex){
                int secondIndex = lastNegativeIndex + 1;
                int lastIndex = nums.length-1;
                if (compareAndFindPair(nums, target, p, fIndex, lastIndex, secondIndex))
                    return true;
                fIndex++;
            }
        }

        return false;
    }

    private Boolean compareAndFindPair(int[] nums, int target, Pair p, int fIndex, int lIndex, int secondIndex) {
        while (secondIndex <= lIndex) {
            if ((nums[fIndex] + nums[secondIndex]) == target) {
                p.a = nums[fIndex];
                p.b = nums[secondIndex];
                return true;
            } else if ((nums[fIndex] + nums[secondIndex]) > target) {
                break;
            } else {
                secondIndex++;
            }
        }
        return false;
    }


    class Pair{
        private int a, b;
        Pair(){
        }
        int getA() {
            return a;
        }
        int getB() {
            return b;
        }
    }

}
