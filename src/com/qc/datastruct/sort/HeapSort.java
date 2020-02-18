package com.qc.datastruct.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**堆排序
 * 堆：一种完全二叉树，节点大于它的所有子节点
 * 堆排序的步骤:先找到第一个非叶子节点 （数组的长度/2-1）
 * @author qc
 * @create 2020-02-18 13:23
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr={5,6,1,0,4,8,7,10,2,-8,20,15};
        int[] temp=new int[arr.length];
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1=new int[80];
        for(int i=0;i<arr1.length;i++){
            arr1[i]=(int)(Math.random()*80);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date start=new Date();
        System.out.println("排序前"+sdf.format(start));
        temp=new int[arr1.length];
        heapSort(arr1);
        Date end=new Date();
        System.out.println("80000长度的数组排序花费了"+ sdf.format(end));
    }
    public static void heapSort(int[] arr){
        //转换成大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            addjust(arr,i,arr.length);
        }
        int temp=0;
        for(int j=arr.length-1;j>0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            addjust(arr,0,j);
        }

    }

    /**
     *
     * @param arr
     * @param i
     * @param length 数组的长度
     */
    public static void addjust(int[] arr,int i,int length){
        int temp=0;
        for(int k=2*i+1;k<length;k=2*k+1){
            if(k+1<length&&arr[k+1]>arr[k]){
                k++;
            }
            if(arr[k]>arr[i]){//如果子节点比父节点的值大，则进行交换
                temp=arr[k];
                arr[k]=arr[i];
                arr[i]=temp;
            }else {//负责 已经满足大顶堆的条件了
                break;
            }
        }
    }
}
