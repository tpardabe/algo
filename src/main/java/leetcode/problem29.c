int divide(int dividend, int divisor) {
   int result = 2;
    int shift = 0;
    int isPositive = 1;
    int negMax = -2147483648;
    int posMax = 2147483647;
    if(dividend < 0 && divisor < 0) {
    	isPositive = 0;
    	if(dividend > divisor) return 0;
    } else if(dividend >= 0 && divisor >= 0){
		isPositive = 0;
        if(dividend < divisor) return 0;
    } else {
        if(dividend > 0) dividend= ~dividend +1;
        if(divisor > 0) divisor= ~divisor +1;
        if(dividend > divisor) return 0;
    }
	
   if(dividend < 0 || divisor < 0) {
        int tmp = divisor<<shift;
        while(divisor<<shift >= dividend && divisor<<shift <= tmp) {
            tmp = divisor<<shift;
            shift++;
        }
   } else {
        int tmp = divisor<<shift;
        while(divisor<<shift <= dividend && divisor<<shift >= tmp) {
            tmp = divisor<<shift;
            shift++;
        }
   }
    int diff = 0 ;
    if(shift > 1) {
    	shift -=2;
    	result = result<< shift;
    	diff = dividend - (divisor<<shift+1);
	} else {
		result = 1;
		diff = dividend - divisor;
	}
    result =  result + divide(diff, divisor);
    if(isPositive == 0  && negMax == result) result = posMax;
    return isPositive == 1 ? result *(-1) : result;
}
