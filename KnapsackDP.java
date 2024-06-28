import java.util.*;
class KnapsackDP {
public void calculate(int[] wt, int[] val, int W, int n) {
int i, j;
// Create a 2D array to store the computed values
int[][] F = new int[n + 1][W + 1];
// Initializing the base cases
for (i = 0; i <= n; i++) {
for (j = 0; j <= W; j++) {
if (i == 0 || j == 0)
F[i][j] = 0; // Base case: no items or knapsack capacity is 0
else if (j < wt[i])
F[i][j] = F[i - 1][j]; // Knapsack capacity is less than current item's weight
else
F[i][j] = Math.max(F[i - 1][j], val[i] + F[i - 1][j - wt[i]]);
// Take the maximum of skipping the current item or including it
}
}
System.out.println("Optimal value=" + F[n][W]);
// Check if an optimal solution exists
if (F[n][W] == 0)
System.out.println("No optimal value subset");
else {
System.out.println("Optimal subset:");
// Reconstruct the optimal subset by backtracking through the array
for (i = n; i > 0 && W > 0; i--) {
if (F[i][W] != F[i - 1][W]) {
System.out.println("item" + i);
W = W - wt[i]; // Subtract the weight of the selected item
}
}
}
}

public static void main(String[] args) {
int i;
Scanner sc = new Scanner(System.in);
KnapsackDP ks = new KnapsackDP();
System.out.println("Enter the number of items");
int n = sc.nextInt();
int wt[] = new int[n + 1];
int val[] = new int[n + 1];
System.out.println("Enter the weight of " + n + " items");
for (i = 1; i <= n; i++)
wt[i] = sc.nextInt();
System.out.println("Enter the value of " + n + " items");
for (i = 1; i <= n; i++)
val[i] = sc.nextInt();
System.out.println("Enter the Knapsack capacity");
int W = sc.nextInt();
ks.calculate(wt, val, W, n);
}
}