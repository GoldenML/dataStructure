package com.yao.sort;

import java.util.Arrays;

/**
 * @author yanghui
 * @create 2019-09-01 9:49
 * @description
 */
public class SelectSort {
    public static void main(String[] args){
        int[] src = new int[10];
        for (int i = 0; i < 10; i++) {
            src[i] = (int)(Math.random()*100000);
        }
        int n = src.length;
        int min;
        for (int i = 0; i < n-1; i++) {
            min = i;
            for (int j = i+1; j < n; j++) {
                if(src[min] > src[j]){
                    min = j;
                }
            }
            int temp = src[i];
            src[i] = src[min];
            src[min] = temp;
            System.out.println("第"+(i+1)+"趟排序："+Arrays.toString(src));
        }
        System.out.println(Arrays.toString(src));
    }
}
