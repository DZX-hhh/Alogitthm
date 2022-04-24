package 力扣.周赛.华为;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class T1 {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> res = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] arr : nums) {
            for (int i : arr) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == nums.length) {
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;
    }
}


