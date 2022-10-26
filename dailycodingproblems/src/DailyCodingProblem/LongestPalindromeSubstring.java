package DailyCodingProblem;

public class LongestPalindromeSubstring {
	
	int startIndex;
    int subStringlen;
	
	
	
	
	
	private String solveProblemGreedy(String s) {
	      if(s.length() < 2)
	      {
	         return s; 
	      }
	      int len =  s.length();
	      int mid = 0;
	      
	      for(int start =0 ; start < s.length()-1 ; start++)
	      {
	          expandRange(s,start, start);
	          expandRange(s,start, start+1);
	      }
	         
	      return s.substring(startIndex,subStringlen+startIndex);
	    }
	    
	    private void expandRange(String s,  int start , int end)
	    {
	        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) // checking the out of bound 
	        {
	           start--;
	           end++;
	        }
	      
	        if(subStringlen < end -start -1)
	        {
	           startIndex = start+1;
	           subStringlen = end -start -1;
	        }
	       
	    }
	public static void main(String[] args)
	{
		String input = "";
		String output;
		output = new  LongestPalindromeSubstring().solveProblemGreedy(input);
	
		System.out.println();
	}

}
