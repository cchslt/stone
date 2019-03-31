package com.stone.may;

import java.util.List;

public class JishuOushu {

    public static void main(String[] args) {

        int list[] = {1,2 ,3, 4,5, 7, 9, 11 };
        reOrderOddEven(list);

    }

    private static void reOrderOddEven(int[] list) {
        int length = list.length;
        System.out.println("原数组：");
        for (int i = 0; i < length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.print("\n");


        int begin = 0;
        int end = length -1;
        while (begin < end) {
            while (begin < end && (list[begin] % 2) != 0){
                begin++;
            }

            while (begin < end && list[end] % 2 == 0) {
                end--;
            }

            if (begin < end) {
                int temp = list[begin];
                list[begin] = list[end];
                list[end] = temp;
            }
        }


        System.out.println("重排序后的数组：");
        for (int i = 0; i < length; i++) {
            System.out.print(list[i] + " ");
        }

    }

}
