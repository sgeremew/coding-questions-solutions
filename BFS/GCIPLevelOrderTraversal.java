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

    // 24m 49s 5/16/2023

    public static String levelOrderTraversal(BinaryTreeNode root) {
        if (root == null) return  "null";

        Queue<BinaryTreeNode> current = new LinkedList<>();
        Queue<BinaryTreeNode> next = new LinkedList<>();
        BinaryTreeNode node = root;

        String result = "";
        current.offer(node);

        while(!current.isEmpty()) {
            // traverse the queue
            int length = current.size();
            for(int i = 0; i < length; i++) {
                BinaryTreeNode temp = current.poll();

                // queue the children
                if (temp.left != null) next.offer(temp.left);
                if (temp.right != null) next.offer(temp.right);

                // build the result
                result += temp.data;

                if(current.isEmpty() && !next.isEmpty()) {
                     result += " : ";
                } else if (!current.isEmpty()) {
                    result += ", ";
                }
            }
            System.out.println(result);

            current.addAll(next);
            next.clear();
        }

        return result;
  }

// version 2: optimized space - we know how big each level is since we store
// all of the children
  public static String levelOrderTraversal(BinaryTreeNode root) {
    if (root == null) return  "null";

    Queue<BinaryTreeNode> current = new LinkedList<>();
    BinaryTreeNode node = root;

    String result = "";
    current.offer(node);

    while(!current.isEmpty()) {
        // traverse the queue
        int length = current.size();
        for(int i = 0; i < length; i++) {
            BinaryTreeNode temp = current.poll();

            // queue the children
            if (temp.left != null) current.offer(temp.left);
            if (temp.right != null) current.offer(temp.right);

            // build the result
            result += temp.data;

            if(i == length - 1 && !current.isEmpty()) {
                 result += " : ";
            } else if (i != length - 1) {
                result += ", ";
            }
        }
        System.out.println(result);
    }

    return result;
  }
}











