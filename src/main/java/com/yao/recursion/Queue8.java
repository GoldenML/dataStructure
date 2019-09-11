package com.yao.recursion;

import java.util.Queue;

/**
 * @author yanghui
 * @create 2019-08-30 13:33
 * @description
 */
public class Queue8 {
    int max = 8;
    int[] arr = new int[max];
    static int count = 0;
    public static void main(String[] args){
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
    }
    private void check(int n){
        if(n == max){
            print();
            count++;
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }
    }
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            /**
             * arr[i] == arr[n]判断是否在同一列
             * Math.abs(n-i) == Math.abs(arr[n]-arr[i])判断是否在同一斜线上
             * 同一斜线上 y=x+b或y=-x+b  所以|x2 - x1| == |y2 - y1|
             *
             */
            if(arr[i] == arr[n] ||Math.abs(n-i) == Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }
    private void print(){
        for (int i : arr) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }
}
