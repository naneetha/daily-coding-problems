package DailyCodingProblem;

import java.util.HashMap;
import java.util.Map;

public class SampleTrie {

	private TrieNode trieNode;
	SampleTrie()
	{
		trieNode =  new TrieNode();
	}
	
	// Insert word
	public void insert(String word)
	{
		char[] chars =  word.toCharArray();
		for(char c : chars)
		{
			if(trieNode !=null && trieNode.getChildren() != null)
			{
				// insert chars in to node
				if(trieNode.getChildren().get(c) == null )
				{
					trieNode.getChildren().put(c,new TrieNode())  ;
					trieNode = trieNode.getChildren().get(c);
				}
				
			}
		}
		if(trieNode != null)
		trieNode.isEnd = true;
	}
	// search for prefix match (starts with) (auto Complete)
	
	// search for enitre word
	public boolean search(String word)
	{
		char[] chars =  word.toCharArray();
		for(char c : chars)
		{
			if(trieNode !=null && trieNode.getChildren()!=null)
			{
				if(trieNode.getChildren().get(c) != null && !trieNode.isEnd)
				{
					trieNode = trieNode.getChildren().get(c);
				}
				else
					return false;
			}
			
		}
		return true;
	}
}

class TrieNode {

	Map<Character, TrieNode> children ;
	boolean isEnd;
	/**
	 * Ideal Data structure to storing a dictionary
	 * 
	 * Uses :  prefix based search , sort the string lexographically
	 * 
	 * Pros : HT cannot do prefix  based search and  takes more space than Trie
	 */
	
	public TrieNode()
	{
		
		// to store character and next node
		children =  new HashMap<>();
		//boolean to find the end of the word
		isEnd = false;
	}
	
	public Map<Character, TrieNode> getChildren()
	{
		return children;
	}
	public boolean isEnd()
	{
		return isEnd;
	}
}