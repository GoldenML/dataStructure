package com.yao.tree;

/**
 * @author yanghui
 * @create 2019-09-08 21:42
 * @description
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
    }
    public static void heapSort(int arr[]){

    }

    /**
     *
     * @param arr      待调整数组
     * @param i        非叶子节点
     * @param length   对多少个元素调整
     */
    public static void adjust(int arr[],int i,int length){
        int temp = arr[i];
        for (int j = i*2+1; j < length; j = j*2+1) {
            if(j+1<length && arr[j]<arr[j+1]){
                j++;
            }
            if(arr[j] > temp){
                arr[i] = arr[j];
                i = j;
            }else{
                break;
            }
        }
    }
}
