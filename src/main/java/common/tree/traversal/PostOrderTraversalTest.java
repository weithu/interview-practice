package common.tree.traversal;

import common.tree.Node;
import org.junit.Test;

/**
 *              1
 *            /   \
 *           2     3
 *         /  \   /  \
 *        4   5  6    7
 */
public class PostOrderTraversalTest {
    @Test
    public void exampleCaseTest(){
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        head.left = node2;
        head.right = node3;

        node2.left = new Node(4);
        node2.right = new Node(5);

        node3.left = new Node(6);
        node3.right = new Node(7);

        TreeTraversal traversal = new PostOrderTraversal();
        traversal.traverse(head);
    }
}
