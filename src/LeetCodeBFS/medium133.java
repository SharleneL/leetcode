package LeetCodeBFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by luoshalin on 12/22/15.
 */

// 这道其实还没有过
// 本质上是无向图的两种遍历:BFS和DFS,并维护visited set记录走过的点
// BFS:考虑什么是一层,每层存队列
// DFS:要么递归,要么用栈.当前节点处理完处理什么?处理它的所有neighbor.写递归函数第一考虑何时返回(所有neighbor都visited的时候)
public class medium133 {
    public static void main(String[] args) {
        // test goes here
    }

    // helper class
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    // method1 - BFS
    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if(node==null)
            return null;

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        HashSet<UndirectedGraphNode> visitedSet = new HashSet<UndirectedGraphNode>();

        LinkedList<UndirectedGraphNode> qOld = new LinkedList<UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> qNew = new LinkedList<UndirectedGraphNode>();
        qOld.add(node);
        qNew.add(newNode);
        while(!qOld.isEmpty()){
            UndirectedGraphNode curNodeOld = qOld.pop();
            UndirectedGraphNode curNodeNew = qNew.pop();
            visitedSet.add(curNodeOld);

            // iterate every neighbor of current node & add to queue
            for(UndirectedGraphNode neighborNode : curNodeOld.neighbors){
                if(!visitedSet.contains(neighborNode)){             // only add unvisited nodes
                    qOld.add(neighborNode);
                    UndirectedGraphNode neighborNodeNew = new UndirectedGraphNode(neighborNode.label);
                    curNodeNew.neighbors.add(neighborNodeNew);
                    qNew.add(neighborNodeNew);
                }
            }
        }
        return newNode;
    }

    // method2 - DFS
    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        if (node == null)
            return null;

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        HashSet<UndirectedGraphNode> visitedSet = new HashSet<UndirectedGraphNode>();

        DFS(node, newNode, visitedSet);
        return newNode;
    }
    public void DFS(UndirectedGraphNode oldNode, UndirectedGraphNode newNode, HashSet<UndirectedGraphNode> visitedSet){
        if(oldNode==null)
            return;

        boolean visitedAll = true;
        for(UndirectedGraphNode oldNeighbor : oldNode.neighbors){
            if(!visitedSet.contains(oldNeighbor)){
                visitedAll = false;
                visitedSet.add(oldNeighbor);
                UndirectedGraphNode newNeighbor = new UndirectedGraphNode(oldNeighbor.label);
                newNode.neighbors.add(newNeighbor);
                DFS(oldNeighbor, newNeighbor, visitedSet);
            }
            if(visitedAll)
                return;
        }
    }
}
