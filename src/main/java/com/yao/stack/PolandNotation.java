package com.yao.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author yanghui
 * @create 2019-08-29 13:10
 * @description  中缀表达式 变 后缀  根据后缀表达式计算
 */
public class PolandNotation {
    public static void main(String[] args) {
        //逆波兰表达式
//        String suffixExpression = "3 4 + 5 * 6 -";
        //String[] str = suffixExpression.split(" ");

//        List<String> list = getListString(suffixExpression);
//        System.out.println(list);
//        int res = calculate(list);
//        System.out.println(res);
        String expression = "1+((2+3)*4)-5";
        List<String> list = toInfixExpressonList(expression);
        System.out.println(list);
        list = getSuffixExpression(list);
        System.out.println(list);
        System.out.println(calculate(list));
    }

    public static List<String> toInfixExpressonList(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;
        String str;
        char ch;
        do {
            ch = s.charAt(i);
            if (ch < 48 || ch > 57) {
                list.add("" + ch);
                i++;
            } else {
                str = "";
                while (i < s.length() && s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                    str += ch;
                    i++;
                }
                list.add(str);
            }
        } while (i < s.length());
        return list;
    }

    public static List<String> getSuffixExpression(List<String> list) {
        Stack<String> stack = new Stack<>();//符号栈
        List<String> ls = new ArrayList<>();
        for (String str : list) {
            if (str.matches("\\d+")) {
                ls.add(str);
            } else if (str.equals("(")) {
                stack.push(str);
            } else if (str.equals(")")) {
                while (!stack.peek().equals("(")) {
                    ls.add(stack.pop());
                }
                stack.pop();
            } else {
                while(stack.size()!=0 && priority(stack.peek())>=priority(str)){
                    ls.add(stack.pop());
                }
                stack.add(str);
            }
        }
        while (stack.size()!=0){
            ls.add(stack.pop());
        }
        return ls;
    }
    public static int priority(String oper){
        if(oper.equals("*")|| oper .equals("/")){
            return 1;
        }else if(oper.equals("+") || oper.equals("-")){
            return 0;
        }else{
            return -1;
        }
    }
    public static List<String> getListString(String suffixExpression) {
        String[] str = suffixExpression.split(" ");
        List<String> list = Arrays.asList(str);
        return list;
    }

    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String str : list) {
            if (str.matches("\\d+")) {
                stack.push(str);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (str.equals("+")) {
                    res = num1 + num2;
                } else if (str.equals("-")) {
                    res = num2 - num1;
                } else if (str.equals("*")) {
                    res = num1 * num2;
                } else if (str.equals("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("运算符错误");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
