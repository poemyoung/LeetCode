package MergeArr;

import java.util.Arrays;

/**
 * 何并排序数组
 */
public class MergeArr {
    public void merge(int[] A, int m, int[] B, int n) {
        //依次检测B
        //定义一个记录值减少搜索次数
        int k  = 0;
        for (int i = 0;i < n;i++){
            //找到A中第一个大于B[i]的数
            for (int j = k;j <= m - 1 + i;j++){
                if(A[j] > B[i]){
                    k = j;
                    break;
                }else if(j == m-1+i){
                    k  =j;
                }
            }
            //移动插入
            for (int w = m + i;w >= k+1;w--){
                A[w] = A[w-1];
            }
            A[k] = B[i];
        }
    }
    public static void main(String[] args) {
        MergeArr test = new MergeArr();
        int[] A = {1,2,3,0,0,0};
        int[] B  ={2,5,6};
        test.merge(A,3,B,3);
    }
}
