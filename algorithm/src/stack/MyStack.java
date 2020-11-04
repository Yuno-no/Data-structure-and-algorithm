package stack;


import java.util.Arrays;

/**
 * @author Yuno
 * @create 2020/11/4-19:02
 */
public final class MyStack<T> {
    private Object[] stack;//实现栈的数组
    private int size;//数组大小

    MyStack(){
        stack = new Object[10];//初始容量为10
    }

    //扩大容量
    public void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 3 / 2 + 1;//每次扩大50%
            stack = Arrays.copyOf(stack, size);
        }
    }


    //判断是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //返回栈顶元素
    public T peek(){
        T t = null;
        if (size > 0){
            t = (T)stack[size -1];
        }
        return t;
    }

    //元素t进栈
    public void push(T t){
        expandCapacity(size + 1);
        stack[size] = t;
        size++;
    }

    //出栈
    public T pop(){
        T t = peek();
        if (size > 0){
            stack[size - 1] = null;
            size--;
        }
        return t;
    }

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.push("java");
        stack.push("is");
        stack.push("beautiful");
        stack.push("language");
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }
}
