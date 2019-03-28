package leetcode;

public class Problem8 {
    public int myAtoi(String str) {
        int max = 2147483647;
        int min = -2147483648;
        int startIndex = 0;
        int result = 0;
        char sign = '0';
        boolean isValid = true;
        StringBuilder builder = new StringBuilder();
        for(int i = str.length()-1; i > 0 ; i --) {
            /*char current = str.charAt(i);
            if(current > 47 && current < 58) {
                int number = (int)Math.pow(10, currentPower)*(current - '0');
                result = result + number;
            }*/



            char current = str.charAt(i);
            if(current == ' ') continue;
            if(current == '+' || current == '-') {
                if(sign == '0') {
                    sign = current;
                    builder.append(current);
                }
                else isValid  = false;
            } else if(current > 47 && current < 58) {
                builder.append(current);
            } else return 0;//check if character???
        }
        return 0;
    }
}
