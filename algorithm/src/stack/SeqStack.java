package stack;

/**
 * @author Yuno
 * @create 2020/11/8-15:21
 */

//利用顺序表构造顺序栈
public final class SeqStack<T> implements Stack<T>{
    private SeqList<T> list;//使用顺序表存储栈元素
    public SeqStack(int length){//构造容量为length的空栈
        this.list = new SeqList<T>(length);
    }

    public SeqStack(){//构造默认容量的空栈
        this(64);
    }

    public boolean isEmpty(){//判断栈是否为空，若为空，则返回true
        return this.list.isEmpty();
    }

    public void push(T x){//元素x入栈，空对象不能入栈
        this.list.insert(x);
    }

    public T peek(){//返回栈顶元素，若栈为空，则返回null
        return this.list.get(list.size()-1);
    }

    public T pop(){
        return list.move(list.size()-1);//若栈不空，则顺序表尾删除，返回删除元素
    }
}
