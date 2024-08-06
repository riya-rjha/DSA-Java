import java.util.Scanner;

public class GunMaster {

    public static int gunM(int n, int d, int arr[]){
        String curr = "long";
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>d && curr.equals("close")){
                curr = "long";
                s++;
            }
            else if(arr[i]<=d && curr.equals("long")){
                curr = "close";
                s++;
            }
        }
        return s;

    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t != 0) {
                int n = sc.nextInt();
                int D = sc.nextInt();
                int arr[] = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                System.out.println(gunM(n, D, arr));
                t--;
            }
        }
    }
}
