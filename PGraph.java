//Demonstrate minimum cost spanning tree using Prim’s algorithm

import java.util.Arrays;
import java.util.Scanner;
class PGraph {
public void Prim(int G[][], int V) {
int INF = 999; // Constant representing infinity
int edges = 0; // Counter for edges in the minimum spanning tree
int mincost = 0; // Total cost of the minimum spanning tree
boolean[] Selected = new boolean[V]; // Array to keep track of selected vertices
Arrays.fill(Selected, false); // Initially, no vertices are selected
Selected[0] = true; // Select the first vertex
System.out.println("Edges:Weight"); // Print heading for edge output
// Loop until we have V-1 edges in the minimum spanning tree
while (edges < V - 1) {
int min = INF; // Initialize the minimum weight to infinity
int x = 0; // Variable to store the selected vertex with minimum weight
int y = 0; // Variable to store the adjacent vertex
// Iterate over all selected vertices
for (int i = 0; i < V; i++) {
if (Selected[i] == true) {
// Iterate over all vertices
for (int j = 0; j < V; j++) {
// Check if vertex j is unselected and there is an edge between i and j
if (!Selected[j] && G[i][j] != 0) {
// Update the minimum weight and vertices if a smaller weight is found
if (min > G[i][j]) {
min = G[i][j];
x = i;
y = j;
}
}
}
}
}
// If x and y are different, add the edge to the minimum spanning tree
if (x != y) {
System.out.println(x + "-" + y + ":" + G[x][y]);
Selected[y] = true; // Select the adjacent vertex
mincost += G[x][y]; // Update the total cost
edges++; // Increment the edge counter
} else {
break; // No more edges to add, exit the loop

}
}
// Check if the minimum spanning tree is formed
if (edges != V - 1) {
System.out.println("Minimum cost of spanning tree can't be obtained");
} else {
System.out.println("Minimum cost spanning tree is obtained, and the cost is " + mincost);
}
}
public static void main(String[] args) {
PGraph p = new PGraph();
Scanner sc = new Scanner(System.in);
System.out.println("Enter the number of vertices");
int n = sc.nextInt();
System.out.println("Enter the weight matrix");
int[][] graph = new int[n][n];
// Read the weight matrix from user input
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
graph[i][j] = sc.nextInt();
}
}
p.Prim(graph, n); // Call the Prim's algorithm to find the minimum spanning tree
}
}