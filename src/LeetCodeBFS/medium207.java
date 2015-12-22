package LeetCodeBFS;

import java.util.*;

/**
 * Created by luoshalin on 12/21/15.
 */

// 实质上是判断directed graph是否成环
// 很好的参考:http://www.cnblogs.com/grandyang/p/4484571.html

public class medium207 {
    public static void main(String[] args){
        // test goes here
        int numCourses = 3;
        int pre[][] = {{2, 0}, {2, 1}};

        System.out.print(canFinish(numCourses, pre));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=1 || prerequisites==null || prerequisites.length<=1)
            return true;

        // initialization
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();    // store graph
        int in[] = new int[numCourses];     // store in-degree
        for(int i=0; i<numCourses; i++){
            graph.put(i, new HashSet<Integer>());
            in[i] = 0;
        }

        // build graph and in-degree arr
        for (int i=0; i<prerequisites.length; i++){
            if(!graph.get(prerequisites[i][0]).contains(prerequisites[i][1])){      // only add edges which has not appeared before
                in[prerequisites[i][1]]++;
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
        }

        // save all zero-in-degree nodes to q
        LinkedList<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<in.length; i++){
            if(in[i]==0){
                q.add(i);
            }
        }

        // poll zero-in-degree nodes from q one by one; find their outer nodes & (in-degree)--; if is new zero-in-degree-node add to q
        while(!q.isEmpty()){
            int cur = q.poll();
            HashSet<Integer> set = graph.get(cur);
            for(int outNode : set){
                in[outNode]--;
                if(in[outNode]==0){
                    q.add(outNode);
                }
            }
        }

        // now: q isEmpty; all zero-in-degree nodes in DAG are processed
        for(int degree : in){
            if(degree!=0)
                return false;
        }
        return true;
    }
}

///*****Directed Gragph loop judgement*****/
//store graph in map<int, set<int>> (store outer nodes in set)
//store in-degree in arr in[]
//
//// save one level of node to be deleted
//for each node i:
//    if in[i] = 0:
//        put node to q
//    end if
//end for
//// find all outer nodes of in-degree=0 nodes && in-degree -- && add next level of in-degree=0 nodes to q
//while(q ! empty)
//    poll [i] from q
//    for each outer node of [i]:
//        in[i]--
//        if in[i]=0:
//            add to q
//        end if
//    end for
//end while
//// final judgement
//if any elem of in[]!=0:
//    there is a loop, return false
//end if

