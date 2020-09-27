package addTwoNumbers;

import com.sun.tools.javac.Main;
import org.w3c.dom.ls.LSException;
import org.w3c.dom.ls.LSInput;

import java.lang.invoke.CallSite;
import java.sql.SQLOutput;
import java.util.List;

/**
 * @author Yuno
 * @create 2020/9/27-10:41
 */
public class ATNSolution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;
        int carry = 0;

        while (p != null || q!= null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null){p = p.next;}
            if (q != null){q = q.next;}
        }
        if (carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    /*时间复杂度：O(max(m,n))，假设 mm 和 nn 分别表示 l1l1 和 l2l2 的长度，上面的算法最多重复max(m,n) 次。
    空间复杂度：O(max(m,n))，新列表的长度最多为max(m,n)+1。*/


    public static void main(String[] args) {
        //创建第一个链表3->4->2
        ListNode l1 = new ListNode(3);//第一个节点
        //必须有一个指针去往第一个节点上加数据
        ListNode p = l1;//p指针会从链表的第一个节点一直往下走
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(2);
        //创建第二个链表4->6->5
        ListNode l2 = new ListNode(4);
        ListNode q = l2;
        q.next = new ListNode(6);
        q = q.next;
        q.next = new ListNode(5);
        ListNode re = addTwoNumbers(l1, l2);
        while (re != null){
            System.out.print(re.val);
            re = re.next;
        }
    }
}
