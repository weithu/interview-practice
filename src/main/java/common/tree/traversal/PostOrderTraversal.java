package common.tree.traversal;

import common.tree.Node;

/**
 * left, right, root
 */
public class PostOrderTraversal implements  TreeTraversal{

    @Override
    public void traverse(Node tree) {
        if(tree != null){
            System.out.print("\nPost Order:");
            postOrderTraversal(tree);
        }
    }

    private void postOrderTraversal(Node node){
        if(node != null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.val);
        }
    }
}
