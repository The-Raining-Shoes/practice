package com.example.item;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] a = { 1, 2, 5, 7, 4, 8,5, 6, 3};
        System.out.println("--------排序前数组a--------");
        System.out.println(Arrays.toString(a));
        int count = 0;
        // 定义排序中间间隔数量
        int h = a.length/2;
        while (h>=1){
            System.out.println(h);
            // 控制循環 s
            for(int i =0;i<a.length-h;i++){
                for (int j = i; j+h<a.length; j += h) {
                    if(a[j]<=a[j+h]){
                        count +=1;
                        swap(a,j,j+h);
                    }
                }
            }
            h = h/2;
        }
        //1
//        int[] a = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
//        System.out.println("--------排序前数组a--------");
//        System.out.println(Arrays.toString(a));
//        int count = 0;
//        // 定义排序中间间隔数量
//        int h = a.length/2;
//        while (h>=1){
//            System.out.println(h);
//            // 控制循環次数
//            for(int i =0;i<a.length-h;i++){
//                for (int j = i; j<a.length; j += h) {
//                    int k = j - h;
//                    if (k>=0 && a[k]> a[k+h]){
//                        count +=1;
//                        swap(a,k,k+h);
//                    }
//                }
//            }
//            h = h/2;
//        }
        //2
//        while (h>=1) {
//            System.out.println(h);
//            for (int i = h; i < a.length; i++) {
//                for (int j = i; j >= h; j-=h) {
//                    //待插入值a[j]
//                    if (a[j]>a[j-h]){
//                        swap(a,j,j-h);
//                    }else {
//                        //已排序好 结束循环
//                        break;
//                    }
//                }
//            }
//            //每次增量减半
//            h=h/2;
//        }
        System.out.println(count);
        System.out.println("--------排序后数组a--------");
        System.out.println(Arrays.toString(a));
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        System.out.println("換順序過後"+Arrays.toString(nums));
    }

}
