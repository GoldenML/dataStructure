package com.yao.sparsearray;


import java.io.*;
import java.nio.charset.Charset;
import java.util.logging.Level;

/**
 * @author yanghui
 * @create 2019-08-27 20:22
 * @description 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        /**
         * 二维数组转稀疏数组
         */
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        for(int[] row:chessArr1){
            for (int data:row){
                System.out.print("\t "+data);
            }
            System.out.println();
        }
        int num = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if(chessArr1[i][j]!=0){
                    num++;
                }
            }
        }
        System.out.println(num);
        int[][] sparseArr = new int[num+1][num+1];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = 2;
        int rowNum = 0;
        for (int i = 1; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if(chessArr1[i][j]!=0){
                    rowNum++;
                    sparseArr[rowNum][0]=i;
                    sparseArr[rowNum][1]=j;
                    sparseArr[rowNum][2]=chessArr1[i][j];

                }
            }
        }
        /**
         * 稀疏数组
         */
        for(int[] row:sparseArr){
            for(int data:row){
                System.out.print("\t"+data);
            }
            System.out.println();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\map.data"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr.length; j++) {
                bufferedWriter.write(sparseArr[i][j]);
            }
        }

        bufferedWriter.flush();
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\map.data"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        int[][] sparseArr2 = new int[sparseArr.length][sparseArr.length];
        for (int i = 0; i < sparseArr2.length; i++) {
            for (int j = 0; j < sparseArr2.length; j++) {
                sparseArr2[i][j] = bufferedReader.read();
            }
        }
        bufferedReader.close();
        fileInputStream.close();
        bufferedWriter.close();
        fileOutputStream.close();
        for(int[] row:sparseArr2){
            for(int data:row){
                System.out.print("\t"+data);
            }
            System.out.println();
        }


        /**
         * 稀疏数组转二维数组
         */
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < num+1; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        for (int i = 0; i < chessArr2.length; i++) {
            for (int j = 0; j < chessArr2.length; j++) {
                System.out.print("\t"+chessArr2[i][j]);
            }
            System.out.println();
        }
    }
}
