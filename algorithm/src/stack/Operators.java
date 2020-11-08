package stack;

import java.util.Comparator;

/**
 * @author Yuno
 * @create 2020/11/8-15:40
 */
public class Operators implements Comparator<String> {
    private String[] operator = {"*", "/", "+", "-", "&", "^", "|"};//运算符集合，包含算术和位运算符
    private int[] priority = {3, 3, 3, 4, 4, 8, 9, 10};//operator[]中相同下标运算符的优先级
    private SeqList<String> operlist;//使用顺序表存储运算符集合，调用查找方法

    public Operators(){
        this.operlist = new SeqList<String>(this.operator);
    }

    public int compare(String oper1, String oper2){//比较oper1、oper2运算符的优先级大小
        int i = operlist.search(oper1);
        int j = operlist.search(oper2);
        return this.priority[i] - this.priority[j];
    }

    public int operate(int x, int y, String oper){//返回x、y操作数进行oper运算结果
        int value = 0;
        switch(oper){
            case "+": value = x + y;
                break;
            case "-": value = x - y;
                break;
            case "/": value = x / y;
                break;
            case "%": value = x % y;
                break;
            case "&": value = x & y;
                break;
            case "^": value = x^y;
                break;
            case "|": value = x | y;
                break;
        }
        return value;
    }
}
