package com.yao.tree.haffmantree;

import lombok.Getter;
import lombok.Setter;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yanghui
 * @create 2019-09-13 12:03
 * @description   赫夫曼树
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node node = createHuffmanTree(arr);
        node.preOrder();
    }

    public static Node createHuffmanTree(int[] arr) {
        List<Node> list = new ArrayList<>();
        for (int value : arr) {
            list.add(new Node(value));
        }
        while (list.size() > 1) {
            Collections.sort(list);

            Node left = list.get(0);
            Node right = list.get(1);
            Node node = new Node(left.getValue() + right.getValue());
            node.setLeft(left);
            node.setRight(right);
            list.remove(left);
            list.remove(right);
            list.add(node);
        }
        return list.get(0);
    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("树空");
        }
    }
}

@Setter
@Getter
class Node implements Comparable<Node> {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.value - o.value;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
