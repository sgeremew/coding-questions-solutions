import java.util.*;
public class LevelOrderTraversal{

/*
    public class BinaryTreeNode {
        public int data;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        // below data members used only for some of the problems
        public BinaryTreeNode next;
        public BinaryTreeNode parent;
        public int count;

        public BinaryTreeNode(int d) {
            data = d;
            left = null;
            right = null;
            next = null;
            parent = null;
            count = 0;
        }
    }
*/


    /*


    q1 [ ]
    q2 [ ]

          12
          / \
        11   14
        /    / \
       8   11  20

    result = "12 : 11, 14 : 8, 11, 20"

    q1 [12] root
    deque q1 and queue q2 until q1 is empty
    q1 [ ]
    q2 [12]
    print q2 nodes and queue children to q1 and deque q2 until q2 is empty
    q1 [ 11, 14]
    q2 [ ]
    result = "12 : "
    REPEAT ------------------------
    q1 [11, 14]
    deque q1 and queue q2 until q1 is empty
    q1 [ ]
    q2 [11, 14]
    print q2 nodes and queue children to q1 and deque q2 until q2 is empty
    q1 [ 8, 11, 20]
    q2 [ ]
    result = "12 : 11, 14 : "

    */



    public static String levelOrderTraversal(BinaryTreeNode root) {
        if (root == null) return  "None";

        Queue<BinaryTreeNode> level = new LinkedList<>();
        BinaryTreeNode node = root;

        level.offer(node.left);
        level.offer(node.right);

        return "";
  }
}