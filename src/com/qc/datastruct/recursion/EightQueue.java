package com.qc.datastruct.recursion;

/**八皇后问题
 * 定义一个数组 int[8] arr 数组的下标代表列第几列  数组的值代表行
 * arr[0]=0 棋盘的第一行第一列
 * @author qc
 * @create 2020-02-17 19:45
 */
public class EightQueue {
    int max=8;//定义棋盘的大小
    int[] arr=new int[max];//定义8*8棋盘
    public static int count;//计数

    public static void main(String[] args) {
        EightQueue eightQueue=new EightQueue();
        eightQueue.check(0);
        System.out.println("总共："+count);
    }

    public void check(int n){
        //当n到max值，说明已经皇后所有的位置已经放好了
        if(n==max){
            print();
            return;
        }
        //依次判断皇后的位置
        for(int i=0;i<arr.length;i++){
            arr[n]=i;
            //判断当前放置的位置与其他皇后是否冲突
            if(judge(n)){
                //不冲突 继续放 开始递归
                check(n+1);
            }
        }

    }

    /**
     * 判断皇后是否在同一列或者同一行或者在同一条直线上
     * @param n
     * @return
     */
    public boolean judge(int n){
        for(int i=0;i<n;i++){
            //判断当前的皇后和之前已经拜访的皇后是否是在同一行或者在同一对角线线上
            if(arr[i]==arr[n]||Math.abs(i-n)==Math.abs(arr[i]-arr[n])){
                return false;
            }
        }
        return true;
    }

    /**
     * 打印皇后的摆放位置
     */
    public void print(){
        count++;
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
}
