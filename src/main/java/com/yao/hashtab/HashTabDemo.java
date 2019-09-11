package com.yao.hashtab;

import com.sun.glass.ui.Size;

import java.util.Scanner;

/**
 * @author yanghui
 * @create 2019-09-03 11:51
 * @description
 */
public class HashTabDemo {
    public static void main(String[] args){
        HashTab tab = new HashTab(7);
        String key = "";
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("add:添加雇员");
            System.out.println("print:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出");
            System.out.println("输入你的选择");
            key = sc.next();
            switch (key){
                case "add":
                    int id = sc.nextInt();
                    String name = sc.next();
                    Emp emp = new Emp(id,name);
                    tab.add(emp);
                    break;
                case "print":
                    tab.print();
                    break;
                case "find":
                    id = sc.nextInt();
                    System.out.println(tab.findEmpById(id));
                    break;
                case "exit":
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}

class HashTab{
    private EmpLinkedList[] empLinkedLists;
    private int size;
    public HashTab(int size){
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
        this.size = size;
    }
    public void add(Emp emp){
        int h = hashCode(emp.id);
        empLinkedLists[h].add(emp);
    }
    public int hashCode(int id){
        return id%size;
    }
    public void print(){
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].print();
        }
    }
    public Emp findEmpById(int id){
        int h = hashCode(id);
        Emp emp = empLinkedLists[h].findEmpById(id);
        if(emp!=null){
            return emp;
        }else{
            System.out.println("没找到该雇员");
            return null;
        }
    }
}
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class EmpLinkedList{
    private Emp head;

    public void add(Emp emp){
        if(head == null){
            head = emp;
        }else{
            Emp cur = head;
            while(cur.next!=null){
                cur =cur.next;
            }
            cur.next = emp;
        }
    }
    public void print(){
        if(head == null){
            System.out.println("无数据");
            return;
        }
        Emp cur = head;
        while(cur!=null){
            System.out.print("id:"+cur.id+" name: "+cur.name+"\t ");
            cur = cur.next;
        }
        System.out.println();
    }
    public Emp findEmpById(int id){
        if(head == null){
            return null;
        }
        Emp cur = head;
        while (cur!= null){
            if(cur.id != id) {
                cur = cur.next;
            }else{
                break;
            }

        }
        return cur;
    }
}