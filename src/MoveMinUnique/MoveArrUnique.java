package MoveMinUnique;

/**
 * 使得数组唯一的最小的增量
 */
public class MoveArrUnique {
    public int minIncrementForUnique(int[] A) {
        int res = 0;
        //处理数组
        int len = A.length;
        //新建hash数组
        int[] hashArr = new int[80010];
        //放入元素
        for (int i  =0;i < len;i++){
            if(hashArr[A[i]]!=0){
                //循环找空位
                int pos = A[i];
                while (hashArr[pos]!=0){
                    res++;
                    pos++;
                }
                hashArr[pos] = 1;
            }else {
                hashArr[A[i]] = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MoveArrUnique test = new MoveArrUnique();
        int[] a ={3,2,1,2,1,7};
        System.out.println(test.minIncrementForUnique(a));
    }
}
