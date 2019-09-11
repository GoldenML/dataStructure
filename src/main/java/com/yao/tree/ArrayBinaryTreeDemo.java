package com.yao.tree;

/**
 * @author yanghui
 * @create 2019-09-07 10:07
 * @description
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
        System.out.println();
        arrBinaryTree.infixOrder();
    }
}
class ArrBinaryTree{
    private int[] arr;
    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }
    public void infixOrder(){
        this.infixOrder(0);
    }
    public void postOrder(){
        this.postOrder(0);
    }
    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        System.out.print(arr[index]+" ");
        if((index*2+1) < arr.length){
            preOrder(index*2+1);
        }
        if((index*2+2) < arr.length){
            preOrder(index*2+2);
        }
    }
    public void infixOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        if((index*2+1) < arr.length){
            infixOrder(index*2+1);
        }
        System.out.print(arr[index]+" ");
        if((index*2+2) < arr.length){
            infixOrder(index*2+2);
        }
    }
    public void postOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        if((index*2+1) < arr.length){
            postOrder(index*2+1);
        }
        if((index*2+2) < arr.length){
            postOrder(index*2+2);
        }
        System.out.print(arr[index]+" ");
    }
}

