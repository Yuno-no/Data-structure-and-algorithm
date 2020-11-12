package queue;

import stack.SinglyList;

/**
 * @author Yuno
 * @create 2020/11/11-15:49
 */
public class PrimeRing {//求解素数环问题
    //求解1~n素数环问题，n = values.length，value[]提供1~n初始序列
    public PrimeRing(Integer[] values){
        Queue<Integer> que = new SeqQueen<Integer>(values.length + 1);//创建空队列
        for (int i = 0; i < values.length; i++){
            que.add(values[i]);//values[]元素全部入队
        }
        System.out.println("初始队列：" + que.toString());

        PrimeList prime = new PrimeList(values.length * 2);
        System.out.println(prime.toString());

        //使用单链表村粗素数环
        SinglyList<Integer> ring = new SinglyList<Integer>();
        int last = que.poll().intValue();//出队一个元素
        ring.insert(last);//素数环尾插入
        while (!que.isEmpty()){
            int key = que.poll().intValue();//出队一个元素
            if (prime.isPrime(last + key)){
                ring.insert(key);
                last = key;
            }else{
                que.add(key);//否则key再次入队
            }
        }
        System.out.println("1 ~ " + values.length + "素数环： " + ring.toString());
    }

    public static void main(String[] args){
        Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        new PrimeRing(values);
    }
}
