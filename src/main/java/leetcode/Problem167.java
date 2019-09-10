package leetcode;

public class Problem167 {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        int[] result = new int[2];
        boolean found = false;
        while(!found) {
            if(numbers[index1] + numbers[index2] == target) found = true;
            else if(numbers[index1] + numbers[index2] > target) index2--;
            else index1++;
        }
        result[0] = index1;
        result[1] = index2;
        return result;
    }
}
