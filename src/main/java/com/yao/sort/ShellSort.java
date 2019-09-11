package com.yao.sort;

import java.util.Arrays;

/**
 * @author yanghui
 * @create 2019-09-01 15:59
 * @description
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 交换法
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int temp = 0;
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                for (int j = i - step; j >= 0; j -= step) {
                    if (arr[j] > arr[j + step]) {
                        temp = arr[j];
                        arr[j] = arr[j + 5];
                        arr[j + 5] = temp;
                    }
                }
            }
        }
    }

    public static void shellSort2(int[] arr) {
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j-step]){
                    while (j-step >=0 && temp < arr[j-step]){
                        arr[j] = arr[j-step];
                        j -= step;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
