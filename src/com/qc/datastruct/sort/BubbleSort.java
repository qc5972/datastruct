package com.qc.datastruct.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序的优化
 * @author qc
 * @create 2020-02-17 20:22
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={5,6,1,0,4,8,7,10};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1=new int[80000];
        for(int i=0;i<arr1.length;i++){
            arr1[i]=(int)(Math.random()*80000);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date start=new Date();
        System.out.println("排序前"+sdf.format(start));
        bubbleSort(arr1);
        Date end=new Date();
        System.out.println("80000长度的数组排序花费了"+ sdf.format(end));

    }

    public static void bubbleSort(int[] arr){
        int temp=0;
        boolean flag=false;
        int lastChangeIdx=0;
        int boderIdx=arr.length-1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<boderIdx;j++){
                if(arr[j+1]<arr[j]){
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    flag=true;
                    lastChangeIdx=j;
                }
            }
            boderIdx=lastChangeIdx;
            //排序过程中一次也没有交换 flag=false
            if(!flag){
                break;
            }else {
                flag=false;
            }
        }
    }
}
