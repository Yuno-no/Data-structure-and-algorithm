package binary_tree;

/**
 * @author Yuno
 * @create 2020/11/25-19:24
 */
public class BinaryTree<T> {
    public BinaryNode<T> root;//根节点

    public BinaryTree(){
        this.root = null;//构造空二叉树
    }

    public boolean isEmpty(){
        return this.root == null;//判断是否为空二叉树
    }


    public void insert(T x){//插入x元素作为根节点
        if (x != null){
            this.root = new BinaryNode<T>(x, this.root, null);
        }
    }

    public BinaryNode<T> insert(BinaryNode<T> p, boolean left, T x){//插入x为p结点的左/右孩子，返回插入结点
        if (x == null || p == null){
            return null;
        }
        if (left){
            return p.left = new BinaryNode<T>(x, p.left, null);
        }
        return p.right = new BinaryNode<T>(x, null, p.right);
    }

    public void remove(BinaryNode<T> p, boolean left){//删除p结点的左/右子树
        if (p != null){
            if (left){
                p.left = null;
            }else {
                p.right = null;
            }
        }
    }

    public void clear(){//删除二叉树的所有结点
        this.root = null;
    }

    public void preorder(){
        preorder(this.root);
        System.out.println();
    }
    public void preorder(BinaryNode<T> p){
        if (p != null){
            System.out.print(p.data.toString() + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }

    public void inorder(){
        inorder(this.root);
        System.out.println();
    }
    public void inorder(BinaryNode<T> p){
        if (p != null){
            inorder(p.left);
            System.out.print(p.data.toString() + " ");
            inorder(p.right);
        }
    }

    public void postorder(){
        postorder(this.root);
        System.out.println();
    }
    public void postorder(BinaryNode<T> p){
        if (p != null){
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data.toString() + " ");
        }
    }

    public BinaryTree(T[] prelist){
        this.root = create(prelist);
    }
    private int i = 0;
    private BinaryNode<T> create(T[] prelisst){
        BinaryNode<T> p =null;
        if (i < prelisst.length){
            T elem = prelisst[i++];
            if (elem != null){
                p = new BinaryNode<T>(elem);
                p.left = create(prelisst);
                p.right = create(prelisst);
            }
        }
        return p;
    }
}
