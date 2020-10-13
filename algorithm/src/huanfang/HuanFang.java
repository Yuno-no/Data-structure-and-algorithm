package huanfang;

import java.util.Scanner;

/**
 * @author Yuno
 * @create 2020/10/13-20:01
 */
public class HuanFang {
    public HuanFang(int n){
        int r = 0;
        int c = n / 2;//从第一行中间的列开始填
        int num = 1;//设置第一位数
        int huanfang[][] = new int[n][n];//创建n*n的数组
        for(int i = 1; i <= n*n; i++){
            huanfang[r][c] = num;
            r = (r - 1 + n) % n;
            c = (c + 1 ) % n;//往右上角填幻方
            if(huanfang[r][c] != 0){
                //遇到已被填的方格向下平移两行，向左一列开始填
                r = (r + 2) % n;
                c = (c - 1 + n) % n;
            }
            num++;
        }
        //遍历输出数组
        for(int j = 0; j < huanfang.length; j++){
            for(int k = 0; k < huanfang[0].length; k++){
                System.out.print(huanfang[j][k] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("请输入所求的幻方的阶数:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n % 2 == 0 || n == 1 || n < 0){
            System.out.println("输入错误，请输入一个不为1正奇数");
            n = sc.nextInt();
        }
        System.out.println("所求的幻方为:");
        HuanFang three = new HuanFang(n);//测试n阶幻方
    }

}
