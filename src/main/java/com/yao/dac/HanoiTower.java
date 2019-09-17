package com.yao.dac;

/**
 * @author yanghui
 * @create 2019-09-17 21:57
 * @description   分治算法 --汉诺塔游戏
 */
public class HanoiTower {
    public static void main(String[] args) {
        HanoiTower.hanoiTower(3,'A','B','C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘"+a + "->" + c);
        } else {
            //将上面num-1个盘从a移动到b，借助c
            hanoiTower(num - 1, a, c, b);
            //将最下面的盘从a移动到c
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            //将上面num-1个盘从b移动到c，借助a
            hanoiTower(num - 1, b, a, c);
        }
    }
}
