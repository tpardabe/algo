package leetcode;


class Problem448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList();
        Arrays.sort(nums);
        int i = 0;
        int k = 1;
        while(k <= nums.length) {
            if(i < nums.length && nums[i] < k) {
                i++;
            } else {
                if( (i < nums.length && nums[i] > k) || (i >= nums.length)) list.add(k);
                k++;
            }
        }
        return list;
    }
}
