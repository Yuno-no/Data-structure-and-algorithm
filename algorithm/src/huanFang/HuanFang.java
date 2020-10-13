package huanFang;

import java.util.Scanner;

/**
 * @author Yuno
 * @create 2020/10/13-20:01
 */
public class HuanFang {
    int[][] huanfang;//设置一个二维数组存放幻方
    int n;//设置幻方阶数
    public HuanFang(int n){
        this.n = n;
        int r = 0;//从第一行开始
        int c = n / 2;//从第一行中间的列开始填
        int num = 1;//设置第一位数
        huanfang = new int[n][n];//创建n*n的数组
        for(int i = 1; i <= n*n; i++){
            huanfang[r][c] = num;
            r = (r - 1 + n) % n;
            c = (c + 1 ) % n;//往右上角填幻方
            if(huanfang[r][c] != 0){
                //遇到不为空的方格向下平移两行，再向左一列开始填
                r = (r + 2) % n;
                c = (c - 1 + n) % n;
            }
            num++;
        }
    }
    public void get(){
        //获取幻方阶数，并打印出来
        System.out.println("所求的幻方阶数为" + n + "阶");
    }
    public void print(){
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
        HuanFang huanFang = new HuanFang(n);//测试n阶幻方
        huanFang.get();//打印阶数
        huanFang.print();//打印出幻方
    }

}
