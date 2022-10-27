package Graph;

public class NumberOfIslands {

	 final char SEEN = '2'; 
	 final  char LAND = '1'; 
	 final  char WATER = '0'; 
	
	 
	public static void main(String[] args)
	{
		char[][] grid = {{'1','1','1','1','0'},
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','0','0'}};
		int output;
		output = new  NumberOfIslands().solveProblemGreedy(grid);
		output = new  NumberOfIslands().solveProblemDP(grid);
		System.out.println(output);
	}
	
	
	
	public int solveProblemGreedy(char[][] grid) {
	    int num = 0;
	    for(int r = 0 ;r< grid.length;r++)
	    {
	        for(int c = 0 ;c< grid[0].length;c++)
	        {
	        	//If the current element is land, check if it is left most corner
	            if(grid[r][c] == LAND)
	            {  
	              if((r==0 || grid[r-1][c] == '0') && (c==0 || grid[r][c-1] == '0'))
	                num++;
	            }
	            
	        }
	      }
	       return num;
	    }
	
	public int solveProblemDP(char[][] grid) {
	    int num = 0;
	    for(int r = 0 ;r< grid.length;r++)
	    {
	        for(int c = 0 ;c< grid[0].length;c++)
	        {
	            if(grid[r][c] == LAND)
	            {  
	              countIslands(grid,r,c); 
	              num++;
	            }
	        }
	      }
	       return num;
	    }
	    
	    
	    public void countIslands(char[][] grid, int r, int c)
	    {
	        
	        if(r<0 || r>=grid.length || c <0 || c>=grid[0].length)
	        {
	            return;
	        }
	        if(grid[r][c] == SEEN || grid[r][c] == WATER)//already Visited or water
	        {
	            return;
	        }
	            grid[r][c] = SEEN; //marked it as visited
	            countIslands(grid,r+1,c); //up
	            countIslands(grid,r-1,c); //down
	            countIslands(grid,r,c+1); //right
	            countIslands(grid,r,c-1); //left
	    }
}
