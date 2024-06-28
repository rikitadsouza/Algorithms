import java.util.*;
public class Dijkstras
{
// Function to perform Dijkstra's algorithm
static void dijkstras1(int n, int[][] cost, int src)
{
// Array to keep track of visited nodes
int[] visit = new int[n+1];
// Array to store the minimum distance from source to each node
int[] dist = new int[n+1];
int i, j, u = 0, w, min = 0;
// Initialize distance array with cost values from the source node
for (i = 0; i <= n; i++)
{
dist[i] = cost[src][i];
visit[i] = 0;
}
visit[src] = 1;
// Main loop to find shortest paths
for (i = 1; i <= n; i++)
{
min = 999;
// Find the unvisited node with minimum distance
for (j = 1; j <=n; j++)
{
if (dist[j] < min && visit[j] != 1)
{
min = dist[j];
u = j;
}
}
visit[u] = 1;
// Update distance array if a shorter path is found
for (w = 1; w <= n; w++)
{
if (dist[w] > dist[u] + cost[u][w] && visit[w] == 0)
dist[w] = dist[u] + cost[u][w];
}

}
// Display shortest distances from the source node
for (i = 1; i <=n; i++)
if (i != src)
System.out.println("Distance from " + src + " to " + i + " is: " + dist[i]);
}
// Main method to get input and call Dijkstra's function
public static void main(String[] args)
{
int i, j, n, src;
int[][] cost = new int[10][10];
Scanner sc = new Scanner(System.in);
Dijkstras d=new Dijkstras();
// Input number of nodes
System.out.println("Enter the number of nodes:");
n = sc.nextInt();
// Input cost matrix
System.out.println("Enter the cost matrix:");
for (i = 1; i <= n; i++)
for (j = 1; j <= n; j++)
cost[i][j] = sc.nextInt();
// Input source vertex
System.out.println("Enter the source vertex:");
src = sc.nextInt();
// Call the Dijkstra's function
dijkstras1(n, cost, src);
}
}