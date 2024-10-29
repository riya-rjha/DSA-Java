package BinaryTrees;

import java.util.*;
import static BinaryTrees.TreeNodeUtil.TreeNode;

public class Cousins {

    static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int childCount = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int parentCount = 0;
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (node.left.val == x || node.left.val == y) {
                        parentCount++;
                        childCount++;
                    }
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    if (node.right.val == x || node.right.val == y) {
                        parentCount++;
                        childCount++;
                    }
                    queue.offer(node.right);
                }
                if (parentCount == 2) {
                    return false;
                }
            }
            if (childCount == 2) {
                return true;
            }
            if (childCount == 1) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int x = 4, y = 3;
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        // printBinaryTree(root);
        System.out.println(isCousins(root, x, y));
    }
}
