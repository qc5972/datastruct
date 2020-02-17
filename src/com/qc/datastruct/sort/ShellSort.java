package com.qc.datastruct.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**插入排序适合小规模数据或者数组基本有序时比较高效，希尔排序是插入排序的升级版，它对大规模数据并且无序的数据也十分高效

 * @author qc
 * @create 2020-02-17 22:03
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr={5,6,1,0,4,8,7,10};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1=new int[50];
        for(int i=0;i<arr1.length;i++){
            arr1[i]=(int)(Math.random()*50);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date start=new Date();
        System.out.println("排序前"+sdf.format(start));
        shellSort(arr1);
        Date end=new Date();
        System.out.println("80000长度的数组排序花费了"+ sdf.format(end));
        System.out.println(Arrays.toString(arr1));
    }
    public static void shellSort(int[] arr){
        int insertVal=0;
        int insertIdx=0;
        for(int gap=arr.length/2;gap>0;gap/=2){//加入数组的长度 9  1.分成4组进行插入排序   2.分成2组  3 分成1组 4 分成0组 每一组进行后数组的有序程度增加
            for(int i=gap;i<arr.length;i++){
                insertVal=arr[i];//待插入的元素
                insertIdx=i-gap;//指针
                if(arr[i]<arr[insertIdx]){
                    while (insertIdx>=0&&arr[insertIdx]>insertVal){
                        arr[insertIdx+gap]=arr[insertIdx];
                        insertIdx-=gap;
                    }
                    arr[insertIdx+gap]=insertVal;
                }

            }
        }
    }
}
