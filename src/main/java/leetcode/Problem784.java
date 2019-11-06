package leetcode;

class Problem784 {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList();
        generate(S.toCharArray(), result, 0);
        return result;
    }
    
    void generate(char[] array, List<String> result, int index) {
        if(index == array.length) {
            result.add(new String(array));
        } else {
            array[index] = Character.toLowerCase(array[index]);
            generate(array, result, index +1);
            if(array[index] >='a' && array[index] <= 'z') {
                array[index] = Character.toUpperCase(array[index]);
                generate(array, result, index +1);
            }
        }
    }
}
