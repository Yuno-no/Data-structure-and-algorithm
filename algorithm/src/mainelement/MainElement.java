package mainelement;

/**
 * @author Yuno
 * @create 2020/10/14-18:55
 */
public class MainElement {
    int[] nums;//设置变量存放输入的数组

    public MainElement(int[] nums){
        this.nums = nums;
        int len = nums.length;
        for (int i = 0; i < len; i++){
            nums[nums[i] % len] = nums[nums[i] % len] + len;
        }
    }

    public void printME(){
        for (int i = 0; i < nums.length; i++){
            if ((nums[i] / nums.length) > (nums.length/ 2)){
                System.out.println("该数组的主元为" + i);
                return;
            }
        }
        System.out.println("无主元");
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 4, 3, 4};
        MainElement mainelement = new MainElement(nums);
        mainelement.printME();
    }
}
