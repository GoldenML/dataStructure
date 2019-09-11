package com.yao.stack;

/**
 * @author yanghui
 * @create 2019-08-29 10:11
 * @description
 */
public class Calculator {
    public static void main(String[] args){
        String expression = "3+2*6-2";
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        int index = 0;
        int num1 =0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        while(true){
            ch = expression.substring(index,index+1).charAt(0);
            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    if(operStack.priority(operStack.peek()) >= operStack.priority(ch)){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = operStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else{
                        operStack.push(ch);
                    }
                }else{
                    operStack.push(ch);
                }
            }else{
                numStack.push(ch-48);
            }
            index++;
            if(index>=expression.length()){
                break;
            }
        }

        while (true){
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = operStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.printf("表达式 %s = %d",expression,res);
    }
}
