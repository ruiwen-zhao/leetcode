package main;

public class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
        int curStart = 0;
        int curLen = 0;
        int i;
        for(i = curStart; i < words.length; i++) {
        	curLen += words[i].length();
        	if(curLen + i - curStart > maxWidth)
        		break;
        }
        
        i--;
        
    }
}