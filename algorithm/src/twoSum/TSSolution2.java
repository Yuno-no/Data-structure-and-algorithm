package twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuno
 * @create 2020/9/26-10:43
 */

//方法二：两遍哈希表
public class TSSolution2 {
    public static int[] towSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*时间复杂度O(n)
    * 空间复杂度O(n)*/
}
