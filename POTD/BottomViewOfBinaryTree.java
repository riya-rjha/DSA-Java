import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BottomViewOfBinaryTree {

    // Class for binary tree
    static class Node {
        int hzd;
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.hzd = Integer.MAX_VALUE;
            this.left = null;
            this.right = null;
        }

    }

    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        int min = 0;
        int max = 0;
        root.hzd = 0;

        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            hm.put(temp.hzd, temp.data);
            if (temp.left != null) {
                temp.left.hzd = temp.hzd - 1;
                queue.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.hzd = temp.hzd + 1;
                queue.add(temp.right);
            }
            min = Math.min(min, temp.hzd);
            max = Math.max(max, temp.hzd);
        }

        for (int i = min; i <= max; i++) {
            ans.add(hm.get(i));
        }

        return ans;
    }

    public static void printBinaryTree(Node root) {
        // Inorder Traversal
        if (root == null) {
            return;
        }
        printBinaryTree(root.left);
        System.out.print(root.data + " ");
        printBinaryTree(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.right.left.right = new Node(14);
        printBinaryTree(root);
        System.out.println();
        System.out.println(bottomView(root));
    }
}
