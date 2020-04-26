package Two11_23.KnapsackMix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 混合背包问题
 */
public class Knapsack {
    /**
     *物品，用于拆分
     */
    private static class Item{
        int v;
        int w;
        int k;

        public Item(int v, int w,int k) {
            this.v = v;
            this.w = w;
            this.k = k;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "v=" + v +
                    ", w=" + w +
                    ", k=" + k +
                    '}';
        }
    }
    public static void main(String[] args) {
        final int N = 1010;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cap = in.nextInt();
        //物品列表
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0;i < n;i++){
            //单个物品输入
            int v = in.nextInt();
            int w = in.nextInt();
            int s = in.nextInt();
            //对输入进行判断,如果大于0拆分
            if (s > 0){
                int k = 1;
                while (s >= k){
                    items.add(new Item(k*v,k*w,1));
                    s-=k;
                    k*=2;
                }
                if(s > 0){
                    items.add(new Item(s*v,s*w,1));
                }
            }else if(s == -1){
                items.add(new Item(v,w,1));
            }else {
                items.add(new Item(v,w,0));
            }
        }
        //处理结果
        int size = items.size();
        int[] f = new int[cap+1];
        Iterator it = items.iterator();
        while (it.hasNext()){
            Item temp = (Item)it.next();
            if(temp.k == 1){
                for (int j = cap;j >=temp.v;j--){
                    f[j] = Math.max(f[j],f[j - temp.v]+temp.w);
                }
            }else {
                for (int j = temp.v;j <= cap;j++){
                    f[j] = Math.max(f[j],f[j - temp.v] + temp.w);
                }
            }
        }
        System.out.println(f[cap]);
    }
}
