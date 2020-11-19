package multi_array;


/**
 * @author Yuno
 * @create 2020/11/17-20:02
 */
public class Matrix {//矩阵类
    private int rows, columns;//矩阵行数、列数
    private int[][] elements;//二维数组，存储矩阵元素
    private static final int MIN_CAPACITY = 6;//常量，指定element数组容量的最小值
    public Matrix(int m, int n){//构造m*n矩阵，元素为0。若m < 0或 n < 0，则参数错，抛出异常
        if (m > 0 && n > 0){
            this.rows = m;
            this.columns = n;
            if (m < MIN_CAPACITY){
                m = MIN_CAPACITY;
            }
            if (n < MIN_CAPACITY){
                n = MIN_CAPACITY;
            }
            this.elements = new int[m][n];//数组元素初值为0
        }
        else{
            System.out.println("矩阵行列数不能<0");
        }
    }
    public Matrix(int n){//构造n阶方阵
        this(n, n);
    }
    public Matrix(){//构造0*0矩阵；存储容量为最小值
        this(0, 0);
    }
    public Matrix(int m, int n, int[][] values){//构造m*n矩阵，有values[][]提供元素
        this(m, n);
        for (int i = 0; i < values.length && i < m; i++){
            for (int j = 0; j < values[i].length && j < n; j++){
                this.elements[i][j] = values[i][j];
            }
        }
    }
    public int getRows(){//返回矩阵行数
        return this.rows;
    }
    public int getColumns(){//返回矩阵列数
        return this.columns;
    }
    public int get(int i, int j){//返回第i行j列的元素
        if (i >= 0 && i < this.rows && j >= 0 && j < this.columns){
            return this.elements[i][j];
        }
        throw new IndexOutOfBoundsException("数组序号越界");
    }
    public void set(int i, int j, int x){//设置第i行j列元素为x
        if (i >= 0 && i < this.rows && j >= 0 && j < this.columns){
            this.elements[i][j] = x;
        }else {
            System.out.println("下标序号越界，添加失败");
        }
    }
    public String toString(){
        String str = "矩阵" + this.getClass().getName() + "(" + this.rows + "*" + this.columns + ") : \n";
        for (int i = 0; i < this.rows; i ++){
            for (int j = 0; j < this.columns; j++){
                str += String.format("%6d", this.elements[i][j]);
            }
            str += "\n";
        }
        return str;
    }
    public void setRowsColumns(int m, int n){
        if (m > 0 && n > 0){
            if (m > this.elements.length || n > this.elements[0].length){
                int[][] source = this.elements;
                this.elements = new int [m * 2][n * 2];
                for (int i = 0; i < this.rows; i++){
                    for (int j = 0; j < this.columns; j++){
                        this.elements[i][j] = source[i][j];
                    }
                }
                this.rows = m;
                this.columns = n;
            }else{
                System.out.println("矩阵行列数不能为0");
            }
        }
    }

    public static void main(String[] args) {
        int[][] values = {{1, 2, 3}, {4, 5, 6, 7, 8}, {9}};
        Matrix mata = new Matrix(3, 4, values);
        mata.set(2, 3, 10);
        System.out.println(mata.toString());
    }
}
