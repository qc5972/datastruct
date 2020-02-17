package com.qc.datastruct.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**插入排序：把n个元素分成有序表和无序表，开始时有序表只包含一个元素，无序表包含n-1个元素，排序过程中每次从无序表中取出第一个元素，
 * 把它的排序码一次与有序表的排序码进行比较，将他插入有序表的适当位置，使之成为新的有序表
 * 最小的一个元素插入到有序表的适当位置
 * 比如 4 5 6 此时要插入1
 * 4 5 6 6
 * 4 5 5 6
 * 4 4 5 6
 * 1 4 5 6
 * @author qc
 * @create 2020-02-17 21:03
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr={5,6,1,0,4,8,7,10};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1=new int[800000];
        for(int i=0;i<arr1.length;i++){
            arr1[i]=(int)(Math.random()*800000);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date start=new Date();
        System.out.println("排序前"+sdf.format(start));
        insertSort(arr1);
        Date end=new Date();
        System.out.println("80000长度的数组排序花费了"+ sdf.format(end));
    }
    public static void insertSort(int[] arr){
        int insertVal=0;//要插入元素的值
        int insertIdx=0;//指针
        for(int i=1;i<arr.length;i++){
            insertVal=arr[i];//待插入元素的值
            insertIdx=i-1;//将指针移动到待插入元素的前一个位置
            while (insertIdx>=0&&arr[insertIdx]>insertVal){//判断数组是否越界并且指针所指的元素是否大于带入元素
                arr[insertIdx+1]=arr[insertIdx];//待插入元素后移
                insertIdx--;
            }
            if(insertIdx+1!=i){
                arr[insertIdx+1]=insertVal;
            }
        }
    }
}
