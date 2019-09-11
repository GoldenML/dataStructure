package com.yao.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanghui
 * @create 2019-09-02 22:47
 * @description
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 5, 5, 7, 8, 9};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 5));
    }

    public static List<Integer> binarySearch(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        if (left <= right) {
            if (arr[mid] == value) {
                List<Integer> list = new ArrayList<>();
                int temp = mid - 1;
                while (true) {
                    if (temp == -1 || arr[temp] != value) {
                        break;
                    }
                    list.add(temp);
                    temp--;
                }
                list.add(mid);

                temp = mid +1;

                while (true) {
                    if (temp == -1 || arr[temp] != value) {
                        break;
                    }
                    list.add(temp);
                    temp++;
                }
                return list;
                //return mid;
            } else if (arr[mid] > value) {
                return binarySearch(arr, left, mid - 1, value);
            } else {
                return binarySearch(arr, mid + 1, right, value);
            }
        }
        return null;
    }
}
