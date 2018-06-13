package common.tree.traversal;

import common.tree.Node;

/**
 * 1. traverse left subtree
 * 2. visit root
 * 3. traverse right subtree
 */
public class InOrderTraversal implements TreeTraversal {

    @Override
    public void traverse(Node tree) {
        System.out.print("\nIn Order:");
        inOrderTraversal(tree);
    }

    private void inOrderTraversal(Node node){
        if(node != null){
            inOrderTraversal(node.left);
            System.out.print(node.val);
            inOrderTraversal(node.right);
        }
    }
}
