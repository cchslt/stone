package com.stone.may;

public class Duplication {


    public static int duplicateNumber(int[] array) {
        if(array == null || array.length <= 0){
            return -1;
        }
        for(int i=0;i<array.length;i++){ //判断输入数组的合法性
            if(array[i] < 0 || array[i] >= array.length){
                return -1;
            }
        }
        for(int i=0;i<array.length;i++){
            int s1 = array[i];
            int s2 = array[array[i]];
            if(i != s1 && array[i] == s2){ //重复数据
                return array[i];
            }
            while(i != array[i]){ //将数字与第m个位置上的数字交换
                exchange(array, i, array[i]);
            }
        }

        return -1;
    }

    /**
     * 交换数组array中的第i位和第j位
     * @param array
     * @param i
     * @param j
     */
    public static void exchange(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {100,3,1,0,2,5,3};
        int duplicate = duplicateNumber(array);
        System.out.println("重复的数字为: " + duplicate);
    }

}
