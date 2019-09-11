package com.yao.linkedlist;

/**
 * @author yanghui
 * @create 2019-08-28 9:59
 * @description   链表实现  尾部直接添加
 */
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName +
                '}';
    }
}
class SingleLinkedList{
    private HeroNode head = new HeroNode(0,"","");
    public void add(HeroNode heroNode){
        HeroNode last = getLast();
        last.next = heroNode;
    }
    public HeroNode getLast(){
        HeroNode cur = head;
        while (cur.next!=null){
            cur = cur.next;
        }
        return cur;
    }
    public void print(){
         if(head.next == null){
             System.out.println("链表为空");
             return;
         }
         HeroNode cur = head.next;
         while(cur!=null){
             System.out.println(cur);
             cur = cur.next;
         }
    }
}
public class SingleLinkedListDemo {
    public static void main(String[] args){
        HeroNode heroNode1 = new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"吴用","智多星");
        HeroNode heroNode4 = new HeroNode(4,"林冲","豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);
        singleLinkedList.print();
    }
}
