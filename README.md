# IUS_C202_PA6
Programming Assignment 6 from Dr. H's 202 class

## Abstract


The problem here is described as follows: Given a list of cities and the cost to traverse between each city, where one can traverse from any city to anyother city, find the most cost efficient route to visit each city once. This problem is commonly known as the [traveling salesman problem](https://en.wikipedia.org/wiki/Travelling_salesman_problem.). In this specific assignment, the aim is to use commonly known as a [Dijkstra Approximation](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm). An algorithm that finds the shortest path between nodes (cities in this case) by traveling to the closest node one is currently at each step. In effect, it ignores the overall cost of the journey and only takes into account the current leg of the trip. It can, and often does, miss the absolute most cost-efficient path through a graph; however, it is a brilliantly simple method and gets very close to the true shortest path. As oppesed to a depth-first-search ( O(N!) ), this algorithm has a time complexity of O(N^2) if each elements closest city is at the end of its row in the adjacency matrix (worst case).

In this implementation, the data for the cost/distance between nodes is represented in a two dimensional adjacency matrix. Value[x, y] on the matrix represents the distance from x -> y. The program retireves the information from text files and populates the matrix once at runtime and that is the only time the entire matrix is addressed iteratively. 



## Outputs
12 city matrix  
0 -> 5 -> 3 -> 8 -> 4 -> 1 -> 11 -> 6 -> 7 -> 10 -> 9 -> 2  
Cost: 715  

13 city matrix  
0 -> 5 -> 3 -> 8 -> 4 -> 1 -> 11 -> 6 -> 7 -> 10 -> 9 -> 2 -> 12  
Cost: 804  

14 city matrix  
0 -> 5 -> 3 -> 8 -> 4 -> 1 -> 13 -> 11 -> 6 -> 7 -> 10 -> 9 -> 2 -> 12  
Cost: 900  

15 city matrix  
0 -> 5 -> 3 -> 8 -> 4 -> 1 -> 13 -> 14 -> 12 -> 2 -> 9 -> 10 -> 7 -> 6 -> 11  
Cost: 840  

16 city matrix  
0 -> 5 -> 11 -> 8 -> 4 -> 1 -> 9 -> 3 -> 14 -> 13 -> 10 -> 15 -> 12 -> 7 -> 6 -> 2  
Cost: 1418  

19 city matrix  
0 -> 5 -> 11 -> 8 -> 4 -> 1 -> 9 -> 3 -> 14 -> 18 -> 15 -> 12 -> 7 -> 6 -> 10 -> 13 -> 17 -> 16 -> 2  
Cost: 1455  

29 city matrix  
0 -> 27 -> 5 -> 11 -> 8 -> 4 -> 20 -> 1 -> 19 -> 9 -> 3 -> 14 -> 18 -> 24 -> 6 -> 22 -> 26 -> 23 -> 7 -> 15 -> 12 -> 17 -> 13 -> 21 -> 16 -> 10 -> 28 -> 25 -> 2  
Cost: 1800
