package com.yao.linkedlist;

import sun.security.util.Length;

import java.net.HttpRetryException;
import java.util.Stack;

/**
 * @author yanghui
 * @create 2019-08-28 9:59
 * @description   链表实现  按照no顺序插入
 */
class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName +
                '}';
    }
}

class SingleLinkedList2{
    private HeroNode2 head = new HeroNode2(0,"","");
    public void add(HeroNode2 heroNode2){
        HeroNode2 last = getLast();
        last.next = heroNode2;
    }
    public HeroNode2 getLast(){
        HeroNode2 cur = head;
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
         HeroNode2 cur = head.next;
         while(cur!=null){
             System.out.println(cur);
             cur = cur.next;
         }
    }

    public void update(HeroNode2 heroNode2){
        if (head.next == null){
            System.out.println("聊表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while(temp!=null){
            if(temp.no == heroNode2.no){
                temp.name = heroNode2.name;
                temp.nickName = heroNode2.nickName;
                return;
            }else{
                temp = temp.next;
            }
        }
        System.out.println("未找到no为"+heroNode2.no+"的该节点信息");
    }
    public void addByOrder(HeroNode2 heroNode2){
        HeroNode2 temp = head;
        while (temp.next!=null){
            if(temp.next.no>heroNode2.no){
                heroNode2.next = temp.next;
                temp.next = heroNode2;
                return;
            }else if(temp.next.no==heroNode2.no){
                System.out.println("节点处已存在英雄");
                return;
            }else{
                temp = temp.next;
            }
        }
        temp.next = heroNode2;
    }
    public void delete(int no){
        if(head.next == null){
            System.out.println("聊表为空，无法删除");
            return;
        }
        HeroNode2 temp = head;
        while (temp.next!=null){
            if(temp.next.no == no){
                temp.next = temp.next.next;
                return;
            }else{
                temp = temp.next;
            }
        }
        System.out.println("节点不存在");
    }
}

public class SingleLinkedListDemo2 {
    public static void main(String[] args){
        HeroNode2 heroNode1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3,"吴用","智多星");
        HeroNode2 heroNode4 = new HeroNode2(4,"林冲","豹子头");
        SingleLinkedList2 singleLinkedList = new SingleLinkedList2();
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.print();
        System.out.println("==================================");
        singleLinkedList.delete(1);
        singleLinkedList.print();
    }

    public static int getLength(HeroNode2 head){
        if (head.next == null){
            return 0;
        }
        int length = 1;
        HeroNode2 temp = head.next;
        while(temp.next!=null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 查找倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public static HeroNode2 find(HeroNode2 head,int k){
        if(head.next == null){
            System.out.println("聊表为空");
            return null;
        }
        int length = getLength(head);
        if(k < 0 || length < k){
            System.out.println("不存在此节点");
            return null;
        }
        HeroNode2 temp = head.next;
        for (int i = 0; i < length-k; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public static void reverseList(HeroNode2 head){
        if(head.next == null||head.next.next == null){
            return ;
        }
        HeroNode2 cur = head.next;
        HeroNode2 next = null;
        HeroNode2 reverseHead = new HeroNode2(0,"","");
        while (cur!=null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    public static void reversePrint(HeroNode2 head){
        if(head.next == null){
            return;
        }
        Stack<HeroNode2> stack = new Stack<>();
        HeroNode2 cur = head.next;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
    public static HeroNode2 merge(HeroNode2 head1 , HeroNode2 head2){
        if(head1.next == null)
            return head2;
        if(head2.next == null)
            return head1;
        HeroNode2 cur1 = head1.next;
        HeroNode2 cur2 = head2.next;
        HeroNode2 head = new HeroNode2(0,"","");
        HeroNode2 cur = head;
        while(cur1!=null&&cur2!=null){
            if(cur1.no < cur2.no){
                cur.next = cur1;
                cur1 =  cur1.next;
            }else{
                cur.next = cur2;
                cur2 = cur2.next;
            }
        }

        if(cur1!=null){
            cur.next = cur1;
        }
        if(cur2!=null){
            cur.next = cur2;
        }
        return head;
    }
}
