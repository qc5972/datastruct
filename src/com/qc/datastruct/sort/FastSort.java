package com.qc.datastruct.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**快速排序
 * @author qc
 * @create 2020-02-18 9:43
 */
public class FastSort {
    public static void main(String[] args) {
        int[] arr={5,6,1,0,4,8,7,10,2,-8,20,15};
        fastSort(0,arr.length-1,arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1=new int[800000];
        for(int i=0;i<arr1.length;i++){
            arr1[i]=(int)(Math.random()*800000);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date start=new Date();
        System.out.println("排序前"+sdf.format(start));
        fastSort(0,arr1.length-1,arr1);
        Date end=new Date();
        System.out.println("80000长度的数组排序花费了"+ sdf.format(end));

    }

    public static void fastSort(int left,int right,int[] arr){
        if(left>right){
            return;
        }
        int base=arr[left];//设置基准值
        int l=left;//定义指针l，指向数数组最左边
        int r=right;//定义指针r，指向数组最右边
        while (l!=r){//左指针-> 右指针<-
            while (arr[r]>=base&&r>l){//右指针移动到第一个比基准值小的元素停止
                r--;
            }
            while (arr[l]<=base&&l<r){//左指针移动到第一个比基准值大的元素停止
                l++;
            }

            //交换此时左右指针的元素
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
        }
        //循环完毕 l=r 此时左边全部小于等于基准值，右边全部大于等于基准值
        //循环退出时i=j，此时将基准值和此位置的元素进行交换,基准值为arr[left]
        arr[left]=arr[l];
        arr[l]=base;
        //将基准值左边的再次调用此方法，然后再右边，最后有序
        fastSort(left,r-1,arr);
        fastSort(l+1,right,arr);
    }
}
