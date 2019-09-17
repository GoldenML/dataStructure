package com.yao.search;

/**
 * @author yanghui
 * @create 2019-09-17 21:39
 * @description  二分查找非递归
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1,3,8,10,11,67,100};
        System.out.println(binarySearch(arr, 1));
    }

    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
