package leetcode;

public class Problem7 {
    public static void main(String[]args) {
        Problem7 solution = new Problem7();
        int result = solution.reverse(-123);
        System.out.println(result);
    }
    public int reverse(int x) {
        String value = String.valueOf(x);
        boolean isNegative = false;
        if(value.charAt(0) == '-') isNegative = true;
        int index = value.length()-1;
        StringBuilder stringBuilder = new StringBuilder();
        if(isNegative)stringBuilder.append("-");
        while(index >=0){
            if(index == 0 && isNegative) {
                index --;
                continue;
            }
            stringBuilder.append(value.charAt(index));
            index --;
        }
        int result =0;
         try {
             result = Integer.parseInt(stringBuilder.toString());
         } catch (Exception ex) {

         }
        return result;
    }
}
