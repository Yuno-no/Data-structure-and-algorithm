package firstMissingPositive;

import java.util.Scanner;

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
            //遍历数组，当元素为[1，N]时，将nums[i]与nums[nums[i] - 1]置换
            //且元素不大于数组长度，且nums[i]与nums[nums[i] - 1]不相等
            if (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        //遍历经过置换后的数组，判断元素是否在正确的位置，如果nums[i] != i + 1，则i + 1 为最小正整数
        for (int i = 0; i < len; i++){
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
//      int[] nums = {-1, 5, 4, 3, 8};
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("请输入数组的每个元素");
        for (int i = 0; i < nums.length; i++){
            nums[i] = sc.nextInt();
        }
        FirstMissingPositive fmp = new FirstMissingPositive(nums);
        System.out.println(fmp.calculate());
    }
}
