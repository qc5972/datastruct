package com.qc.datastruct.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**归并排序:分治的思想：先分再治
 * @author qc
 * @create 2020-02-18 10:25
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr={5,6,1,0,4,8,7,10,2,-8,20,15};
        int[] temp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
        int[] arr1=new int[80];
        for(int i=0;i<arr1.length;i++){
            arr1[i]=(int)(Math.random()*80);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date start=new Date();
        System.out.println("排序前"+sdf.format(start));
        temp=new int[arr1.length];
        mergeSort(arr1,0,arr1.length-1,temp);
        Date end=new Date();
        System.out.println("80000长度的数组排序花费了"+ sdf.format(end));
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }

    }

    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int l=left;//左指针
        int r=mid+1;//右指针
        int t=0;//数组temp的指针
        while (l<=mid&&r<=right){
            if(arr[l]<=arr[r]){
                temp[t]=arr[l];
                t++;
                l++;
            }else {
                temp[t]=arr[r];
                r++;
                t++;
            }
        }
        /**
         * 上面的循环肯定能将左右两个数组的一个全部移动到temp数组中，但是剩下的一个数组可能或有剩余元素
         * 假如左边数组已经全部存放到temp数组中，
         * 右边的数组有剩余，则需要将剩余元素数组的所有元素移动到temp数组中
         */
        while (l<=mid){
            temp[t]=arr[l];
            t++;
            l++;
        }
        while (r<=right){
            temp[t]=arr[r];
            r++;
            t++;
        }
        //将temp数组的元素拷贝到arr数组中
        t=0;//重置temp的指针为数组的初始位置
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }
    }

}
