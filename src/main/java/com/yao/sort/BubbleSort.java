package com.yao.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * @author yanghui
 * @create 2019-08-31 21:14
 * @description
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3, 9, -1, 10, -2};

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
        System.out.println(new Date());
        bubbleSort(arr);
        System.out.println(new Date());
    }

    /**
     * 冒泡排序算法
     * @param arr
     */
    public static void bubbleSort(int[] arr) {

        System.out.println("排序前："+ Arrays.toString(arr));
        boolean b = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    b = true;
                }
            }
            if(!b){
                break;
            }else{
                b = false;
            }
            System.out.println("第"+(i+1)+"趟排序结果："+ Arrays.toString(arr));
        }
        System.out.println("排序后："+Arrays.toString(arr));
    }
}
