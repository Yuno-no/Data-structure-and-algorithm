/**
 * @author Yuno
 * @create 2020/10/11-19:23
 */

//算法描述：求解Josephus环问题，n个人，从start开始计数，每次数到distance的人出环
public class JosephusCir {
    public JosephusCir(int n, int start, int distance){
        //创建一个线性表list，插入从‘A’开始的n个元素
        while (n > 1){
            //start循环计数到distance，第start个元素出环就删除，其后的若干元素向前移动一位
            n--;
        }
        //list中的最后剩下的一个元素即所求
    }
}
