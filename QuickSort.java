//Sort a list of n elements using quick sort algorithm.Analyze its efficiency.
import java.util.*;
public class QuickSort {
// Method to partition the array and return the pivot index
int partition(int[] a, int low, int high) {
int p, i, j, temp;
p = a[low]; // Choose the first element as the pivot
i = low + 1; // Set the left pointer
j = high; // Set the right pointer
while (low < high) {
// Find the element greater than pivot from the left side
while (a[i] <= p && i < high)
i++;
// Find the element smaller than pivot from the right side
while (a[j] > p)
j--;
if (i < j) {
// Swap the elements at i and j
temp = a[i];
a[i] = a[j];
a[j] = temp;
} else {
// Swap the pivot with the element at j and return the pivot index
temp = a[low];
a[low] = a[j];
a[j] = temp;
return j;
}
}
return j;
}
// Method to perform quicksort
void qsort(int[] a, int low, int high) {
if (low < high) {
int s = partition(a, low, high); // Partition the array
qsort(a, low, s - 1); // Recursively sort the left subarray
qsort(a, s + 1, high); // Recursively sort the right subarray
}
}

public static void main(String[] args) {
int[] a;
int i;
System.out.println("Enter the array size:");
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
a = new int[n];
Random generator = new Random();
// Generate random numbers and fill the array
for (i = 0; i < n; i++)
a[i] = generator.nextInt(5100);
System.out.println("Array before sorting:");
for (i = 0; i < n; i++)
System.out.println(a[i]);
Quicksort m = new Quicksort();
long startTime = System.currentTimeMillis();
m.qsort(a, 0, n - 1); // Sort the array using quicksort
long stopTime = System.currentTimeMillis();
System.out.println("Array after sorting:");
for (i = 0; i < n; i++)
System.out.println(a[i]);
long elapsedTime = (stopTime - startTime);
System.out.println("Time taken to sort array is: " + elapsedTime + " milliseconds");
}
