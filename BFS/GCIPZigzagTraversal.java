import java.util.*;

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

// 21m 50s


public class ZigzagTraversal{
    public static List<List<Integer>> zigzagLevelOrder(BinaryTreeNode root) {
        // I think there is an empty java collections but I forgot the method name
        if (root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        List<Integer> levelNodes = new ArrayList<>();
        queue.add(root);

        int levelIndex = 0;
        while(!queue.isEmpty()) {
            int length = queue.size();

            for(int i = 0; i < length; i++) {
                BinaryTreeNode curr = queue.poll();

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);

                levelNodes.add(curr.data);
            }

            if(levelIndex % 2 != 0) {
              Collections.reverse(levelNodes);
            }
            result.add(new ArrayList<Integer>(levelNodes));
            levelNodes.clear();
            levelIndex++;
        }

        return result;
    }
}