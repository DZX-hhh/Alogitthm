package 力扣.周赛.Game277;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class T3 {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> res = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1 && !map.containsKey(key - 1) && !map.containsKey(key + 1)) {
                res.add(key);
            }
        }
        return res;
    }
}
