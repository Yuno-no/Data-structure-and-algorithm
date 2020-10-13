package yangHui;

import java.util.Scanner;

/**
 * @author Yuno
 * @create 2020/10/13-21:25
 */
public class YangHui {
    int row;//存放杨辉三角的行数
    int[][] yangHui;//存放杨辉三角
    public YangHui(int row){
        this.row = row;
        yangHui = new int[row][];
        for(int i = 0; i < yangHui.length; i++){
            yangHui[i] = new int[i + 1];//设置每行长度
        }
        yangHui[0][0] = 1;//将第一列的值设为1
        for(int r = 1; r < yangHui.length; r++){
            //将最后一列的值设为1
            yangHui[r][0] = 1;
            yangHui[r][r] = 1;
            //设置其他值
            for(int c = 1; c < r; c++){
                yangHui[r][c] = yangHui[r - 1][c - 1] + yangHui[r - 1][c];
            }
        }
    }
    public void get(){
        //输出杨辉三角的行数
        System.out.println("杨辉三角的行数为" + row + "行");
    }

    public void print(){
        //循环遍历数组并输出
        for(int r = 0; r < yangHui.length; r++){
            for(int c = 0; c <= r; c++){
                System.out.print(yangHui[r][c] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("请输入所求杨辉三角的行数");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n <= 0){
            System.out.println("请输入大于0的整数");
            n = sc.nextInt();
        }
        YangHui yanghui = new YangHui(n);
        yanghui.get();
        System.out.println("其排列为：");
        yanghui.print();
    }
}
