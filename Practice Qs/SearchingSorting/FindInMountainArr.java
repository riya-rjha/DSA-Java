public class FindInMountainArr {

    // MountainArray.get(k) returns the element of the array at index k (0-indexed).
    // MountainArray.length() returns the length of the array.

    interface MountainArray {
        public int get(int index);

        public int length();
    }

    static class MountainArrMethods implements MountainArray {
        private final int[] arr;

        public MountainArrMethods(int arr[]) {
            this.arr = arr;
        }

        public int get(int idx) {
            return arr[idx];
        }

        public int length() {
            return arr.length;
        }
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        return 1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 3, 1 };
        int target = 3;
        MountainArrMethods mnArr = new MountainArrMethods(arr);
        System.out.println(findInMountainArray(target, mnArr));
    }
}
