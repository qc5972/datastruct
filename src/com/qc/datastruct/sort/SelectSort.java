package com.qc.datastruct.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**选择排序：第一次循环找到最小的元素 ，与arr[0]进行交换，第二次循环从arr[1]开始，找到最小的元素与arr[1]交换，一次类推
 * 也就是数组每一次循环都会找到最小的元素
 * @author qc
 * @create 2020-02-17 20:46
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr={5,6,1,0,4,8,7,10};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1=new int[80000];
        for(int i=0;i<arr1.length;i++){
            arr1[i]=(int)(Math.random()*80000);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date start=new Date();
        System.out.println("排序前"+sdf.format(start));
        selectSort(arr1);
        Date end=new Date();
        System.out.println("80000长度的数组排序花费了"+ sdf.format(end));
    }
    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int min=arr[i];
            int idx=i;//最小值的下标
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<min){
                    min=arr[j];
                    idx=j;
                }
            }
            if(i!=idx){
                arr[idx]=arr[i];
                arr[i]=min;
            }
        }
    }
}
