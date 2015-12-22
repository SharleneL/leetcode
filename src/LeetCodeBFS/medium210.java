package LeetCodeBFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by luoshalin on 12/21/15.
 */

// 实质上是给一个directed graph, 如果里面没有环则输出它的拓扑排序
// 注意从queue里面pop出来是逆序的,先用一个栈存,再倒到output arr里

public class medium210 {

    public static void main(String[] args){
        // test goes here
        int numCourses = 2;
        int pre[][] = {{0, 1}, {1, 0}};

        int res[] = findOrder(numCourses, pre);
        for(int num : res)
            System.out.println(num);
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        Stack<Integer> resStack = new Stack<Integer>();

        if(numCourses==0){
            return res;
        }

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
            --numCourses;
            resStack.push(cur);
            HashSet<Integer> set = graph.get(cur);
            for(int outNode : set){
                in[outNode]--;
                if(in[outNode]==0){
                    q.add(outNode);
                }
            }
        }

        for(int i=0; i<res.length; i++){
            if(!resStack.isEmpty())
                res[i] = resStack.pop();
        }
        return numCourses == 0 ? res : new int[0];
    }
}
