package leetcode;

class Problem1291 {
    String numbers = "123456789";
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList();
        int start = String.valueOf(low).length();
        int end = String.valueOf(high).length();
        int startIndex = String.valueOf(low).charAt(0) - '0' - 1;
        for(int i = start; i <=  end; i++) {
            dfs(list, i, startIndex, low, high);
            startIndex = 0;
        }
        return list;
    }
    
    void dfs(List<Integer> result, int length, int startIndex, int low, int high) {
        if(startIndex + length > numbers.length()) return;
        int number = Integer.valueOf(numbers.substring(startIndex, startIndex + length));
        if(number > high) return;
        if(number >= low) result.add(number);
        dfs(result, length, startIndex + 1, low, high);
    }
}
