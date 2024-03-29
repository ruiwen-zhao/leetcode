package main;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        String sol = "";
        backtrack(4, s, sol, res);
        return res;
    }
	
	static void backtrack(int seg, String sub, String sol, List<String> res) {
		
		if(seg == 1 && (sub.length() > 3 || Integer.valueOf(sub) > 255))
			return;
		
		if(seg == 1 && sub.charAt(0) == '0' && sub.length() > 1)
			return;
		
		if(seg == 1 && Integer.valueOf(sub) <= 255) {
			sol = sol + sub;
			res.add(new String(sol));
			return;
		}
		
		
		for(int i = 1 ; i < sub.length() && i <= 3; i++) {
			String tempSol = sol;
			String tempSub = sub;
			if(Integer.valueOf(sub.substring(0, i)) > 255)
				break;
			sol = sol + sub.substring(0, i) + ".";
			seg--;
			sub = sub.substring(i);
			backtrack(seg, sub, sol, res);
			seg++;
			sol = tempSol;
			sub = tempSub;
			if(sub.charAt(i-1) == '0' && i == 1)
				break;

		}
		
	}
	
	public static void main(String[] args) {
		List<String> res = restoreIpAddresses("010010");
		for(String string : res)
			System.out.println(string);
		
	}
}
