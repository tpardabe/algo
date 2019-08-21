package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem509 {
    Map<Integer, Integer> map = new HashMap() {{
        put(0, 0);
        put(1, 1);
    }};
    public int fib(int N) {
        if(map.containsKey(N)) return map.get(N);
        map.put(N, fib(N - 1) + fib(N - 2));
        return map.get(N);
    }
}
