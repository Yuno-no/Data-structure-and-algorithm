package multi_array;

import java.util.ArrayList;

/**
 * @author Yuno
 * @create 2020/11/19-19:54
 */
public class addTriple {
    public static int[][] addTriple(Triple[] a, Triple[] b){
        ArrayList<Triple> c = new ArrayList<Triple>();
        int i = 0, j = 0;
        while(i < a.length && j < b.length){
            if (a[i].row == b[j].row && a[i].column == b[j].column){
                c.add(new Triple(a[i].row, a[i].column, a[i].value + b[j].value));
                i++;
                j++;
            }else if ((a[i].row == b[j].row && a[i].column < b[j].column) || a[i].row < b[j].row){
                c.add(new Triple(a[i].row, a[i].column, a[i].value));
                i++;
            }else if((a[i].row == b[j].row && b[j].column < a[i].column) || b[j].row < a[i].row){
                c.add(new Triple(b[j].row, b[j].column, b[j].value));
                j++;
            }
        }
        int[][] matrix = new int[5][6];
        for (int m = 0; m < c.size(); m++){
            Triple temp = c.get(m);
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
        int[][] c = addTriple(a, b);
        for (int i = 0; i < c.length; i++){
            for (int j = 0; j < c[i].length; j++){
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
