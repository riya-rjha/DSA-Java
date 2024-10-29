package BinaryTrees;

import java.util.*;

public class KthLargestSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static void printBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printBinaryTree(root.left);
        System.out.print(root.val + "->");
        printBinaryTree(root.right);
    }

    static long getKthVal(List<Long> lst, int k) {
        for (int i = 0; i < lst.size(); i++) {
            if (i + 1 == k) {
                return lst.get(i);
            }
        }
        return -1;
    }

    static long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Long> lst = new ArrayList<>();
        queue.offer(root);
        long levels = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            lst.add(sum);
            levels++;
        }
        if (k > levels) {
            return -1;
        }
        Collections.sort(lst, Collections.reverseOrder());
        System.out.println(lst);
        long ans = getKthVal(lst, k);
        return ans;
    }

    public static void main(String[] args) {
        // root = [5,8,9,2,1,3,7,4,6]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);

        int k = 2;
        System.out.println(kthLargestLevelSum(root, k));
    }
}
