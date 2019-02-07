package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem43 {

    public static void main(String[] args ){
        Problem43 solution = new Problem43();
        solution.solve();
    }

    public void solve(){
        System.out.println(multiply("6913259244", "71103343"));
    }

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        List<Integer> reverse = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        int index = 0;
        for(int i = num2.length()-1; i >=0; i--) {
            int currentNum2 = (num2.charAt(i) - '0');
            int excess = 0;
            int k = index;
            for(int j = num1.length() - 1; j >=0; j--) {
                int currentNum1 = (num1.charAt(j) - '0');
                int tmp = ((currentNum1 * currentNum2 ) + excess)%10;
                if(reverse.size() > k){
                    excess = ((currentNum1 * currentNum2) + excess + reverse.get(k)) / 10;
                    reverse.set(k, (reverse.get(k)+tmp)%10);
                }
                else {
                    reverse.add(tmp);
                    excess = ((currentNum1 * currentNum2) + excess) / 10;
                }
                k++;
            }
            while(excess > 0 ) {
                reverse.add(excess%10);
                excess /=10;
            }
            index++;
        }

        for(int i = reverse.size()-1; i>=0; i--) {
            result.append(reverse.get(i));
        }
        return result.toString();
    }
}
