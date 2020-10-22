package linkedList;

import addTwoNumbers.ListNode;

import javax.management.DynamicMBean;
import java.util.Scanner;

/**
 * @author Yuno
 * @create 2020/10/20-15:23
 */

//构造单链表结点类
public class LinkedList {
    public Integer data;//数据域，存储数据元素
    public LinkedList next;//地址域，引用后继结点

    //构造结点，data指定数据元素，next指定后继结点
    public LinkedList(Integer data, LinkedList next){
        this.data = data;
        this.next = next;
    }
    public LinkedList(){
        this(null, null);
    }

    //返回结点数据域的字符串
    public String toString(){
        if(this.data == null){
            return "null";
        }
        else{
            return this.data.toString();
        }
    }

    public static LinkedList reverseList(LinkedList head){
        //创建两个两个相邻指针，pre在前，cur在后
        LinkedList pre = null;
        LinkedList cur = head;
        while (cur != null){
            LinkedList temp = cur.next;//temp指针用于存放cur下个结点的地址域
            cur.next = pre;//让cur的next指向pre，实现局部反转
            //pre和cur分别往后移动一位
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList();//构造头结点
        System.out.println("请输入你要反转的链表长度");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("请按顺序输入链表的每一个结点的数据域");

        //为链表的每个结点赋值
        LinkedList p = head;
        for(int i = 0; i < n; i++){
            System.out.println("第" + (i + 1) + "个结点的数据为：");
            int data = sc.nextInt();
            p.next = new LinkedList(data, null);
            p = p.next;
        }
        System.out.println("反转后的链表为：");

        LinkedList p1 =  reverseList(head);//创建一个p1来指向反转后的链表
        //遍历输出链表
        while(p1 != null){
            System.out.print(p1.toString() + "\t");
            p1 = p1.next;
        }
    }
}
