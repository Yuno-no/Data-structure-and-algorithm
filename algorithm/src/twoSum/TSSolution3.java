package twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuno
 * @create 2020/9/26-11:04
 */

//方法三:一遍哈希表
public class TSSolution3 {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("NO two sum solution");
    }
/*时间复杂度O(n)
* 空间复杂度O(n)*/

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 10};
        int target1 = 10;
        int[] result1 = TSSolution3.twoSum(nums1, target1);
        for (int value : result1) {
            System.out.println(value);
        }
    }
}
