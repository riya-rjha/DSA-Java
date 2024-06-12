# DSA-JAVA-100

## Sub-array Sum division by K (Medium)

If an array is given, we need to find all contiguous sub arrays whose values when combined is divisible by K completely. 

### Brute force

For this take a count variable & a sum variable & run 2 loops where the second loop starts from the same index as that of first. Continue adding the value of that array to sum & if sum is divisible by k, increment count.

## Check for heights (Easy)

Create an expected array for heights of students stored in nums & find out the number when the expected height does not match the actual height. The expected height is in a non-decreasing order.

### Solution

Sort the array & store it in the expected array. Compare the values & increment count. 

## Relative Sort Array (Easy)

### Brute force

Create a hashmap which holds every value and the number of times it occurred in the array. Create an arraylist and append all the numbers in it in the same order as that of second array. Create a second arraylist for the remaining numbers of first array and add both the arraylists using Collections method. At last store the values in an array & return.

TC - O(n^2)

### Optimized Soln 

Create a counting array which stores the number of times each element occurs in the array1. Further, if the element of array2 in the respective order is iterated to add it in the arrayList until the value of countingArray does not become equal to zero. Furthermore, the remaining elements are added in the arrayList in ascending order by iterating upto the largest value of array, such that all elements that come across do so in an ascending order. At last, the arrayList is returned as an array. 

TC - O(n)

## Sort Colors (Medium)

Given an array, sort it in-place. Used counting sort for better time complexity & ease. 