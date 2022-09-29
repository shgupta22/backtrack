import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumWithSameElement {
        //Each element can used only once
    public static List<List<Integer>> combinationSumUnique(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }
    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int rem, int start) {
        if (rem < 0) return;
        else if (rem == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i =start; i < nums.length; i++) {
                if (i >start && nums[i] == nums[i-1]) continue;
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, rem-nums[i], i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(combinationSumUnique(new int[] {1,2,3,4}, 7));
    }
}
