package queue;

/**
 * @author Yuno
 * @create 2020/11/12-20:21
 */

//求解素数环问题
public class PrimeRing_plus {
    //求解1~n素数环问题，n = values.length，value[]提供1~n初始序列
    public PrimeRing_plus(Integer[] values){
        Queue<Integer> que = new SeqQueue<Integer>(values.length + 1);//创建空队列
        for (int i = 0; i < values.length; i++){
            que.add(values[i]);//values[]元素全部入队
        }
        System.out.println("初始队列：" + que.toString());

        //使用数组存储素数环
        int[] ring = new int[values.length];
        int last = que.poll().intValue();//出队一个元素
        int n = 0;//数组指针
        ring[n++] = last;//素数环尾插入
        while (!que.isEmpty()){
            int key = que.poll().intValue();//出队一个元素
            if (PrimeRing_plus.isPrime(last + key)){
                ring[n++] = key;//素数环插入
                last = key;
            }else{
                que.add(key);//否则key再次入队
            }
        }
        System.out.println("1 ~ " + values.length + "素数环： ");//输出素数环
        for(int i = 0; i < ring.length; i++){
            System.out.print(ring[i] + " ");
        }
    }

    public static boolean isPrime(int key){//判断key是否素数，遍历this.list单链表
        if (key <= 1){
            throw new java.lang.IllegalArgumentException("key = " + key);//无效参数异常
        }
        int sqrt = (int) Math.sqrt(key);//Math.sqrt(key)返回key的平方根
        for (int i = 2; i < key; i ++){
            if (key % i == 0){//用2~(key-1)的数除key来测试key是否为素数
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        new PrimeRing_plus(values);
    }
}
