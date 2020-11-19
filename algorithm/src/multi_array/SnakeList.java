package multi_array;

import java.util.Arrays;

/**
 * @author Yuno
 * @create 2020/11/19-22:50
 */
public class SnakeList {
    public void snackList(int n) {
        int status = 0;
        int nums[][] = new int[n][n];
        int i = 0, j = 0;
        for (int k = 0; k < n * n; k++) {
            nums[i][j] = k + 1;
            if (status == 0) {
                i--;
                j++;
            } else {
                i++;
                j--;
            }
            if (i > n - 1) {
                i = n - 1;
                j = j + 2;
                status = 0;
            } else if (j > n - 1) {
                j = n - 1;
                i = i + 2;
                status = 1;
            } else if (i < 0) {
                i = 0;
                status = 1;
            } else if (j < 0) {
                j = 0;
                status = 0;
            }
        }
        for (int k = 0; k < n; k++) {
            System.out.println(Arrays.toString(nums[k]));
        }
    }

    public static void main(String[] args) {
        SnakeList snack = new SnakeList();
        snack.snackList(5);
    }
}
