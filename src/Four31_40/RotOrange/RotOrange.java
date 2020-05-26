package Four31_40.RotOrange;

import java.util.LinkedList;

/**
 * 腐烂的桔子
 */
public class RotOrange {
    public int orangesRotting(int[][] grid) {
        //特殊情况
        if(grid.length == 0){
            return -1;
        }
        //结果
        int res = 0;
        //好桔子个数
        int count = 0;
        //遍历整个数组，目标：找到烂桔子放进队列，数出好桔子个数
        LinkedList<int[]>queue = new LinkedList<int[]>();
        //遍历
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    count++;
                }
                if(grid[i][j] == 2){
                    int[] tmp = {i,j};
                    queue.add(tmp);
                }
            }
        }

        while (count > 0 && queue.size()!=0){
            //烂桔子现在的个数
            //队列中应该要弹出的个数
            int sizeTmp = queue.size();
            //过一分钟
            res++;
            //队列弹出一个烂橘子，然后周围好桔子全部加入队列
            for (int i = 0;i < sizeTmp;i++){
                int[] tmp = queue.remove();
                //查找周围桔子
                if(tmp[0] > 0){
                    if(grid[tmp[0] - 1][tmp[1]] == 1){
                        grid[tmp[0] - 1][tmp[1]] = 2;
                        int[] tmp2 = {tmp[0] - 1,tmp[1]};
                        queue.add(tmp2);
                        count--;
                    }
                }
                if(tmp[0] < grid.length-1){
                    if(grid[tmp[0]+1][tmp[1]] == 1){
                        grid[tmp[0]+1][tmp[1]] = 2;
                        int[] tmp2 = {tmp[0]+1,tmp[1]};
                        queue.add(tmp2);
                        count--;
                    }
                }
                if(tmp[1] > 0){
                    if(grid[tmp[0]][tmp[1] - 1] == 1){
                        grid[tmp[0]][tmp[1] - 1] = 2;
                        int[] tmp2 = {tmp[0],tmp[1] - 1};
                        queue.add(tmp2);
                        count--;
                    }
                }
                if(tmp[1] < grid[0].length-1){
                    if(grid[tmp[0]][tmp[1] + 1] == 1){
                        grid[tmp[0]][tmp[1] + 1 ] = 2;
                        int[] tmp2 = {tmp[0],tmp[1] + 1};
                        queue.add(tmp2);
                        count--;
                    }
                }
            }
        }
        if(count!=0){
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        RotOrange test = new RotOrange();
        int[] a = {2,1,1};
        int[] b = {1,1,0};
        int[] c = {0,1,1};
        int[][] d = {a,b,c};
        System.out.println(test.orangesRotting(d));
    }
}
