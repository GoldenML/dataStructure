package com.yao;

import java.util.*;

/**
 * @author yanghui
 * @create 2019-09-01 10:30
 * @description
 */
public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 2){
            System.out.println(-1);
        }else{
            int[] src = new int[n+1];
            src[0] = 0;
            for (int i = 1; i <= n; i++) {
                int temp = sc.nextInt();
                src[i] = temp;
            }
            int step ;
            boolean flag = false;
            for (step = 3; step <= n ; step++) {
                int[] src2 = src;
                int count = getNum(step,n)/getNum2(step);
                List<List> list1 = new ArrayList<>();
                List<Integer> list = getList(step,n,src2);
                while (list1.contains(list)){
                    list = getList(step,n,src2);
                }
                Iterator<Integer> iterator = list.iterator();
                int max = iterator.next();
                int count2 = max;
                while(iterator.hasNext()){
                    int temp = iterator.next();
                    if(max <= temp){
                        max = temp;
                    }
                    count2 += temp;
                }
                if(count2 <= 2*max){
                    list1.add(list);
                    continue;
                }else{
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println(step);
            }else{
                System.out.println(-1);
            }

        }
    }
    public static int getNum(int step,int n){
        if(step > 0){
            return n * getNum(step - 1,n-1);
        }else{
            return 1;
        }
    }
    public static int getNum2(int step){
        if(step > 0){
            return step * getNum2(step-1);
        }else {
            return 1;
        }
    }
    public static List<Integer> getList(int step,int n,int[] src2){
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<step;i++){
            int a = 1+r.nextInt(n-1);
            while(a == 0){
                a = 1+r.nextInt(n-1);
            }
            src2[a] = 0;
            list.add(a);
        }
        return list;
    }
}
