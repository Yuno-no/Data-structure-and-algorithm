package linkedList;

import java.util.Scanner;

/**
 * @author Yuno
 * @create 2020/10/21-21:33
 */
public class DelAbsSame {
    public static LinkedList delAbsSame(LinkedList head){
        int[] nums = new int[1000];//用空间换时间，创建足够大的数组来判断
        //将数组里的每个元素设为0
        for (int i = 0; i < nums.length; i++){
            nums[i] = 0;
        }
        //创建两个指针，分别指向当前的值和下一个值
        LinkedList p = head.next;
        LinkedList pre = p.next;

        //将链表第一个结点的值作为数组下标，并将其元素设为1
        nums[Math.abs(p.data)] = 1;
        while (pre != null){
            if (nums[Math.abs(pre.data)] == 0){
                nums[Math.abs(pre.data)] = 1;
            }else if (pre.next != null && nums[Math.abs(pre.data)] == 1){
                p.next = pre.next;
            }else if (pre.next == null && nums[Math.abs(pre.data)] == 1){
                p.next = null;
            }
            pre = pre.next;

            if (p.next != pre){
                p = p.next;
            }
        }
        return p;
    }
    public static void main(String[] args) {
        LinkedList head = new LinkedList();//构造头结点
        System.out.println("请输入你要压缩的链表长度");
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
        System.out.println("压缩后的链表为：");

        delAbsSame(head);//调用静态方法压缩链表
        LinkedList p1 = head;
        //遍历输出压缩后的链表
        while(p1!= null) {
            System.out.print(p1.toString() + "\t");
            p1 = p1.next;
        }
    }
}
