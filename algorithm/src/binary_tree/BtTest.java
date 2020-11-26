package binary_tree;

/**
 * @author Yuno
 * @create 2020/11/25-20:31
 */
public class BtTest {
    public static void main(String[] args) {
        String[] prelist = {"A", "B", "D", null, "G", null, null, null, "C", "E", null, null, "F", "H"};
        BinaryTree<String> strtree = new BinaryTree<String>(prelist);
        System.out.println("先根遍历二叉树：");
        strtree.preorder();
        System.out.println("中根遍历二叉树：");
        strtree.inorder();
        System.out.println("后根遍历二叉树：");
        strtree.postorder();
        strtree.insert(strtree.root.left, true,"X");//插入x结点作为B结点的左孩子
        System.out.println("插入x后先根表示的二叉树为：");
        strtree.preorder();
        strtree.insert("Z");//插入z作为根节点
        System.out.println("z作为跟结点后的二叉树的先根表示");
        strtree.preorder();
    }
}
