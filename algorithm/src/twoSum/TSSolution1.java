package twoSum;

/**
 * @author Yuno
 * @create 2020/9/26-10:22
 */

//方法一：暴力法
//暴力法很简单，遍历每个元素 x，并查找是否存在一个值与 target - x相等的目标元素。

public class TSSolution1 {
    public static int[] twoSum(int[] nums, int target){
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if(nums[j] == target - nums[i]){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    /*时间复杂度O(n^2)
    * 空间复杂度O(1)*/

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 10};
        int target1 = 10;
        int[] result1 = TSSolution1.twoSum(nums1, target1);
        for (int value : result1) {
            System.out.println(value);
        }
    }
}
