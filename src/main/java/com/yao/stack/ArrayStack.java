package com.yao.stack;

/**
 * @author yanghui
 * @create 2019-08-29 9:21
 * @description    用数组模拟栈
 */

public class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    public boolean isFull(){
        return top == maxSize - 1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public void push(int element){
        if(isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = element;
    }
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈已空");
        }
        int value = stack[top];
        top--;
        return value;
    }
    public void print(){
        if(isEmpty()){
            System.out.println("栈为空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("stack["+i+"]"+"="+stack[i]);
        }
    }

    public int peek(){
        return stack[top];
    }
    /**
     *
     */
    public int priority(int oper){
        if(oper == '*'|| oper == '/'){
            return 1;
        }else if(oper == '+' || oper == '-'){
            return 0;
        }else{
            return -1;
        }
    }

    public boolean isOper(char val){
        return val =='+'||val =='-'||val =='*'||val =='/';
    }

    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1+num2;
                break;
            case '-':
                res = num1-num2;
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num1/num2;
                break;
            default:
                break;
        }
        return res;
    }

}
