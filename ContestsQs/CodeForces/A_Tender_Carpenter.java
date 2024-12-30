import java.util.*;

public class A_Tender_Carpenter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            List<Integer> newList = new ArrayList<>();
            int cnt = 1;
            int k = 2;
            while (cnt != 2) {
                for (int i = 0; i < arr.length; i += k) {
                    int curr = i;
                    k = k + i;
                    List<Integer> lst = new ArrayList<>();
                    while (curr != k) {
                        lst.add(arr[i]);
                        curr++;
                    }
                    for (int j = 0; j < lst.size(); j++) {
                        int itr = j;
                        newList = new ArrayList<>();
                        if (newList.size() >= 3) {
                            while (newList.size() != 3) {
                                newList.add(lst.get(j));
                            }
                        } else {
                            while (newList.size() != 3) {
                                if (itr == newList.size() - 1) {
                                    itr = 0;
                                }
                                newList.add(lst.get(itr));
                            }
                        }
                    }
                    int x = newList.get(0);
                    int y = newList.get(1);
                    int z = newList.get(2);
                    if (x + y > z) {
                        if (y + z > x) {
                            if (z + x > y) {
                                cnt++;
                            }
                        }
                    }
                    if(cnt == 2){
                        break;
                    }
                }
            }
            if (cnt == 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}