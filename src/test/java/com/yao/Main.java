package com.yao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author yanghui
 * @create 2019-09-01 10:01
 * @description
 */
class Resource {
    private Long x;
    private Long y;

    public Resource(Long x, Long y) {
        this.x = x;
        this.y = y;
    }

    public Long getX() {
        return x;
    }


    public Long getY() {
        return y;
    }


}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Resource> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Resource(sc.nextLong(), sc.nextLong()));
        }
        Iterator<Resource> iterator = list.iterator();
        Resource resource = iterator.next();
        long maxX = resource.getX();
        long minX = resource.getX();
        long maxY = resource.getY();
        long minY = resource.getY();
        while (iterator.hasNext()) {
            Resource resource2 = iterator.next();
            if (maxX <= resource2.getX()) {
                maxX = resource2.getX();
            }
            if(minX > resource2.getX()){
                minX = resource2.getX();
            }
            if (maxY <= resource2.getY()) {
                maxY = resource2.getY();
            }
            if(minY > resource2.getY()){
                minY = resource2.getY();
            }
        }
        long res = getMax((maxX - minX) , (maxY - minY));
        System.out.println(res*res);
    }

    public static long getMax(long a1, long a2) {
        return a1 > a2 ? a1 : a2;
    }
}
