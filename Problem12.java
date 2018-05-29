package leetcode;

public class Problem12 {
    public String intToRoman(int num) {
        String value = String.valueOf(num);
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i <  value.length(); i++) {
            int current = value.charAt(i) - '0';
            builder.append(getNumber(current, value.length() -1 - i));
        }
        return builder.toString();
    }

    public char romanCharToInt(int c) {
        char returnChar ='0';
        if(c == 1) returnChar = 'I';
        else if(c == 5) returnChar ='V';
        else if(c == 10) returnChar = 'X';
        else if(c == 50) returnChar = 'L';
        else if(c == 100) returnChar = 'C';
        else if(c == 500) returnChar = 'C';
        else if(c == 1000)returnChar = 'M';
        return returnChar;
    }
    public String getNumber(int number, int index) {
        StringBuilder builder = new StringBuilder();
        if(number == 0){

        } else if(number == 4) {
            builder.append(romanCharToInt((int)Math.pow(10 , index)));
            builder.append(romanCharToInt((int)Math.pow(10 , index) * 5 ));
        } else if (number == 5) {
            builder.append(romanCharToInt((int)Math.pow(10 , index) * number ));
        } else if(number == 9){
            builder.append(romanCharToInt((int)Math.pow(10 , index)));
            builder.append(romanCharToInt((int)Math.pow(10 , index+1)));
        } else if(number > 5){
            int diff = number - 5;
            builder.append(romanCharToInt( (int)Math.pow(10 , index) * 5 ));
            while( diff > 0 ) {
                builder.append(romanCharToInt((int)Math.pow(10 , index)));
                diff --;
            }
        } else {
            int diff = number;
            while( diff > 0 ) {
                builder.append(romanCharToInt((int)Math.pow(10 , index)));
                diff --;
            }
        }
        return builder.toString();
    }
}
