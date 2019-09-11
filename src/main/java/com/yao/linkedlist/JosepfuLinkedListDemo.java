package com.yao.linkedlist;

import lombok.Getter;
import lombok.Setter;

import java.io.FileReader;

/**
 * @author yanghui
 * @create 2019-08-28 14:30
 * @description
 */
@Setter
@Getter
class LNode{
    private int data;
    private LNode next;
    public LNode(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "LNode{" +
                "data=" + data +
                '}';
    }
}

class JosepfuLinkedList{
    private LNode first = null;

    public void add(int num){
        if(num < 1) {
            System.out.println("num值不正确");
            return;
        }
        LNode cur = null;
        for (int i = 1; i <= num ; i++) {
            LNode node = new LNode(i);
            if(i == 1){
                first = node;
                first.setNext(first);
                cur = first;
            }else{
                cur.setNext(node);
                node.setNext(first);
                cur = node;
            }
        }
    }
    public void print(){
        if(first == null){
            System.out.println("链表为空");
            return;
        }
        LNode cur = first;
        do{
            System.out.println(cur.getData());
            cur = cur.getNext();
        }while (cur != first);
    }
    public void pop(int k,int m,int num){
        if(first == null || k < 1 || k > num){
            return;
        }
        LNode helper = first;
        //helper指向最后一个节点
        while (helper.getNext()!=first){
            helper = helper.getNext();
        }

        for (int i = 0; i < k-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while(helper != first){
            for (int i = 0; i < m-1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first.getData());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println(helper.getData());
    }
}

public class JosepfuLinkedListDemo {
    public static void main(String[] args){
        JosepfuLinkedList josepfuLinkedList = new JosepfuLinkedList();
        josepfuLinkedList.add(5);
        josepfuLinkedList.print();
        josepfuLinkedList.pop(3,2,5);
    }

}
