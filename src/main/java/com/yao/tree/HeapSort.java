package com.yao.tree;

import java.util.Arrays;

/**
 * @author yanghui
 * @create 2019-09-08 21:42
 * @description   大顶堆
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int arr[]) {
        System.out.println("堆排序");
        int temp = 0;
        for (int i = arr.length/2; i >= 0; i--) {
            adjust(arr,i,arr.length);
        }
        for (int i = arr.length-1; i >0 ; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjust(arr,0,i);
        }
    }

    /**
     * @param arr    待调整数组
     * @param i      非叶子节点
     * @param length 对多少个元素调整
     */
    public static void adjust(int arr[], int i, int length) {
        //保存当前非叶子节点值
        int temp = arr[i];
        //取当前非叶子节点的左子孩子
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            //比较左子节点和右子节点
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            //比较当前非叶子节点和孩子节点大小
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
            arr[i] = temp;
        }
    }
}
