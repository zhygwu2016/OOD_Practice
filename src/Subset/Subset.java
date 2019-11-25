package Subset;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FLK on 8/10/18.
 */
public class Subset {

    public List<List<Integer>> subSet(int[] nums){
        final List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return result;

        int level = 0;
        final List<Integer> list = new ArrayList<Integer>();

        fetchSubset(level,list,result,nums);

        return result;
    }

    private void fetchSubset(int level, List<Integer> list, List<List<Integer>> result,int[] nums){
        if(level == nums.length) return;

        for(int i = level; i < nums.length; i++){
            list.add(nums[i]);
            result.add(new ArrayList<Integer>(list));
            fetchSubset(i + 1, list,result,nums);
            list.remove(list.size() - 1);
        }

        return;
    }
}
