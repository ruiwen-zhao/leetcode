package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		if(s == null || s.length() == 0 || words == null || words.length == 0)
			return res;
		
		HashMap<String, Integer> wordTime = new HashMap<>();
		
		for(String word : words) {
			if(!wordTime.containsKey(word))
				wordTime.put(word, 1);
			else 
				wordTime.put(word, wordTime.get(word)+1);			
		}
	
		for(int i = 0 ; i < words[0].length(); i++) {
			HashMap<String, Integer> curMap = new HashMap<>();
			int left = i;
			int count = 0;
		
			for(int j = i ; j <= s.length() - words[0].length() ; j += words[0].length()) {
				String str = s.substring(j, j + words[0].length());
				
				if(wordTime.containsKey(str)) {
					if(curMap.containsKey(str))
						curMap.put(str, curMap.get(str)+1);
					else
						curMap.put(str, 1);
					
					if(curMap.get(str) <= wordTime.get(str))
						count++;
					
					else {
						while(curMap.get(str) > wordTime.get(str)) {
							String temp = s.substring(left, left + words[0].length());
							if(curMap.containsKey(temp)) {
								curMap.put(temp, curMap.get(temp)-1);
								if(curMap.get(temp) < wordTime.get(temp))
									count--;
							}
							left += words[0].length();
						}
					}
					
					if(count == words.length) {
						res.add(left);  
	                    
	                    String temp = s.substring(left,left+words[0].length());  
	                    if(curMap.containsKey(temp))  
	                        curMap.put(temp,curMap.get(temp)-1);  
	                    count--;  
	                    left += words[0].length();  
					}
				}
				
				else  
		           {  
		               curMap.clear();  
		               count = 0;  
		               left = j+words[0].length();  
		           }  

			}
		}
        return res;
    }
}
