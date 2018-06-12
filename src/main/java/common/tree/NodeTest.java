package common.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeTest {
    @Test
    public void testHeight_Balanced(){
        /**
         *           1
         *         /    \
         *        2      3
         *      /  \    /  \
         *     4    5  6    7
         */
        Node tree = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3 );

        tree.left = node2;
        tree.right = node3;

        node2.left = new Node(4);
        node2.right = new Node(5);

        node3.left = new Node(6);
        node3.right = new Node(7);

        assertEquals(Node.getHeight(tree), 2);
    }

    @Test
    public void testHeight_Unbalanced(){
        /**
         *           1
         *         /    \
         *        2      3
         *      /  \    /  \
         *     4    5  6    7
         *    / \
         *   8   9
         */
        Node tree = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3 );
        Node node4 = new Node(4);

        tree.left = node2;
        tree.right = node3;

        node2.left = node4;
        node2.right = new Node(5);

        node3.left = new Node(6);
        node3.right = new Node(7);

        node4.left = new Node(8);
        node4.right = new Node(9);

        assertEquals(Node.getHeight(tree), 3);
    }

    @Test
    public void testHeight_UnbalancedRight(){
        Node tree = new Node(1);
        tree.right = new Node(3);
        assertEquals(Node.getHeight(tree), 1);
    }
}
