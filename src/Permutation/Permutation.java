package Permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FLK on 8/14/18.
 */
public class Permutation {

//    public List<List<Integer>> permute(int[] nums){
//        final List<List<Integer>> result = new ArrayList<List<Integer>>();
//
//        if(nums == null || nums.length ==0 ) return result;
//
//        fetchPermu(0,result,nums);
//
//        return result;
//    }
//
//    private void fetchPermu(int index, List<List<Integer>> result, int[] nums){
//        if(index == nums.length){
//            final List<Integer> list = new ArrayList<Integer>();
//            for(int i : nums){
//                list.add(i);
//            }
//            result.add(list);
//            return;
//        }
//
//        for(int i = index; i < nums.length; i++){
//            swap(i,index,nums);
//            fetchPermu(index + 1, result, nums);
//            swap(i,index,nums);
//        }
//    }
//
//    private void swap(int i, int j, int[] nums){
//        final int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<Integer>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<Integer>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
