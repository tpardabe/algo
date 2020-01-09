package leetcode;

class Problem860 {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[3];
        for( int bill: bills) {
            int ret = bill - 5;
            if(ret >=10 && money[1] > 0) {
                money[1]--;
                ret -=10;
            }
            while(ret > 0) {
                if(money[0] == 0) return false;
                money[0]--;
                ret -= 5;
            }
            if(bill == 5) money[0]++;
            else if(bill == 10) money[1]++;
            else money[2]++;
            
        }
        return true;
    }
