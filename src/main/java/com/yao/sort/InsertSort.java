package com.yao.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author yanghui
 * @create 2019-09-01 15:26
 * @description
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] src = new int[10];
        int n = src.length;
        for (int i = 0; i < n; i++) {
            src[i] = (int) (Math.random() * 100000);
        }
        System.out.println("排序前：" + Arrays.toString(src));
        insertSort(src, n);
        System.out.println("排序后：" + Arrays.toString(src));
    }

    public static void insertSort(int[] src, int n) {
        for (int i = 1; i < n; i++) {
            int temp = src[i];
            int j = i-1;
            while (j > 0 && temp < src[j]) {
                src[j+1] = src[j];
                j--;
            }
            src[j] = temp;
            System.out.println("第" + (i) + "轮排序：" + Arrays.toString(src));
        }
    }
}
