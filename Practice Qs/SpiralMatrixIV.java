import java.util.Arrays;

public class SpiralMatrixIV {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] spiral = new int[m][n];
        int sr = 0, er = m - 1, sc = 0, ec = n - 1;

        ListNode temp = head;

        while (sr <= er && sc <= ec) {
            for (int i = sc; i <= ec; i++) {
                if (temp != null) {
                    spiral[sr][i] = temp.val;
                    temp = temp.next;
                } else {
                    spiral[sr][i] = -1;
                }
            }
            sr++;

            for (int i = sr; i <= er; i++) {
                if (temp != null) {
                    spiral[i][ec] = temp.val;
                    temp = temp.next;
                } else {
                    spiral[i][ec] = -1;
                }
            }
            ec--;

            if (sr <= er) {
                for (int i = ec; i >= sc; i--) {
                    if (temp != null) {
                        spiral[er][i] = temp.val;
                        temp = temp.next;
                    } else {
                        spiral[er][i] = -1;
                    }
                }
                er--;
            }

            if (sc <= ec) {
                for (int i = er; i >= sr; i--) {
                    if (temp != null) {
                        spiral[i][sc] = temp.val;
                        temp = temp.next;
                    } else {
                        spiral[i][sc] = -1;
                    }
                }
                sc++;
            }
        }

        return spiral;
    }

    public ListNode createList(int[] values) {
        if (values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 5;
        int[] values = { 3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0 };
        SpiralMatrixIV ans = new SpiralMatrixIV();
        ListNode head = ans.createList(values);
        System.out.println(Arrays.deepToString(ans.spiralMatrix(m, n, head)));

    }
}
