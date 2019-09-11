package com.yao.queue;

import java.util.Scanner;

/**
 * @author yanghui
 * @create 2019-08-27 21:24
 * @description 数组实现简单队列
 */

class CircleArrayQueue {
    private int maxSize;//队列大小
    private int front;//队头
    private int rear;//队尾
    private int[] arr;//存放数据

    public CircleArrayQueue(int size) {
        maxSize = size;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void add(int element) {
        if (isFull()) {
            System.out.println("队列已满，不能加入");
            return;
        }
        arr[rear] = element;
        rear = (rear + 1) % maxSize;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int val = arr[front];
        front = (front + 1) % maxSize;
        return val;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("队列空，无数据");
            return;
    }
        for (int i = front; i < front + size(); i++) {
        System.out.print("arr["+i+"]"+arr[i % maxSize] + " ");
    }
        System.out.println();
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        char key = ' ';
        while (loop) {
            System.out.println("s(show)显示队列");
            System.out.println("e(exit)显示队列");
            System.out.println("a(add)显示队列");
            System.out.println("g(get)显示队列");
            System.out.println("h(head)显示队列");
            key = sc.next().charAt(0);
            switch (key) {
                case 's':
                    circleArrayQueue.print();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int value = sc.nextInt();
                    circleArrayQueue.add(value);
                    break;
                case 'g':
                    try {
                        int num = circleArrayQueue.get();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int h = circleArrayQueue.head();
                        System.out.println(h);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
