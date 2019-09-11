package com.yao.linkedlist;

/**
 * @author yanghui
 * @create 2019-08-28 13:46
 * @description
 */
class DoubleHeroNode{
    public int no;
    public String name;
    public String nickName;
    public DoubleHeroNode next;
    public DoubleHeroNode pre;

    public DoubleHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DoubleHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
class DoubleLinkedList{
    private DoubleHeroNode head = new DoubleHeroNode(0,"","");
    public DoubleHeroNode getHead(){
        return head;
    }
    public void print(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        DoubleHeroNode cur = head.next;
        while(cur!=null){
            System.out.println(cur);
            cur = cur.next;
        }
    }
    public void add(DoubleHeroNode doubleHeroNode){
        DoubleHeroNode cur = head;
        while (cur.next!=null){
            cur = cur.next;
        }
        cur.next = doubleHeroNode;
        doubleHeroNode.pre = cur;
    }
    public void update(DoubleHeroNode doubleHeroNode){
        if (head.next == null){
            System.out.println("聊表为空");
            return;
        }
        DoubleHeroNode cur = head.next;
        while(cur!=null){
            if(cur.no == doubleHeroNode.no){
                cur.name = doubleHeroNode.name;
                cur.nickName = doubleHeroNode.nickName;
                return;
            }else{
                cur = cur.next;
            }
        }
        System.out.println("未找到no为"+doubleHeroNode.no+"的该节点信息");
    }
    public void delete(int no){
        if(head.next == null){
            System.out.println("聊表为空，无法删除");
            return;
        }
        DoubleHeroNode cur = head.next;
        while (cur!=null){
            if(cur.no == no){
                cur.pre.next = cur.next;
                if(cur.next != null){
                    cur.next.pre = cur.pre;
                }
                return;
            }else{
                cur = cur.next;
            }
        }
        System.out.println("节点不存在");
    }
}
public class DoubleLinkedListDemo {
    public static void main(String[] args){
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleHeroNode doubleHeroNode1 = new DoubleHeroNode(1,"宋江","及时雨");
        DoubleHeroNode doubleHeroNode2 = new DoubleHeroNode(2,"卢俊义","玉麒麟");
        DoubleHeroNode doubleHeroNode3 = new DoubleHeroNode(3,"吴用","智多星");
        DoubleHeroNode doubleHeroNode4 = new DoubleHeroNode(4,"林冲","豹子头");
        doubleLinkedList.add(doubleHeroNode1);
        doubleLinkedList.add(doubleHeroNode2);
        doubleLinkedList.add(doubleHeroNode3);
        doubleLinkedList.add(doubleHeroNode4);
        doubleLinkedList.print();
        System.out.println("===========================");
        DoubleHeroNode doubleHeroNode = new DoubleHeroNode(4,"公孙胜","入云龙");
        doubleLinkedList.update(doubleHeroNode);
        doubleLinkedList.print();
        System.out.println("===========================");
        doubleLinkedList.delete(4);
        doubleLinkedList.print();

    }
}
