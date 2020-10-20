package mainelement;

import java.util.Scanner;

/**
 * @author Yuno
 * @create 2020/10/18-15:12
 */

//摩尔投票法求主元
public class MajorityElement {
    int nums[];
    public MajorityElement(int nums[]) {
        this.nums = nums;
    }

    public void calculate(){
        int temp = nums[0];//将第一个元素设为主元,出现一次获得一票
        int count = 1;//票数初始化为1

        //遇到相同的数票数加一，否则票数减一
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == temp){
                count++;
            }else{
                count--;
            }
            //当票数为0时，更换候选人，并将票数count重置为1。
            if (count == 0){
                temp = nums[i];
                count = 1;
            }
        }
        //循环遍历数组验证是否满足主元的要求
        count = 0;
        for (int num : nums){
            if (num == temp){
                count++;
            }
            if (count > nums.length / 2){
                System.out.println("该数组主元为" + temp);
                return;
            }
        }
        System.out.println("没有主元");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组的长度");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("请输入数组的每个元素");
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        MajorityElement me = new MajorityElement(nums);
        me.calculate();
    }
}
