#include<iostream>
#include<limits.h>
using namespace std;
 
int c = 0;
int cost = INT_MAX;
 
// adjacency matrix of graph
 
int graph[4][4] = { {0 ,10, 15, 20 },
{10, 0, 35, 25},
{15, 35, 0, 30},
{20, 25, 30, 0}};
 
void swap (int *x, int *y)
{
int temp;
temp = *x;
*x = *y;
*y = temp;
}
 
void calculate_cost (int *vertex, int n)
{
int i, sum = 0;
for (i = 0; i <= n; i++) {
sum += graph[vertex[i % 4]][vertex[(i + 1) % 4]];
}
if (cost > sum)
{
cost = sum;
}
}
 
void permute (int *vertex, int i, int n)
{
int j, k;
if (i == n)
{
calculate_cost (vertex, n);
}
else
{
for (j = i; j <= n; j++)
{
swap ((vertex + i), (vertex + j));
permute (vertex, i + 1, n);
swap ((vertex + i), (vertex + j)); // backtrack
}
}
}
 
int main ()
{
int i, j;
int vertex[] = { 0, 1, 2, 3 };
permute (vertex, 0, 3);
cout <<"minimum cost:"<<cost<<endl;
}