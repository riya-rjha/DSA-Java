import java.util.*;

public class SecondLargestNo {

    // 2 Methods - Brute Force -> Find largest element in array then check if each
    // element of array is not equal to the largest element and compare with every
    // successive second largest element

    public int print3largest(List<Integer> arr) {
        // Code Here
        int largest = Integer.MIN_VALUE;
        int secondLargest = -1;
        for (int i = 0; i < arr.size(); i++) {
            largest = Math.max(largest, arr.get(i));
        }
        for (int i = 0; i < arr.size(); i++) {
            if (secondLargest < arr.get(i) && arr.get(i) != largest) {
                secondLargest = arr.get(i);
            }
        }
        return secondLargest;
    }

    // Optimized - If the current element is largest, then the element which was
    // largest before it will be the second largest element. Thus, for every largest
    // element you update also update the second largest element. And the corner
    // case would be that if any element occurs that is not the largest element but
    // is still greater than the secondLargest element, then sepcify a condition for
    // the same and update only second largest element in that case.

    public int print2largest(List<Integer> arr) {
        int largest = arr.get(0);
        int sec = -1;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > largest) {
                sec = largest;
                largest = arr.get(i);
            }
            if (arr.get(i) < largest && arr.get(i) > sec) {
                sec = arr.get(i);
            }
        }
        return sec;
    }

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        SecondLargestNo num1 = new SecondLargestNo();
        SecondLargestNo num2 = new SecondLargestNo();
        lst.add(12);
        lst.add(35);
        lst.add(1);
        lst.add(10);
        lst.add(34);
        lst.add(1);
        System.out.println("Optimal Algo: " + num1.print2largest(lst));
        System.out.println("Brute Force: " + num2.print3largest(lst));
    }
}
