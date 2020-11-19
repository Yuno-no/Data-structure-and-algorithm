package multi_array;

/**
 * @author Yuno
 * @create 2020/11/19-19:24
 */

//三元组类
public class Triple {
    public int row;
    public int column;
    public int value;

    public Triple(int row, int column, int value){//构造方法，为三元组的三个属性赋值
        if (row >= 0 && column >= 0){
            this.row = row;
            this.column = column;
            this.value = value;
        }else{
            System.out.println("行列号不能为负数");
        }
    }

    public String toString(){
        return "(" + row + "," + column + "," + value +")";
    }
}
