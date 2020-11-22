package multi_array;

import java.util.Scanner;

/**
 * @author Yuno
 * @create 2020/11/19-22:50
 */
public class SnakeList {
    public int[][] snackList(int n) {
        int status = 0;//状态值
        int nums[][] = new int[n][n];//创建二维数组存放蛇形矩阵
        int i = 0, j = 0;
        for (int k = 1; k <= n * n; k++) {
            nums[i][j] = k;
            if (status == 0) {//当值为0时为顺序填写，为1时倒序
                i--;
                j++;
            } else {
                i++;
                j--;
            }
            //行数越界时，行数减一，列数加二，使要填的位置向右平移一个单位，并变成顺序填写
            if (i > n - 1) {
                i = n - 1;
                j = j + 2;
                status = 0;
            }
            //列数越界时，列数减一，行数加二，是要填的位置向下平移一个单位，并变成倒序填写
            else if (j > n - 1) {
                j = n - 1;
                i = i + 2;
                status = 1;
            } else if (i < 0) {//当行数小于0时，改为倒序
                i = 0;
                status = 1;
            } else if (j < 0) {//当列数小于0时，改为正序
                j = 0;
                status = 0;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SnakeList snack = new SnakeList();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你所求蛇形矩阵的阶数");
        int n = sc.nextInt();
        System.out.println("所求的" + n + "阶" + "蛇形矩阵为：");
        int[][] nums = snack.snackList(n);
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums[i].length; j++){
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
