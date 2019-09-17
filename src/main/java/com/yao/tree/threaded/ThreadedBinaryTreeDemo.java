package com.yao.tree.threaded;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yanghui
 * @create 2019-09-07 10:34
 * @description    线索二叉树
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNode();
        HeroNode leftNode = node4.getRight();
        System.out.println(leftNode);

        System.out.println("线索化遍历二叉树：");
        threadedBinaryTree.threadedList();
    }
}

class ThreadedBinaryTree {
    private HeroNode root;

    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNode() {
        this.threadedNode(root);
    }
    //遍历线索二叉树
    public void threadedList() {
        HeroNode node = root;
        while (node != null) {
            while(node.getLeftType() == 0){
                node = node.getLeft();
            }
            System.out.println(node);
            while(node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }
    //线索二叉树生成
    public void threadedNode(HeroNode node) {
        if (node == null) {
            return;
        }
        threadedNode(node.getLeft());
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        threadedNode(node.getRight());
    }
    //删除节点
    public void delete(int no) {
        if (root == null) {
            System.out.println("空树=======");
        } else {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delete(no);
            }
        }
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        }
        return null;
    }

    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        }
        return null;
    }

    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        }
        return null;
    }
}

@Setter
@Getter
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //leftType == 0则指向左子树，1指向前驱节点
    //rightType == 0则指向右子树，1指向后继节点
    private int leftType;
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void delete(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delete(no);
        }
        if (this.right != null) {
            this.right.delete(no);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     *
     * @param no
     * @return
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println(this);
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {

        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println(this);
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println(this);
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}
