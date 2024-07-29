public class smallestLetterGreater {

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        boolean isAscending = true;
        if(target >= letters[end]){
            return letters[start];
        }
        if (letters[start] > letters[end]) {
            isAscending = false;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isAscending) {
                if (target >= letters[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target <= letters[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return letters[start];
    }

    public static void main(String[] args) {
        // char[] letters = { 'e','e','g','g' };
        char[] letters = { 'c', 'f', 'g' };
        char target = 'c';
        System.out.println(nextGreatestLetter(letters, target));
    }
}
