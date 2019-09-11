package com.yao.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args){
        ArrayStack arrayStack = new ArrayStack(5);
        String key = "";
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while(flag){
            System.out.println("show:显示栈");
            System.out.println("push:添加输入");
            System.out.println("pop:取数据");
            System.out.println("exit:退出程序");
            System.out.println("请输入你的选择");
            key = sc.next();
            switch (key){
                case "push":
                    System.out.println("请输入要压入栈的数据：");
                    int value = sc.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try{
                        int res = arrayStack.pop();
                        System.out.println("出栈数据"+res);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    sc.close();
                    flag = false;
                    break;
                case "show":
                    arrayStack.print();
                    break;
                default:
                    break;
            }
        }

    }
}
