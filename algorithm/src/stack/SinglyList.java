package stack;

import javax.xml.validation.Validator;

/**
 * @author Yuno
 * @create 2020/11/8-16:50
 */
public class SinglyList<T> extends Object {//单链表类
    public Node<T> head;//头指针，指向单链表的头结点
    public SinglyList(){//构造方法，构造空单链表
        this.head = new Node<T>();//创建头结点，data和next值均为null
    }
    public SinglyList(T[] values){//构造单链表，尾插入values数组元素
        this();
        Node<T> rear = this.head;//rear尾指针指向单链表最后一个节点，使尾插入效率为o(1)
        for (int i = 0; i < values.length; i++){
            if (values[i] != null){
                rear.next = new Node<T>(values[i], null);//尾插入
                rear = rear.next;
            }
        }
    }

    //判空
    public boolean isEmpty(){
        return this.head.next == null;
    }

    //获取元素
    public T get(int i){//返回第i个元素，0<=i<单链表长度。若i越界，则返回null
        Node<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++){//遍历单链表，寻找第i个元素
            p = p.next;
        }
        return (i >= 0 && p != null) ? p.data : null;//返回第i个元素值
    }

    //设置第i个元素为x
    public void set(int i, T x){
        Node<T> p = this.head;
        if (x == null){
            System.out.println("插入元素不能为空");;
        }
        for (int j = 0; p != null && j < i; j++){
            p = p.next;
        }
        p.data = x;
    }

    public int size(){//返回链表长度
        int i = 0;
        Node<T> p = this.head;
        while (p != null){
            p = p.next;
            i++;
        }
        return i;
    }

    public String toString(){
        String str = this.getClass().getName() + "(";
        for (Node<T> p = this.head.next; p != null; p = p.next){
            str += p.data.toString() + (p.next != null ? "," : "");
        }
        return str + ")";
    }
    public Node<T> insert(int i, T x){
        if (x == null){
            return null;
        }
        Node<T> front = this.head;
        for (int j = 0; front.next != null && j < i; j++){//寻找第i-1个或最后一个节点
            front = front.next;
        }
        front.next = new Node<T>(x, front.next);//在ftont后插入值为x的结点，包括头插入，中间插入，尾插入
        return front.next;
    }

    public Node<T> insert (T x){
        //调用insert(i, x),用整数的对大值指定插入在最后，遍历一次，i必须容错
        return insert(Integer.MAX_VALUE, x);
    }

    //删除
    public T remove(int i){//删除第i个元素，0 <= i <长度，返回被删除元素。若i越界，则返回null
        Node<T> front = this.head;
        for (int j = 0; front.next != null && j < i; j++){
            front = front.next;
        }
        if (i >= 0 && front.next != null){
            T x = front.next.data;
            front.next = front.next.next;
            return x;
        }
        return null;
    }

    public void clear(){//清空单链表
        this.head.next = null;
    }

}
