package cirleftmove;

/**
 * @author Yuno
 * @create 2020/10/14-22:38
 */
public class CirLeftMove {
    int[] nums;
    public CirLeftMove(int[] nums, int k){
        this.nums = nums;
        int n1 = k;
        int n2 = k;
        int n3 = k;
        int[] nums1 = new int[k];
        int[] nums2 = new int[nums.length - k];
        int[] nums3 = new int[nums.length];
        for (int i = 0; i < k; i++){
            nums1[i] = nums[n1 - 1];
            n1--;
        }
        for (int i = 0, j = nums.length; i < nums.length - k; i++, j--){
            nums2[i] = nums[j-1];
        }
        for (int i = 0; i < k; i++){
            nums3[i] = nums1[i];
        }
        for (int i = 0; i < nums.length - k; i++){
            nums3[i + k] = nums2[i];
        }
        for (int i = 0, j = nums.length; i < nums.length; i++, j--){
            nums[i] = nums3[j - 1];
        }
        for (int values : nums){
            System.out.print(values + "\t");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        CirLeftMove c = new CirLeftMove(nums, 3);
    }
}
