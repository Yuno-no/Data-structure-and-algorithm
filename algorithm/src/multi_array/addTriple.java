package multi_array;

import java.util.ArrayList;

/**
 * @author Yuno
 * @create 2020/11/19-19:54
 */
public class addTriple {
    public static int[][] addTriple(Triple[] a, Triple[] b, int m, int n){//传入两个三元组数组和其对应的行数和列数
        ArrayList<Triple> c = new ArrayList<Triple>();//利用数组队列存储相加后的三元组
        int i = 0, j = 0;
        while(i < a.length && j < b.length){
            //遍历两个三元组数组，并对其判断相加;当两个指针都分别指向每个数组的最后一个元素时停止
            if (a[i].row == b[j].row && a[i].column == b[j].column){
                //当两个三元组行列相等时
                //对其值相加并将得到的新三元组加入ArrayList
                c.add(new Triple(a[i].row, a[i].column, a[i].value + b[j].value));
                i++;
                j++;
            }
            //当两个三元组行列数不相等时进行判断，将靠前的三元组加入ArrayList
            else if ((a[i].row == b[j].row && a[i].column < b[j].column) || a[i].row < b[j].row){
                c.add(new Triple(a[i].row, a[i].column, a[i].value));
                i++;
            }else if((a[i].row == b[j].row && b[j].column < a[i].column) || b[j].row < a[i].row){
                c.add(new Triple(b[j].row, b[j].column, b[j].value));
                j++;
            }
        }
        //将ArrayList中的三元组化为矩阵，返回对应的二维数组
        int[][] matrix = new int[m][n];
        for (int x = 0; x < c.size(); x++){
            Triple temp = c.get(x);
            matrix[temp.row][temp.column] = temp.value;
        }
        return matrix;
    }

    public static void main(String[] args) {
        Triple a1 = new Triple(0, 2, 11);
        Triple a2 = new Triple(0, 4, 17);
        Triple a3 = new Triple(1, 1, 20);
        Triple a4 = new Triple(3, 0, 19);
        Triple a5 = new Triple(3, 2, 36);
        Triple a6 = new Triple(3, 5, 28);
        Triple a7 = new Triple(4, 2, 50);
        Triple[] a = {a1, a2, a3, a4, a5, a6, a7};

        Triple b1 = new Triple(0, 2, -11);
        Triple b2 = new Triple(0, 4, -17);
        Triple b3 = new Triple(2, 3, 51);
        Triple b4 = new Triple(3, 0, 10);
        Triple b5 = new Triple(4, 1, 23);
        Triple b6 = new Triple(4, 4, 0);
        Triple[] b = {b1, b2, b3, b4, b5, b6};
        int[][] c = addTriple(a, b, 5, 6);
        //输出相加后的矩阵
        for (int i = 0; i < c.length; i++){
            for (int j = 0; j < c[i].length; j++){
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
