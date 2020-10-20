package linkedList;

import addTwoNumbers.ListNode;

import javax.management.DynamicMBean;

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
        LinkedList pre = null;
        LinkedList cur = head;
        while (cur != null){
            LinkedList temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        LinkedList head = new LinkedList();//构造头结点
        LinkedList p = head;
        for (int num : nums) {
            p.next = new LinkedList(num, null);
            p = p.next;
        }
        head = reverseList(head);
        while (head != null) {
            System.out.print(head.toString() + "\t");
            head = head.next;
        }
    }
}
