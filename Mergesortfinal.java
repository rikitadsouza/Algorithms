//Merge Sort: To sort n randomly generated integers.
import java.util.*;
class Mergesortfinal {
void mergesort(int a[], int n) {
int b[] = new int[n / 2];
int c[] = new int[n / 2 + 1];
int j = 0, k = 0;
if (n > 1) {
for (int i = 0; i < n / 2; i++)
b[j++] = a[i];
for (int i = n / 2; i < n; i++)
c[k++] = a[i];
mergesort(b, j);
mergesort(c, k);
merge(b, c, a, j, k);
}
}
void merge(int b[], int c[], int a[], int p, int q) {
int i = 0, j = 0, k = 0;
while (i < p && j < q) {
if (b[i] <= c[j])
a[k++] = b[i++];
else
a[k++] = c[j++];
}
if (i == p)
for (; j < q; j++)
a[k++] = c[j];
else
for (; i < p; i++)
a[k++] = b[i];
}
public static void main(String[] args) {
int[] a, I;
System.out.println("Enter the array size:");
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
a = new int[n];
Random generator = new Random();

for (int i = 0; i < n; i++)
a[i] = generator.nextInt(10000);
System.out.println("Array before sorting:");
for (int i = 0; i < n; i++)
System.out.println(a[i]);
Mergesortfinal m = new Mergesortfinal();
long startTime = System.currentTimeMillis();
m.mergesort(a, n);
long stopTime = System.currentTimeMillis();
System.out.println("Array after sorting:");
for (int i = 0; i < n; i++)
System.out.println(a[i]);
long elapsedTime = (stopTime - startTime);
System.out.println("Time taken to sort array is: " + elapsedTime + " milliseconds");
}
}