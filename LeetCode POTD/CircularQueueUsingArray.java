public class CircularQueueUsingArray {

    static class Queue {
        int[] queue;
        int front = -1;
        int rear = -1;

        Queue(int n) {
            queue = new int[n];
        }

        public boolean isFull() {
            if ((rear + 1) % queue.length == front) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            if (rear == -1 && front == -1) {
                return true;
            }
            return false;
        }

        public void enqueue(int n) {
            if (isFull()) {
                System.out.println("Queue is already full");
                return;
            }
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % queue.length;
            }
            queue[rear] = n;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            if (rear == 0 && front == 0) {
                int delNum = queue[front];
                rear = front = -1;
                return delNum;
            }
            int delNum = queue[front];
            front = (front + 1) % queue.length;
            return delNum;
        }

        public void displayQueue() {
            for (int i = front; i <= rear; i++) {
                System.out.println(queue[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(37);
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(31);
        queue.enqueue(22);
        queue.dequeue();
        queue.enqueue(38);
        queue.displayQueue();
    }
}
