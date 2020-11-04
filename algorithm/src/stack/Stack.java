package stack;

/**
 * @author Yuno
 * @create 2020/11/4-19:06
 */
public interface Stack<T> {//栈接口，描述栈抽象接口
    public abstract boolean isEmpty();//判断栈是否为空

    public abstract void push(T x);//元素x入栈

    public abstract T peek();//返回栈顶元素，未出栈

    public abstract  T pop();//出栈，返回栈顶元素
}
