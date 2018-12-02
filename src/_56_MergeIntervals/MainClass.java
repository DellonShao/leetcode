package _56_MergeIntervals;


import java.util.*;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start) return o1.start - o2.start;
                else if(o1.end != o2.end) return o1.end - o2.end;
                return 0;
            }
        });
        int s = intervals.get(0).start;
        int e = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); ++i){
            if(intervals.get(i).start > e){
                Interval tmp = new Interval(s, e);
                result.add(tmp);
                s = intervals.get(i).start;
                e = intervals.get(i).end;
            }else{
                if(e < intervals.get(i).end){
                    e = intervals.get(i).end;
                }
            }
        }
        return result;
    }
}

public class MainClass {
    Solution sol  = new Solution();
}
