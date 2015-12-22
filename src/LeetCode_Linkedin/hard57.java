package LeetCode_Linkedin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoshalin on 12/15/15.
 */
public class hard57 {
    public static void main(String[] args) {
        // test goes here
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = intervals;
        if(intervals==null || intervals.size()==0){
            res.add(newInterval);
            return res;
        }
        else if(newInterval == null)
            return res;

        boolean mergeFlag = false;
        for(int i=0; i<intervals.size(); i++){
            Interval interval = intervals.get(i);
            // if overlapped, merge
            if(((interval.start-newInterval.end)*(interval.end-newInterval.end) <= 0) || ((newInterval.start-interval.end)*(newInterval.end-interval.end) <= 0)){
                mergeFlag = true;
                Interval mergedInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
                res.set(i, mergedInterval);
                newInterval = mergedInterval;
            }
            // if not overlapped
            else {
                if(mergeFlag)
                    break;
                else{
                    if(interval.end<newInterval.start){
                        res.add(i+1, newInterval);
                    }
                    else if(interval.start>newInterval.end){
                        res.add(i, newInterval);
                    }
                }
            }
        }
//        if(!mergeFlag){
//            res.add(newInterval);
//        }
        return res;
    }

    // helpers
    public class Interval {
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
}


//# special & corner
//intervals=null || newInterval=null => return intervals
//newInterval invalid? start>=end => X
//intervals len=1? => X
//concatenate? [1, 2] & [2, 3] => ?
//have to maintain the order?
//
//# thought
//res = intervals
//if no overlap: => // TODO: judgement
//    res = intervals.add(newInterval)
//    return res
//if overlap:
//    overlap 1 => merge 2    // TODO
//    overlap multiple => merge several   // TODO
//    add merged & non affected intervals to res
//    return res
//end
//
//judgement: merge 2 at a time, iterate intervals merge until end
//    newInterval & intervals[i]:
//        new.s < [i].e || [i].s<new.e
//            in res: replace (new & [i]) with (merged: [min(new.s, [i].s) : max(new.e, [i].e)])
//
//
//# solution
//res = intervals
//mergeFlag = false
//for(each interval : intervals):
//    if interval X newInterval:
//        mergeFlag = true
//        merge(interval, newInterval) => replace[interval&newInterval] with mergedInterval
//        newInterval = mergedInterval
//    if interval !X newInterval:
//        if mergeFlag:       // there wont be overlap later
//            break
//        else
//            continue
//end for
//if !mergeFlag:  // no overlaps
//    res.add(newInterval)
//end if
//
//return res
