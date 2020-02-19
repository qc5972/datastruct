package com.qc.datastruct.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**vertext ：结点
 * @author qc
 * @create 2020-02-19 20:46
 */
public class Graph {

    public static void main(String[] args) {
        String[] vals={"A","B","C","D","E"};
        Graph graph=new Graph(vals.length);
        for(String val:vals){
            graph.insertVer(val);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.showGraph();
        graph.dfs();
    }

    /**
     * 对dfs进行方法的重载
     */
    public void dfs(){
        for(int i=0;i<vertexList.size();i++){
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    /**
     * dfs遍历查找所有结点
     * @param isVisited
     * @param idx
     */
    private void dfs(boolean[] isVisited,int idx){
        System.out.print(getValByIdx(idx)+"->");
        isVisited[idx]=true;
        int m = getFirstNeighbour(idx);//找到idx的下一个邻接结点
        while (m!=-1){//说明存在邻接结点
            if(!isVisited[m]){//该邻接结点没有被访问
                dfs(isVisited,m);
            }
            m=getNeighbourNext(idx,m);
        }
    }

    /**
     * 获取第一个邻接节点的下标
     * @param idx
     * @return 找到返回i 未找到返回-1
     */
    public int getFirstNeighbour(int idx){
        for(int i=0;i<vertexList.size();i++){
            if(endges[idx][i]>0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取邻接结点的邻接结点
     * @param curIdx
     * @param nextIdx
     * @return
     */
    public int getNeighbourNext(int curIdx,int nextIdx){
        for(int i=nextIdx+1;i<vertexList.size();i++){
            if(endges[curIdx][i]>0){
                return i;
            }
        }
        return -1;
    }

    private ArrayList<String> vertexList;//节点
    private int[][] endges;//邻接矩阵 -》边
    private int numsOfEndges;//总边数4
    private boolean[] isVisited;

    public Graph(int n){
        vertexList=new ArrayList<>();
        endges=new int[n][n];
        numsOfEndges=0;
        isVisited=new boolean[n];
    }

    /**
     * 添加节点
     * @param val
     */
    public void insertVer(String val){
        vertexList.add(val);
    }

    /**
     * 添加边 说明：双向
     * @param v1 结点1 的索引
     * @param v2 结点1 的索引
     * @param weight 边的权值
     */
    public void insertEdge(int v1,int v2,int weight){
        endges[v1][v2]=weight;
        endges[v2][v1]=weight;
        numsOfEndges++;
    }

    /**
     * 获取图总共结点的数目
     * @return
     */
    public int getVertexNum(){
        return vertexList.size();
    }

    /**
     * 获取边的数目
     * @return
     */
    public int endgeNum(){
        return numsOfEndges;
    }

    /**
     * 显示图对应的邻接矩阵
     */
    public void showGraph(){
       for(int[] arr:endges){
           System.out.println(Arrays.toString(arr));
       }
    }

    /**
     * 根据idx获取val
     * @param idx
     * @return
     */
    public String getValByIdx(int idx){
        return vertexList.get(idx);
    }

}
