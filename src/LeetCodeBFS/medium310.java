package LeetCodeBFS;

import java.util.*;

/**
 * Created by luoshalin on 12/21/15.
 */

// 这题不太好过!
// 参考:http://www.cnblogs.com/grandyang/p/5000291.html  => 用数组存map,空间超了
// 改进:http://www.mamicode.com/info-detail-1154453.html => 用hashmap存map

public class medium310 {
    public static void main(String[] args){
        // test goes here
        int edges[][] = {{1, 0}, {0, 2}};
        System.out.print(findMinHeightTrees(3, edges));
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if(n==0 || edges==null || edges.length==0 || n==1){
            res.add(0);
            return res;
        }
        if(n==2){
            res.add(0);
            res.add(1);
            return res;
        }

        // n>=3
        Map<Integer, Set<Integer>> graph = new HashMap<>();      // map to represent graph
        int in[] = new int[n];            // arr to record in count for each node
        Arrays.fill(in, 0);
        LinkedList<Integer> leafQueue = new LinkedList<Integer>();

        // initialize g[][] & in[]
        for(int i=0; i<n; i++){
            graph.put(i, new HashSet<Integer>());
        }
        for(int i=0; i<edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            in[edges[i][0]]++;
            in[edges[i][1]]++;
        }
        // initialize q
        for(int i=0; i<in.length; i++){
            if(in[i]==1){   //leaf node
                // add to queue
                leafQueue.add(i);
            }
        }

        int notLeafCount = n;   // the number of nodes which have not been transformed to leaf
        int size = leafQueue.size();
        int processedLeaf = 0;
        while (processedLeaf + size != n){  // CAUTION: THE STOP JUDGEMENT
            // process current level
            for(int i=0; i<size; i++){
                // poll one current level leaf from the queue
                int curLeaf = leafQueue.poll();
                processedLeaf++;
                // for all nodes connected to this node, in--
                Set<Integer> connectedSet = graph.get(curLeaf);
                for(int connectedNode : connectedSet){
                    in[connectedNode]--;
                    // if updated node in-degree==1, this node is a new leaf -> add to leafQueue
                    if(in[connectedNode]==1){
                        leafQueue.add(connectedNode);
                    }
                }
            }
            size = leafQueue.size();        // update the leaf number for current level
        }
        while (!leafQueue.isEmpty()){
            res.add(leafQueue.poll());
        }
        return res;
    }
}

//create g[len][len]
//create in[len]      // in counts for each node
//for each inCount : in:
//    if inCount=1:
//        push to q
//end for
//leafCount = 0
//while(len-leafCount>2):     // the num for undeleted nodes in the graph
//    leaf = q.pop
//    leafCount++      // deleted leaves
//    for each n connected to leaf:
//        in--
//        if in==1:
//            push n to q
//        end if
//    end for
//end while
//res = q.popAll
