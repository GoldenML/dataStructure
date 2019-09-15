package com.yao.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yanghui
 * @create 2019-09-15 22:55
 * @description
 */
public class Graph {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;

    public static void main(String[] args) {
        int n = 5;
        String[] vertexValue = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for(String str : vertexValue){
            graph.insertVertex(str);
        }
        graph.insertEdges(0,1,1);
        graph.insertEdges(0,2,1);
        graph.insertEdges(1,2,1);
        graph.insertEdges(1,3,1);
        graph.insertEdges(1,4,1);
        graph.showGraph();
    }

    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public int getNumOfVertex(){
        return vertexList.size();
    }

    public int getNumOfEdges(){
        return numOfEdges;
    }

    public String getValueByIndex(int index){
        return vertexList.get(index);
    }

    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    
    public void showGraph(){
        for(int[] temp : edges){
            System.out.println(Arrays.toString(temp));
        }
    }
}
