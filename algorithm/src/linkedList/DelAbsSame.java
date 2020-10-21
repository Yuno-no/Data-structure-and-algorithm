package linkedList;

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
        int[] nums = {2, -2, 1, 3, 4, 2};
        LinkedList head = new LinkedList();//构造头结点
        LinkedList p = head;
        for (int num : nums) {
            p.next = new LinkedList(num, null);
            p = p.next;
        }
        DelAbsSame.delAbsSame(head);
        while (head != null) {
            System.out.print(head.toString() + "\t");
            head = head.next;
        }
    }
}
