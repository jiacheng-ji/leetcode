package algo.jiacheng.KthLargestInArray;

/**
 * LeetCode 215 https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class Solution {

  public int findKthLargest(int[] nums, int k) {
    int lo = 0, hi = nums.length - 1;
    while (true) {
      int pos = partition(nums, lo, hi);
      if (pos == k - 1) {
        return nums[pos];
      } else if (pos < k - 1) {
        lo = pos + 1;
      } else {
        hi = pos - 1;
      }
    }
  }

  int partition(int[] nums, int lo, int hi) {
    int pivot = nums[hi];
    int pos = lo;
    for (int i = lo; i <= hi; ++i) {
      if (nums[i] > pivot) {
        swap(nums, i, pos++);
      }
    }
    swap(nums, pos, hi);
    return pos;
  }

  void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }
}
