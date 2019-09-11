package com.yao.queue;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.Scanner;

/**
 * @author yanghui
 * @create 2019-08-27 21:24
 * @description  数组实现简单队列
 */

class ArrayQueue{
    private int maxSize;//队列大小
    private int front;//队头
    private int rear;//队尾
    private int[] arr;//存放数据
    public ArrayQueue(int size){
        maxSize = size;
        arr = new int[maxSize];
        front = -1;//指向第一个元素前一个
        rear = -1;//指向最后一个元素
    }
    public boolean isFull(){
        return rear == maxSize-1;
    }
    public boolean isEmpty(){
        return front == rear;
    }
    public void add(int element){
        if(isFull()){
            System.out.println("队列已满，不能加入");
            return;
        }
        rear++;
        arr[rear] = element;
    }
    public int get(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return front;
    }
    public void print(){
        if(isEmpty()){
            System.out.println("队列空，无数据");
            return;
        }
        for (int i = front+1; i <= rear; i++) {
            System.out.println(arr[i]);
        }
    }
    public int head(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }
}
public class ArrayQueueDemo {
    public static void main(String[] args){
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        char key = ' ';
        while (loop){
            System.out.println("s(show)显示队列");
            System.out.println("e(exit)显示队列");
            System.out.println("a(add)显示队列");
            System.out.println("g(get)显示队列");
            System.out.println("h(head)显示队列");
            key = sc.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.print();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int value = sc.nextInt();
                    arrayQueue.add(value);
                    break;
                case 'g':
                    try{
                        int num = arrayQueue.get();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int h = arrayQueue.head();
                    }catch(Exception e){
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
