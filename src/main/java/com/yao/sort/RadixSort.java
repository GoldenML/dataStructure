package com.yao.sort;

import java.util.Arrays;

/**
 * @author yanghui
 * @create 2019-09-02 21:48
 * @description
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if(max < i){
                max = i;
            }
        }
        int maxLength = (""+max).length();

        int n = arr.length;
        //定义桶为二维数组
        int[][] bucket = new int[10][n];
        //记录每个桶的记录个数
        int[] record = new int[10];
        for (int step = 0; step < maxLength; step++) {
            for (int i = 0; i < n; i++) {
                int temp = arr[i] / (int)Math.pow(10,step)% 10;
                bucket[temp][record[temp]] = arr[i];
                record[temp]++;
            }
            int index = 0;
            for (int i = 0; i < bucket.length; i++) {
                for (int j = 0; j < record[i]; j++) {
                    arr[index] = bucket[i][j];
                    index++;
                }
                record[i] = 0;
            }
        }

    }
}
