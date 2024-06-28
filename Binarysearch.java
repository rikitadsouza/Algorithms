//Search a key element in an array of n elements using binary search algorithm.
import java.util.*;
class Binarysearch {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.println("Enter the array size:");
int n = sc.nextInt();
int[] a;
a = new int[n];
System.out.println("Enter the elements:");
for (int i = 0; i < n; i++)
a[i] = sc.nextInt();
System.out.println("Enter the key:");
int key = sc.nextInt();
int low = 0;
int high = n - 1;
int flag = 0;
int mid = 0;
// Binary search algorithm
while (low <= high) {
mid = (low + high) / 2;
if (key == a[mid]) {
flag = 1; // Key found
break;
} else if (key < a[mid])
high = mid - 1; // Adjust high pointer
else
low = mid + 1; // Adjust low pointer
}
// Output the result
if (flag == 1)
System.out.println("Key found at index " + mid);
else
System.out.println("Key not found");
}

}