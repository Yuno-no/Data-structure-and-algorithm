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
    }


}
