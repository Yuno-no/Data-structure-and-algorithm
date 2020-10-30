package KMP;


import java.util.Scanner;

/**
 * @author Yuno
 * @create 2020/10/17-15:48
 */
public class Kmp {
    public static int[] getNext(String pattern){
        int j = 0, k = -1;
        int[] next = new int[pattern.length()];
        next[0] = -1;
        while (j < pattern.length() - 1){
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k)){
                j++;
                k++;
                next[j] = k;
            }else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println("请输入模式串");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] nums = Kmp.getNext(s);
        System.out.println("模式串的Next数组为:");
        for (int values : nums){
            System.out.print(values + "\t");
        }
    }
}
