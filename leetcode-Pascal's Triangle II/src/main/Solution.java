package main;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<Integer> getRow(int rowIndex) {
		rowIndex++;
        List<Integer> res = new ArrayList<Integer>();
        
        if(rowIndex == 0)
        	return res;
        
        res.add(1);
        
        
        
        for(int i = 2; i <= rowIndex; i++ ) {
        	for(int j = i-1; j >= 1; j-- ) {
        		if(j == i-1) {
        			res.add(1);
        		}
        		else {
        			res.set(j, res.get(j) + res.get(j-1));
        		}
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.print(getRow(5));
	}
}
