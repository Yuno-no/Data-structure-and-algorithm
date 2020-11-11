package stack;

/**
 * @author Yuno
 * @create 2020/11/8-15:14
 */
//顺序表类，T表示数据元素的数据类型，默认继承Object
public class SeqList<T> extends Object {
    protected int n;//顺序表元素个数（长度）
    protected Object[] element;//对象数组存储顺序表的数据元素
    private static final int MIN_CAPACITY = 16;//常量，指定element数组容量的最小值

    //构造空表，length指定数组容量，若length < MIN，则取最小值
    public SeqList(int length){
        if (length < MIN_CAPACITY){
            length = MIN_CAPACITY;
        }
        this.element = new Object[length];//申请数组空间，元素为null
        this.n = 0;
    }

    //创建默认容量的空表
    public SeqList(){
        this(MIN_CAPACITY);
    }

    //构造顺序表，由values数组提供元素，忽略其中空对象。 O(n)
    public SeqList(T[] values){
        //创建2倍values数组容量的空表，若values == null，则抛出异常
        this(values.length * 2);
        for(int i = 0; i < values.length; i++){
            if (values[i] != null){
                this.element[this.n++] = values[i];//对象对用赋值
            }
        }
    }

    //判断是否为空，空则返回true。O(1)
    public boolean isEmpty(){
        return this.n == 0;
    }

    //返回元素个数。 O(1)
    public int size(){
        return this.n;
    }

    //若 0<= i < n，则返回第i个元素，否则返回null。O(1)
    public T get(int i){
        if (i >= 0 && i < this.n){
            return (T) this.element[i];//返回数组元素引用的对象，传递对象引用
        }
        return null;
    }

    //若0 <= i < n且x != null，则设置第i个元素为x，否则抛出异常
    public void set(int i, T x){
        if (x == null){
            throw new NullPointerException("x == null");
        }
        if (i >= 0 && i < this.n){
            this.element[i] = x;//对象引用赋值
        }else{
            throw new java.lang.IndexOutOfBoundsException(i + "");//抛出序号越界异常
        }
    }

    //返回所有元素的描述字符串，形式为“(,)”，覆盖Object类的toString()方法。 顺序表遍历算法 O(N)
    public String toString(){
        String str = this.getClass().getName() + "(";
        if (this.n > 0){
            str += this.element[0].toString();
        }
        for (int i = 1; i < this.n; i++){
            str += "," + this.element[i].toString();
        }
        return str += ")";
    }

    //插入x为第i个元素， x != null，返回插入元素的序号。对i容错，若i < 0，则头插入;若i > 长度，则尾插入。 O(n)
    public int insert(int i, T x){
        if (x == null){
            return -1;
        }
        if (i < 0){//插入i容错，头插入
            i = 0;
        }
        if (i > this.n){//尾插入
            i = this.n;
        }
        Object[] sourse = this.element;//数组变量引用赋值
        if (this.n == element.length){
            this.element = new Object[sourse.length * 2];//申请一个更大容量的数组
            for (int j = 0; j < i; j++){
                this.element[j] = sourse[j];//复制当前i - 1个元素
            }
        }
        for (int j = this.n - 1; j >= i; j--){
            this.element[j] = sourse[j];//从i开始至表尾的元素向后移动，次序从后向前
        }
        this.element[i] = x;
        this.n++;
        return i;
    }
    public int insert(T x){//尾插入，方法重载
        return this.insert(this.n, x);
    }

    public T move(int i){//删除第i个元素，0<=i<n，返回被删除元素。若i越界，则返回null
        if(i >= 0 && i < this.n){
            T x = (T)this.element[i];//x储存被删除的元素
            for (int j = i; j < this.n-1; j++){
                this.element[j] = this.element[j+1];//元素前移一个位置
                this.element[this.n-1] = null;//设置数组元素对象为空，释放原引用实例
                this.n--;
                return x;
            }
            return x;
        }
        return null;
    }

    public void clear(){//删除所有元素
        this.n = 0;
    }

    public int search(T key){
    //在this引用的顺序表中，顺序表查找首个与key相等的元素，返回元素序号i，0<=i<n；若查找不成功，返回-1
        for (int i = 0; i < this.n; i++){
            if (key.equals(this.element[i])){
                return i;
            }
        }
        return -1;
    }
}