/**
 * @author Yuno
 * @create 2020/10/11-19:09
 */
public class Array1 {
    public static void print(Object[] values){
        for(Object obj : values){
            System.out.print(obj == null ? "null" : "" + obj.toString() + " ");//遍历输出数组
        }
        System.out.println();
    }
    public static Integer[] random(int n, int size){
        Integer[] values = new Integer[n];
        for (int i = 0; i < values.length; i++){
            values[i] = new Integer((int) (Math.random() * size));//为数组赋值，Math.random()输出0-1的随机数
        }
        return values;
    }

    public static void main(String[] args) {
        int n = 10, size = 100;
        Integer[] values = Array1.random(n, size);
        System.out.println(n + "个元素0-" + size + "之间的随机数序列：");
        Array1.print(values);
    }
}
