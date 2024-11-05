public class CircularSentence {
    public static void main(String[] args) {
        String s = "Hi Riya my name is Harshit";
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            System.out.println(false);
        } else {
            String[] arr = s.split(" ");
            for (int i = 0; i < arr.length - 1; i++) {
                String word = arr[i];
                if(word.charAt(word.length() - 1 ) != arr[i+1].charAt(0)){
                    System.out.println(false);
                }
            }
        }
    }
}