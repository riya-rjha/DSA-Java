import java.util.Scanner;

public class HashInRow {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- != 0) {
                int n = sc.nextInt();
                char arr[][] = new char[n][4];
                for (int i = 0; i < arr.length; i++) {
                    String temp = sc.next();
                    for (int j = 0; j < 4; j++) {
                        arr[i][j] = temp.charAt(j);
                    }
                }
                for (int i = arr.length - 1; i >= 0; i--) {
                    for (int j = 3; j >=0 ; j--) {
                        if(arr[i][j] == '#'){
                            System.out.print((j+1)+" ");
                        }
                    }
                }
            }
        }
    }
}
