package binary_tree;

/**
 * @author Yuno
 * @create 2020/11/25-19:18
 */
public class BinaryNode<T> {
    public T data;//数据域，存储数据元素
    public BinaryNode<T> left, right;//地址域，分别指向左右孩子结点

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right){//构造结点
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data){//构造叶子结点
        this.data = data;
    }
}
