package firstMissingPositive;

/**
 * @author Yuno
 * @create 2020/10/18-17:15
 */

/*示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1
*/
public class FirstMissingPositive {
    int[] nums;
    public FirstMissingPositive(int[] nums){
        this.nums = nums;
    }

    public int calculate(){
        int len = nums.length;
        for (int i = 0; i < len; i++){
            if (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < len; i++){
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 5, 4, 3, 8};
        FirstMissingPositive fmp = new FirstMissingPositive(nums);
        System.out.println(fmp.calculate());
    }
}
