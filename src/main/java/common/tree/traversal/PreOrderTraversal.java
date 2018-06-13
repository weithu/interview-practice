package common.tree.traversal;

import common.tree.Node;

/**
 * Root, left, right
 */
public class PreOrderTraversal implements TreeTraversal{
    @Override
    public void traverse(Node tree) {
        if(tree != null){
            System.out.print("\nPre Order:");
            preOrderTraversal(tree);
        }
    }

    private void preOrderTraversal(Node node) {
        if(node != null){
            System.out.print(node.val);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
}
