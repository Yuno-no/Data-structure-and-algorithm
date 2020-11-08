package stack;

/**
 * @author Yuno
 * @create 2020/11/8-19:42
 */
public final class LinkedStack<T> implements Stack<T> {
    private SinglyList<T> list;//使用单链表来储存栈元素

    public LinkedStack(){//构造空栈
        this.list = new SinglyList<T>();
    }

    public boolean isEmpty(){
        return this.list.isEmpty();
    }

    public void push(T x){//元素x入栈，空对象不能入栈
        this.list.insert(0, x);//单链表头插入元素x
    }

    public T peek(){//返回栈顶元素（未出栈），若栈为空，则返回null
        return this.list.get(0);
    }

    public T pop(){//出栈，返回栈顶元素，若栈为空，则返回null
        return this.list.remove(0);
    }

}
