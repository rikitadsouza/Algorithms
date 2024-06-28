import java.util.*;
// Define a class named "Subset"
public class Subset {
// Method to find subsets
void subset(int n, int d, int w[]) {
int k = 1, flag = 0, sum = 0, i, check = 0;
int[] x = new int[10];
x[1] = 1;
// Initialize x[i] for i > 1 to 0
for (i = 2; i <= n; i++)
x[i] = 0;
// Loop to generate subsets
while (true) {
if (k <= n && x[k] == 1) {
if (sum + w[k] == d) {
if (check == 0) {
System.out.println("The possible subsets are");
check = 1;
}
System.out.print("{");
for (i = 1; i <= n; i++)
if (x[i] == 1)
System.out.print(w[i] + " ");
System.out.println("}");
flag = 1;
x[k] = 0;
} else if (sum + w[k] < d)
sum += w[k];
else
x[k] = 0;
} else {
k--;
while (k > 0 && x[k] == 0)
k--;
if (k == 0)
break;

x[k] = 0;
sum -= w[k];
}
k += 1;
x[k] = 1;
}
if (flag == 0)
System.out.println("No possible subsets");
}
// Main method
public static void main(String[] args) {
int[] w = new int[20];
int i, n, d;
Subset s = new Subset();
Scanner sc = new Scanner(System.in);
// Input number of elements
System.out.println("Enter the number of elements");
n = sc.nextInt();
// Input elements in increasing order
System.out.println("Enter the elements in increasing order:");
for (i = 1; i <= n; i++)
w[i] = sc.nextInt();
// Input integer
System.out.println("Enter the integer:");
d = sc.nextInt();
// Call the subset method to find and display subsets
s.subset(n, d, w);
}
}