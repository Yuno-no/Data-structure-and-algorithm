package stack;

import linkedList.LinkedList;

/**
 * @author Yuno
 * @create 2020/11/8-16:53
 */
public class Node<T> {
    public T data;//数据域，存储数据元素
    public Node<T> next;//地址域，引用后继结点

    //构造结点，data指定数据元素，next指定后继结点
    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }
    public Node(){
            this(null, null);
    }

    //返回结点数据域的字符串
    public String toString(){
        return this.data.toString();
    }
}
