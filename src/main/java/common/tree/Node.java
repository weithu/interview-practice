package common.tree;

public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val){
        this.val = val;
        left = null;
        right = null;
    }

    public static int getHeight(Node tree){
        if(tree == null) return -1;

        int leftHeight = getHeight(tree.left);
        int rightHeight = getHeight(tree.right);

        return 1 + Integer.max(leftHeight, rightHeight);
    }
}
