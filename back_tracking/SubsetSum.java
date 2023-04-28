import java.util.*;
public class SubsetSum{
    public static int[][] subsets(int[] nums, int target) {
        List<int[]> resultList = new ArrayList<>();
        backtrack(nums, target, 0, new int[nums.length], 0, resultList);
        int[][] result = new int[resultList.size()][];
        resultList.toArray(result);
        return result;
    }
    
    static void backtrack(int[] nums, int target, int start, int[] path, int pathIndex, List<int[]> result) {
        if (target < 0) {
            return;
        } 
        else if (target == 0) {
            int[] subset = new int[pathIndex];
            System.arraycopy(path, 0, subset, 0, pathIndex);
            result.add(subset);
        } 
        else {
            for (int i = start; i < nums.length; i++) {
                path[pathIndex] = nums[i];
                backtrack(nums, target - nums[i], i, path, pathIndex + 1, result);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 3;
        int[][] result = subsets(nums, target);
        for (int[] subset : result) {
            System.out.println(Arrays.toString(subset));
        }
    }
}
