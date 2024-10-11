public class DequeUsingCircularArr {

    private static final int size = 100;
    private static int[] deque = new int[size];
    private static int front = -1;
    private static int rear = -1;

    private boolean isFull() {
        return (rear + 1) % size == front;
    }

    private boolean isEmpty() {
        return front == -1;
    }

    private void addFront(int x) {
        if (!isFull()) {
            if (front == -1) {
                front = rear = 0;
                deque[front] = x;
            } else {
                if (front == 0) {
                    front = size - 1;
                } else {
                    front--;
                }
                deque[front] = x;
            }
        }
    }

    private void addRear(int x) {
        if (!isFull()) {
            if (rear == -1) {
                front = rear = 0;
                deque[rear] = x;
            } else {
                rear = (rear + 1) % size;
                deque[rear] = x;
            }
        }
    }

    private int removeFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        int result = deque[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return result;
    }

    private int removeRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        int result = deque[rear];
        if (front == rear) {
            front = rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }
        return result;
    }

    private int getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        return deque[front];
    }

    private int getRear() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        return deque[rear];
    }

    public static void main(String[] args) {
        DequeUsingCircularArr deque = new DequeUsingCircularArr();
        deque.addRear(1);
        deque.addRear(2);
        deque.addFront(0);
        System.out.println(deque.getFront()); // Output: 0
        System.out.println(deque.getRear()); // Output: 2
        deque.removeFront();
        System.out.println(deque.getFront()); // Output: 1
        deque.removeRear();
        System.out.println(deque.getRear()); // Output: 1
    }
}
