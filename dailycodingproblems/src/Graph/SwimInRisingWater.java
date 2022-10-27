package Graph;

import java.util.PriorityQueue;

/**
 * Problem Statement : 778: https://leetcode.com/problems/swim-in-rising-water/
 * @author anee
 * You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

The rain starts to fall. At time t, the depth of the water everywhere is t. 
You can swim from a square to another 4-directionally adjacent square if and only 
if the elevation of both squares individually are at most t. 
You can swim infinite distances in zero time. Of course, 
you must stay within the boundaries of the grid during your swim.

Return the least time until you can reach the bottom right square (n - 1, n - 1) 
if you start at the top left square (0, 0)
 */
public class SwimInRisingWater {

	/**
	 * 1.Use Union Find (Kruskal's Algorithms- Greedy Method)
	 * 2.Use Binary Search and DFS 
	 * 3.Use BFS and Priority Queue (min heap) (Djistra's Algorithm - Greedy Method)
	 * 4.Use BFS/DFS with Tree Set
	 */
	
	
	/**
	 * Solve this problem using Djistra's Algorithm - BFS with Priority Queue (min Heap)
	 * 
	 * Time Complexity O(n2 log k)
	 * Space Complexity O(n2) -to track vistied index 
	 * @return
	 */
	public static int  solveUsingGreedyAlgo(int[][] grid)
	{
		int n = grid.length;
		// visitied array
		boolean[][] vistied =  new boolean[n][n];
		// going to store [0] -> r row index , [1] -> c column index,[2] -> time value
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[2]-b[2]);
		
		minHeap.add(new int[] {0,0,grid[0][0]});
		vistied[0][0] = true;
		
		//to navigate 4 directional
		int[][] directions =  {{-1,0},{1,0},{0,-1},{0,1}};
		
		
		while(!minHeap.isEmpty())
		{
			int[] p= minHeap.poll();
			for(int[] d:directions)
			{
				int r = p[0]+d[0];
				int c = p[1]+d[1];
				// check for array out of bound index
				if(r<0 || r >= n || c <0 || c >=n)
				{
					continue;
				}
				// check not visited index
				if(!vistied[r][c])
				{
					
					vistied[r][c] =  true;
					int time = Math.max(p[2], grid[r][c]);
					minHeap.add(new int[] {r,c,time});
					// reached end of last vertex
					if(r== (n-1) && c == (n-1))
					{
						return time;
					}
				}
			}
			
		}
		return 0;
	}
	
	/**
	 * Solve this problem using Djistra's Algorithm - BFS with Priority Queue (min Heap)
	 * 
	 * Time Complexity O(n2 log k)
	 * Space Complexity O(n2) -to track vistied index 
	 * @return
	 */
	public static int  solveUsingDFSandBinarySearch(int[][] grid)
	{
		 int N = grid.length;
	        int lo = 0, hi = N * N - 1;
	        while (lo < hi) {
	            int mi = lo + (hi - lo) >> 1; // Bit Manipulation for division by 2
	            boolean[][] visit = new boolean[N][N];
	            //System.out.println("low = "+lo);
	            //System.out.println("high = "+hi);
	            //System.out.println("Mid = "+mi);
	            if (reachBottom(grid, mi, N, visit, 0, 0)) hi = mi;
	            else lo = mi + 1;
	        }
	        return lo;
	}
	
	private static boolean reachBottom(int[][] grid, int t, int N, boolean[][] visit, int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= N || visit[i][j] || grid[i][j] > t) return false;
        visit[i][j] = true;
        if (i == N - 1 && j == N - 1) return true;
        else return reachBottom(grid, t, N, visit, i + 1, j) || reachBottom(grid, t, N, visit, i - 1, j) || reachBottom(grid, t, N, visit, i, j - 1) || reachBottom(grid, t, N, visit, i, j + 1);
    }
	/**
	 * Brute Force
	 * @return
	 */
	public static int  simpleImplementation(int[][] grid)
	{
		return 0;
	}
	
	
	public static void main(String[] args) {
		System.out.println(solveUsingDFSandBinarySearch(new int[][]{{0,1,3},{2,4,1},{1,2,1}}));
	}
}
