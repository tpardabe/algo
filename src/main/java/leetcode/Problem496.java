package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] copy = new int[nums1.length];
        Stack<Integer> stack = new Stack();
        Map<Integer, Integer>  map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
            copy[i] = -1;
        }
        for(int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                int val = stack.pop();
                if(map.containsKey(val))copy[map.get(val)] = nums2[i];
            }
            stack.push(nums2[i]);
        }
        return copy;
    }
}
