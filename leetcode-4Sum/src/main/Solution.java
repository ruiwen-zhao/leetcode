package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
	public static List<List<Integer>> fourSum(int[] num, int target) {
        //Create the dictionary.
        HashMap<Integer, ArrayList<ArrayList<Integer>>> dict = new HashMap<>();
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                ArrayList<Integer> pair = new ArrayList<>(2);
                pair.add(i);
                pair.add(j);
                if (!dict.containsKey(sum)) {
                    ArrayList<ArrayList<Integer>> value = new ArrayList<>();
                    value.add(pair);
                    dict.put(sum, value);
                } else {
                    ArrayList<ArrayList<Integer>> value = dict.get(sum);
                    value.add(pair);
                }
            }
        }
        //Use HashSet to prevent duplicate result.
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (Integer sum : dict.keySet()) {
            ArrayList<ArrayList<Integer>> sumPair = dict.get(sum);
            if (dict.containsKey(target - sum)) {
                if (target - sum == sum && sumPair.size() == 1)
                    continue;
                ArrayList<ArrayList<Integer>> pairs = dict.get(target - sum);
                for (ArrayList<Integer> pair1 : sumPair) {
                    for (ArrayList<Integer> pair2 : pairs) {
                        //Make sure it is not the same pair.
                        if (pair1 == pair2)
                            continue;
                        //Make sure there is no same element in two pairs.
                        if (pair1.contains(pair2.get(0)) || pair1.contains(pair2.get(1)))
                            continue;
                        ArrayList<Integer> tmpResult = new ArrayList<>(4);
                        tmpResult.add(num[pair1.get(0)]);
                        tmpResult.add(num[pair1.get(1)]);
                        tmpResult.add(num[pair2.get(0)]);
                        tmpResult.add(num[pair2.get(1)]);
                        //Sort the list and add it into the set.
                        Collections.sort(tmpResult);
                        set.add(tmpResult);
                    }
                }
            }
        }
        List<List<Integer>> ret = new LinkedList<>();
        ret.addAll(set);
        return ret;
    }
	
	public static void main(String[] args) {
		int nums[] = {1,0,-1,0,-2,2};
		System.out.println(fourSum(nums, 0));
	}
}
