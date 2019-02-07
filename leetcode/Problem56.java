import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals.size() < 2) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval interval, Interval t1) {
                return new Integer(interval.start).compareTo(new Integer(t1.start));
            }
        });
        int end = intervals.get(0).end;
        int start = intervals.get(0).start;
        for(int i =1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if(current.start <= end) {
                if(current.end > end) end = current.end;
            } else {
                result.add(new Interval(start, end));
                end = current.end;
                start = current.start;
            }
        }
        if(result.size() == 0 || result.get(result.size()-1).end != end) result.add(new Interval(start, end));

        return  result;
    }

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
}
