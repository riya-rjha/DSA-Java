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

## Minimum number of moves to seat everyone (Easy)

Given two arrays of students & seats where in you are supposed to change the positions of the students by moving the place of student through minimum moves such that it is placed in the nearest position of the number present in seats array. The idea to solve this is to just simply sort both the arrays and find the absolute difference of each index of both arrays such that we may find the minimum required moves to shift the position to the nearest place of the student in the seat.

## Minimum Increment to make array unique (Medium)

Calculate the minimum number of moves required to make the array unique. If the previous number is same as the current number, increment the current number by 1.

### Solution

Sort the array first for ease & start the iteration from first index. Check for every element if the previous element is either equal to or greater than the current element. If yes then calculate the number of moves that will be required to atleast make the current element greater than the previous one. Then replace the current element by incrementing the previous element by 1.

## IPO - Initial Public Offering (Hard)

Leetcode is going to start it's IPO and has to sell it's shares at the maximum capital to get the maximum profit. It is supposed to sell atmost 'k' projects & has an initial capital 'w'. Given an array of profits & capitals. Using the initial capital 'w', one can buy capital with maximum profit. Return the maximized final profit.

### Solution

Follow the steps to get the correct answer: 

1. Create a class Project with two instances - capital & profit.
2. Create an arrayList and add for every member two values, profit[i] & capital[i].
3. Sort the list in ascending order according to the capital such that we can find the minimum possible value according to the initial capital amount - w.
4. Create a Priority Queue & by default Java defines the priority queue as a minHeap. Use comparator to reverse the minHeap, thus converting it into a maxHeap.
5. Check for every iteration upto k(atmost projects) if current capital is less than or equal to w, then add the profit in the maxHeap.
6. If heap turns out to be empty, break from the loop otherwise continue adding the profit stored in the maxHeap by polling it and add to w.