package com.yao.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author yanghui
 * @create 2019-09-15 22:55
 * @description
 */
public class Graph {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    //记录某个节点有没有被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String[] vertexValue = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for (String str : vertexValue) {
            graph.insertVertex(str);
        }
        graph.insertEdges(0, 1, 1);
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1, 2, 1);
        graph.insertEdges(1, 3, 1);
        graph.insertEdges(1, 4, 1);
        graph.showGraph();
//        System.out.println("dfs遍历为：");
//        graph.dfs();
        System.out.println("bfs遍历：");
        graph.bfs();
    }

    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        isVisited = new boolean[n];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //获取第一个邻接结点下标
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    private void dfs(boolean[] isVisited, int i) {
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        //查找i的第一个邻接结点
        int w = getFirstNeighbor(i);
        //如果找到
        while (w != -1) {
            //如果w未被访问过
            if (!isVisited[w]) {
                //以w进行dfs遍历
                dfs(isVisited, w);
            }
            //如果w已经被访问过，则访问i结点的下一个邻接结点
            w = getNextNeighbor(i, w);
        }
    }

    public void dfs() {
        //遍历每个结点进行dfs遍历
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //广度优先遍历
    private void bfs(boolean[] isVisited, int i) {
        int u;  //头结点下标
        int w;  //邻接结点下标
        //baocun节点访问顺序
        LinkedList linkedList = new LinkedList();
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        linkedList.addLast(i);
        while (!linkedList.isEmpty()) {
            u = (int) linkedList.removeFirst();
            //获取u的第一个邻接结点
            w = getFirstNeighbor(u);
            while (w != -1) {
                if(!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    linkedList.addLast(w);
                }
                w = getNextNeighbor(u,w);
            }
        }
    }

    public void bfs() {
        //遍历每个结点进行dfs遍历
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraph() {
        for (int[] temp : edges) {
            System.out.println(Arrays.toString(temp));
        }
    }
}
