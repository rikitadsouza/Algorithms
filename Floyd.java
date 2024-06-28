//Demonstrate Floyd’s algorithm solution for all pair shortest path problem.
import java.util.*;
// Floyd class to compute the shortest path using Floyd-Warshall algorithm
public class Floyd {
// Method to compute the shortest path using Floyd-Warshall algorithm
void flyd(int[][] w, int n) {
int i, j, k;
// The outermost loop runs for every vertex 'k'
for (k = 1; k <= n; k++) {
// The second loop iterates over all source vertices 'i'
for (i = 1; i <= n; i++) {
// The innermost loop iterates over all destination vertices 'j'
for (j = 1; j <= n; j++) {
// The shortest path from vertex 'i' to vertex 'j' is updated using vertex 'k'
// Math.min function is used to find the minimum of the existing distance and the
//distance via vertex 'k'
w[i][j] = Math.min(w[i][j], w[i][k] + w[k][j]);
}
}
}
}
// Main method where the program execution starts
public static void main(String[] args) {
// Declaration and initialization of variables
int a[][] = new int[10][10]; // Adjacency matrix for storing weights
int n, i, j; // 'n' represents the number of vertices, 'i' and 'j' are loop counters
// Input the number of vertices from the user
System.out.println("Enter the number of vertices");
Scanner sc = new Scanner(System.in);
n = sc.nextInt();
// Input the weight matrix from the user
System.out.println("Enter the weight matrix");
for (i = 1; i <= n; i++) {
for (j = 1; j <= n; j++) {
a[i][j] = sc.nextInt(); // Reading weights for each edge between vertices
}
}
// Creating an instance of the Floyd class
Floyd f = new Floyd();

// Calling the flyd method to compute the shortest paths
f.flyd(a, n);
// Displaying the shortest path matrix
System.out.println("The shortest path matrix is ");
for (i = 1; i <= n; i++) {
for (j = 1; j <= n; j++) {
System.out.print(a[i][j] + " "); // Printing the shortest distance from vertex 'i' to vertex 'j'
}
System.out.println();
}
}
}