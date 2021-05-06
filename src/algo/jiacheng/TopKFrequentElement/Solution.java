package algo.jiacheng.TopKFrequentElement;

import java.util.*;

/**
 * LeetCode 347 https://leetcode.com/problems/top-k-frequent-elements/
 */
public class Solution {

  static class Item {

    public int id;
    public int cnt;

    public Item(int id, int cnt) {
      this.id = id;
      this.cnt = cnt;
    }
  }

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freqs = new HashMap<>();
    for (int n : nums) {
      freqs.put(n, freqs.getOrDefault(n, 0) + 1);
    }

    Item[] items = new Item[freqs.size()];
    int i = 0;
    for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
      items[i++] = new Item(entry.getKey(), entry.getValue());
    }

    qselect(items, k);

    int[] ans = new int[k];
    i = 0;
    while (i < k) {
      ans[i] = items[i++].id;
    }
    return ans;
  }

  void qselect(Item[] items, int k) {
    int lo = 0, hi = items.length - 1;

    while (true) { // given k <= items.length
      int pos = partition(items, lo, hi);
      if (pos == k - 1) {
        break;
      } else if (pos < k - 1) {
        lo = pos + 1;
      } else {
        hi = pos - 1;
      }
    }
  }

  int partition(Item[] items, int lo, int hi) {
    int pivot = items[hi].cnt;
    int pos = lo;
    for (int i = lo; i <= hi; ++i) {
      if (items[i].cnt > pivot) {
        swap(items, i, pos++);
      }
    }
    swap(items, hi, pos);
    return pos;
  }

  void swap(Item[] items, int i, int j) {
    Item tmp = items[i];
    items[i] = items[j];
    items[j] = tmp;
  }
}
