package queue;

/**
 * @author Yuno
 * @create 2020/11/11-15:19
 */
public final class SeqQueen<T> implements Queue<T> {
    private Object[] element;//存储队列数据元素的数组
    private int front,rear;//front,rear分别为队列头尾下标
    private static final int MIN_CAPACITY = 16;//常量，指定element数组容量的最小值

    public SeqQueen(int length){
        if (length < MIN_CAPACITY){
            length = MIN_CAPACITY;//设置数组容量最小值
        }
        this.element = new Object[length];
        this.front = this.rear = 0;//设置空队列
    }

    public SeqQueen(){//构造空队列，默认容量
        this(MIN_CAPACITY);//默认队列数组容量取最小值
    }

    public boolean isEmpty(){//判空
        return this.front == this.rear;
    }

    public boolean add(T x){//元素x入队，空对象不能入队
        if (x == null){
            return false;
        }
        if (this.front == (this.rear + 1) % this.element.length){//若队列满，则扩充数组
            Object[] temp = this.element;
            this.element = new Object[temp.length * 2];//重新申请一个容量更大的数组
            int j = 0;
            for (int i = this.front; i != this.rear; i = (i + 1) % temp.length){
                this.element[j++] = temp[i];//按照队列元素次序复制数组元素
            }
            this.front = 0;
            this.rear = j;
        }
        this.element[this.rear] = x;
        this.rear = (this.rear + 1) % this.element.length;
        return true;
    }

    public T peek(){//返回队头元素，没有删除。若队列为空，则返回null
        return this.isEmpty() ? null : (T)this.element[this.front];
    }

    public T poll(){
        if (this.isEmpty()){
            return null;
        }
        T temp = (T)this.element[this.front];
        this.front = (this.front + 1) % this.element.length;
        return temp;
    }
}
