package cirleftmove;

import java.util.Scanner;

/**
 * @author Yuno
 * @create 2020/10/14-22:38
 */
public class CirLeftMove {
    int[] nums;
    int k;
    public CirLeftMove(int[] nums, int k){
        this.nums = nums;
        this.k = k;
    }

    //构造数组首尾交换函数来颠倒数组，传入一个数组，开始标记符（begin）和结束标记符（end）
    private void reverse(int[] nums, int begin, int end){
        int b = begin, e = end;
        while (b < e){
            int n = nums[b];
            nums[b] = nums[e];
            nums[e] = n;
            b++;
            e--;
        }
    }

    //循环左移k位求目标数组
    public void move(){
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        reverse(nums, 0, nums.length-1);
        for (int values : nums){
            System.out.print(values + "\t");
        }
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
        System.out.println("请输入你要左移的位数");
        int k = sc.nextInt();
        while (k <= 0){
            System.out.println("请输入大于0的整数");
            k = sc.nextInt();
        }
        System.out.println("循环左移" + k + "位后的数组为：");
        CirLeftMove c = new CirLeftMove(nums, k);
        c.move();
    }
}
