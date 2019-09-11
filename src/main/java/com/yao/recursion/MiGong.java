package com.yao.recursion;

import java.util.Arrays;

/**
 * @author yanghui
 * @create 2019-08-30 10:16
 * @description   递归法求解迷宫
 */
public class MiGong {
    public static void main(String[] args){
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;
        print(map);
        System.out.println("===============================");
        setWay(map,1,1);
        print(map);
    }
    public static void print(int[][] map){
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print("\t"+anInt);
            }
            System.out.println();
        }
    }
    public static boolean safe(int[][] map,int x,int y){
        return map[x][y]==0&&x<8&&y<7;
    }
    public static boolean setWay(int[][] map,int x,int y){
        if(x == 6 && y == 5){
            map[6][5] = 2;
            return true;
        }
        if(safe(map,x,y)){
            map[x][y] = 2;
            if(setWay(map,x+1,y)){
                return true;
            }else if(setWay(map,x,y+1)){
                return true;
            }else if(setWay(map,x-1,y)){
                return true;
            }else if(setWay(map,x,y-1)){
                return true;
            }else{
                map[x][y] = 3;
                return false;
            }
        }else{
            return false;
        }
    }
}
