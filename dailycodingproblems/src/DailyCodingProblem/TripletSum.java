package DailyCodingProblem;

import java.util.Arrays;

public class TripletSum {

	public static void soultion(int[] a, int target, int n)
	{
		Arrays.sort(a);
		for(int i=0; i< n ;i++)
		{
			if(i==0 || a[i] != a[i-1]) {
				int remTarget = target - a[i];
				int start = i+1;
				int end = n-1;
				while(start < end) {
					if(remTarget > a[start] + a[end]) {
						start++;
					}
					else if(remTarget < a[start] + a[end])
					{
						end--;
					}
					else
					{
						System.out.println(a[i] + "," + a[start] + "," + a[end]);
						
						while(start < end  && a[start] ==  a[start +1]) start++;
						while(start < end  && a[end] ==  a[end -1]) end--;
						start++; end--;
					}
				}
			}
			
		}
		
	}
	public static void main(String[] args) {
		
	}
}
