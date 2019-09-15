package com.yao.tree.avl;

/**
 * @author yanghui
 * @create 2019-09-14 20:53
 * @description   平衡二叉树
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("处理之前");
        System.out.println("数的高度" + avlTree.getRoot().getHeight());
        System.out.println("左子树高度" + avlTree.getRoot().getLeftHeight());
        System.out.println("右子树高度" + avlTree.getRoot().getRightHeight());

    }
}

class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delete(target.value);
        return target.value;
    }

    public void delete(int value) {
        if (root == null) {
            return;
        } else {
            Node targetNode = search(value);
                if (targetNode == null) {
                    return;
                }
                if (root.left == null && root.right == null) {
                    root = null;
                    return;
                }
                Node parentNode = searchParent(value);
                if (targetNode.left == null && targetNode.right == null) {
                    if (parentNode.left != null && parentNode.left.value == value) {
                        parentNode.left = null;
                    } else if (parentNode.right != null && parentNode.right.value == value) {
                        parentNode.right = null;
                    }
                } else if (targetNode.left != null && targetNode.right != null) {
                    int minValue = delRightTreeMin(targetNode.right);
                    targetNode.value = minValue;
                } else {
                if (targetNode.left != null) {
                    if (parentNode.left.value == value) {
                        parentNode.left = targetNode.left;
                    } else {
                        parentNode.right = targetNode.left;
                    }
                } else {
                    if (parentNode.left.value == value) {
                        parentNode.left = targetNode.right;
                    } else {
                        parentNode.right = targetNode.right;
                    }
                }
            }
        }
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 左旋
     * 定义临时结点tempNode
     * tempNode的左子树为原来树的左子树
     * tempNode的右子树为原来树的右子树的左子树
     * 当前结点的值替换为右子树结点值
     * 当前结点的右子树设置成右子树的右子树
     * 当前结点的左子结点设置为tempNode
     */
    private void leftRotate() {
        Node tempNode = new Node(value);
        tempNode.left = left;
        tempNode.right = right.left;
        value = right.value;
        right = right.right;
        left = tempNode;
    }
    /**
     * 右旋
     * 定义临时结点tempNode
     * tempNode的右子树为原来树的右子树
     * tempNode的左子树为原来树的左子树的右子树
     * 当前结点的值替换为左子树结点值
     * 当前结点的左子树设置成左子树的左子树
     * 当前结点的右子结点设置为tempNode
     */
    private void rightRotate() {
        Node tempNode = new Node(value);
        tempNode.right = right;
        tempNode.left = left.right;
        value = left.value;
        left = left.left;
        right = tempNode;
    }

    public int getLeftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.getHeight();
        }
    }

    public int getRightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.getHeight();
        }
    }

    public int getHeight() {
        return Math.max(left == null ? 0 : left.getHeight(), right == null ? 0 : right.getHeight()) + 1;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (this.value > node.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        /**
         * 右子树高度大于左子树高度时左旋转
         */
        if (getRightHeight() - getLeftHeight() > 1) {
            if(right!=null && right.getLeftHeight()>right.getRightHeight()){
                right.rightRotate();
                leftRotate();
            }else{
                leftRotate();
            }
        }

        if (getLeftHeight() - getRightHeight() > 1) {
            //如果它的左子树的右子树大于左子树高度
            if(left!=null && left.getRightHeight()>left.getLeftHeight()){
                //先对当前节点的左子节点进行左旋
                left.leftRotate();
                //然后对当前节点进行右旋
                rightRotate();
            }else{
                rightRotate();
            }

        }
    }


    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else if (value < this.value && this.left != null) {
            return this.left.searchParent(value);
        } else if (value > this.value && this.right != null) {
            return this.right.searchParent(value);
        } else {
            return this;
        }
    }

    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.print(this.value + " ");
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}