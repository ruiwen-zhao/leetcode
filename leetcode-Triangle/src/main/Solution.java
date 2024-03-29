package main;

import java.util.List;

public class Solution {
	public static int minimumTotal(List<List<Integer>> triangle) {
		int arr[] = new int[triangle.size()];
		
		arr[0] = triangle.get(0).get(0);
		
		for(int i = 1 ; i < triangle.size(); i++) {
			for(int j = triangle.get(i).size()-1; j >= 0; j--) {
				if(j == triangle.get(i).size()-1) {
					arr[j] = triangle.get(i).get(j) + arr[j-1];
				}
				else if(j == 0) {
					arr[j] += triangle.get(i).get(j);
				}
				else {
					arr[j] = triangle.get(i).get(j) + (arr[j] < arr[j-1] ? arr[j] : arr[j-1]);
				}
					
			}
		}
		int min = arr[0];
		for(int i = 1 ; i < triangle.size(); i++) {
			if(arr[i] < min)
				min = arr[i];
		}
		return min;
    }
	
	
}
