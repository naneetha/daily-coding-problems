package DailyCodingProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {

	private boolean isAnagram(String str1, String str2)
	{
		//edge case
		if(str1 == null || str1.length() == 0)
		{
			return false;
		}
		if(str2 == null || str2.length() == 0)
		{
			return false;
		}
		if(str1.length() != str2.length())
		{
			return false;
		}
		
		// increment the frequency of the character from first string
		// decrement the frequency of the matching character from second string
		Map<Character, Integer> freq =  new HashMap<>();
		for(int i = 0; i < str1.length();i++){
			
			freq.put(str1.charAt(i), freq.getOrDefault(str1.charAt(i),0)+1);
			freq.put(str2.charAt(i), freq.getOrDefault(str2.charAt(i),0)-1);
		}
		
		// if the frequency of both string matches then all values in hashmap become zero
		for(int val:freq.values())
		{
			if(val != 0)
			return false;	
			
		}
		return true;
		
	}
	
	private List<Character> findMissingLetter(String str1, String str2)
	{
		
		//edge case
		if(str1 == null || str1.length() == 0)
		{
			return null;
		}
		if(str2 == null || str2.length() == 0)
		{
			return null;
		}

		// increment the frequency of the character from first string
		// decrement the frequency of the matching character from second string
		Map<Character, Integer> freq =  new HashMap<>();
		for(int i = 0; i < str1.length();i++){
			
			freq.put(str1.charAt(i), freq.getOrDefault(str1.charAt(i),0)+1);
			
		}
		for(int i = 0; i < str2.length();i++){
			
			freq.put(str2.charAt(i), freq.getOrDefault(str2.charAt(i),0)-1);
		}
		
		// if the frequency of both string matches then all values in hashmap become zero
		List<Character> missingLetters =  new ArrayList<>();
		for(Character key:freq.keySet())
		{
			if(freq.get(key) != 0)
				missingLetters.add(key);
		}
		return missingLetters;
		
	}
	
	public static void main(String[] args) {
		//System.out.println( new Anagram().isAnagram("cat", "act"));
		System.out.println( new Anagram().findMissingLetter("cate", "act"));
		
	}
}
