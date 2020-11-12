package queue;

import stack.Node;
import stack.SinglyList;

/**
 * @author Yuno
 * @create 2020/11/11-17:37
 */

//素数线性表(升序，使用单链表存储，尾插入的时间复杂对为O()
public class PrimeList{
    private int range;//素数范围上限
    private SinglyList<Integer> list;//单链表，存储素数线性表
    public PrimeList(int range){
        if(range <= 1){
            System.out.println("无效参数异常");;//无效参数异常
        }
        this.range = range;
        this.list = new SinglyList<>();//构造空单链表
        this.list.insert(2);
        Node<Integer> rear = this.list.head.next;//尾指针
        for (int key = 3; key <= range; key += 2)
            if (this.isPrime(key)){
                rear.next = new Node<Integer>(key, null);
                rear = rear.next;
            }
    }

    public boolean isPrime(int key){//判断key是否素数，遍历this.list单链表
        if (key <= 1){
            throw new java.lang.IllegalArgumentException("key = " + key);//无效参数异常
        }
        int sqrt = (int) Math.sqrt(key);//Math.sqrt(key)返回key的平方根
        for (Node<Integer> p = this.list.head.next; p != null && p.data <= sqrt; p = p.next){
            if (key % p.data == 0){//用list中已知素数测试key
                return false;
            }
        }
        return true;
    }

    public String toString(){
        return "2 ~ " + this.range + "素数集合：" + list.toString() + ", " + list.size() + "个元素";
    }

    public static void main(String[] args) {
        System.out.println(new PrimeList(100).toString());
    }
}
