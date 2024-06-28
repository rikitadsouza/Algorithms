//Compute minimum cost spanning tree using Kruskal’s algorithm:
import java.util.*;
public class Kruskal {
// Find function to determine the parent of a vertex
int find(int v, int[] parent) {
while (parent[v] != v)
v = parent[v];
return v;
}
// Union function to merge two sets
void union(int i, int j, int[] parent) {
if (i < j)
parent[j] = i;
else
parent[i] = j;
}
// Kruskal's algorithm to find the minimum spanning tree
void kruskal(int n, int[][] cost) {
int[] parent = new int[10];
int[][] t = new int[10][20];
int k = 0, count = 0, mincost = 0;
int i, j, min = 0, u = 0, v = 0;
// Initialize parent array
for (i = 1; i <= n; i++)
parent[i] = i;
while (count < n) {
min = 999;
// Find the minimum cost edge
for (i = 1; i <= n; i++) {
for (j = 1; j <= n; j++) {
if (cost[i][j] < min && cost[i][j] != 0) {
min = cost[i][j];
u = i;
v = j;
}
}
}
// If no minimum edge is found, break the loop
if (min == 999)
break;

i = find(u, parent);
j = find(v, parent);
// If the edge does not form a cycle, add it to the minimum spanning tree
if (i != j) {
t[k][0] = u;
t[k][1] = v;
mincost += min;
count++;
k++;
union(i, j, parent);
}
// Mark the edge as visited
cost[u][v] = cost[v][u] = 999;
}
if (count == n - 1) {
System.out.println("Cost of the spanning tree: " + mincost);
System.out.println("Edges of the spanning tree:");
for (i = 0; i < n - 2; i++)
System.out.println(t[i][0] + "," + t[i][1]);
} else {
System.out.println("Spanning tree doesn't exist.");
}
}
public static void main(String[] args) {
int[][] cost = new int[10][10];
int n, i, j;
Kruskal k = new Kruskal();
Scanner sc = new Scanner(System.in);
System.out.println("Enter the number of nodes:");
n = sc.nextInt();
System.out.println("Enter the cost matrix:");
for (i = 1; i <= n; i++) {
for (j = 1; j <= n; j++) {
cost[i][j] = sc.nextInt();
}
}
// Call Kruskal's algorithm
k.kruskal(n, cost);
}
}