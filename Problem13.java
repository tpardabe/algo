package leetcode;

public class Problem13 {

    public int romanToInt(String s) {
        int number = 0;
        char previous = '1';
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            switch (current) {
                case 'V':
                    number += 5;
                    if(previous == 'I') number -= 2;
                    break;
                case 'X':
                    number += 10;
                    if(previous == 'I') number -= 2;
                    break;
                case 'L':
                    number += 50;
                    if(previous == 'X') number -= 20;
                    break;
                case 'C':
                    number += 100;
                    if(previous == 'X') number -= 20;
                    break;
                case 'D':
                    number += 500;
                    if(previous == 'C') number -= 200;
                    break;
                case 'M':
                    number += 1000;
                    if(previous == 'C') number -= 200;
                    break;
                default:
                    number += romanCharToInt(current);
                    break;

            }
            previous = current;
        }
        return number;

    }

    public int romanCharToInt(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X' : return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
