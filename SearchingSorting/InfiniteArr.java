public class InfiniteArr {

    public int getIndexInInfiniteArr(int target, int nums[]) {
        int start = 0;
        int end = 1;
        while (target > nums[end]) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return helperFunction(nums, target, start, end);
    }

    public int helperFunction(int nums[], int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        InfiniteArr ans = new InfiniteArr();
        int[] arr = { 3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170 };
        int target = 10;
        System.out.println(ans.getIndexInInfiniteArr(target, arr)); // If array has a limited size, this function will throw an index out of bounds error
    }

}
