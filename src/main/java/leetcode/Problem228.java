package leetcode;


class Problem228 {
    public List<String> summaryRanges(int[] nums) {
        int l  = 0;
        int r = 0;
        List<String> list = new ArrayList();
        if(nums.length == 0) return list;
        int prev = nums[0];
        while(l <= r && r < nums.length) {
            if(r == l) {
                r++;
                prev = nums[l];
            } else if(nums[r] == prev + 1) {
                prev = nums[r++];
            }  else {
                add(list, l, r - 1, nums);
                l = r;
            }
        }
        add(list, l, nums.length -1, nums);
        return list;
    }
    
    void add(List<String> list, int l, int r, int[] nums) {
        StringBuilder builder = new StringBuilder();
        builder.append(nums[l]);
        if(l != r) {
            builder.append("->");
            builder.append(nums[r]);
        }
        list.add(builder.toString());
    }
}
