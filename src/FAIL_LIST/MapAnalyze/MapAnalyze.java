package FAIL_LIST.MapAnalyze;

import java.util.LinkedList;

/**
 * 地图分析,给出海洋和陆地直接算即可
 */
public class MapAnalyze {
    public int maxDistance(int[][] grid) {
        int res = 0;
        //模版做法：用两个数组来记录要加入的偏移量
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
       //陆地队列
        LinkedList<Pos> lands = new LinkedList<>();
        //记录陆地的个数
        int landCount = 0;
        //遍历一遍把所有的陆地入队
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    //入队
                    lands.add(new Pos(i,j));
                    landCount++;
                }
            }
        }
        int oceanCount = grid.length * grid[0].length - landCount;
        if(landCount == 0 || oceanCount == 0){
            return -1;
        }
        //广度优先搜索
        while (lands.size()!=0 && oceanCount!=0){
            res++;
            int len = lands.size();
            for (int i =0;i < len;i++){
                //对每一个陆地，出队
                Pos aLand = lands.remove();
                for (int j = 0;j <4;j++){
                    int newX = aLand.row + dx[j];
                    int newY = aLand.column + dy[j];
                    if(newX < 0 ||newY < 0||newX > grid.length-1||newY > grid[0].length-1){
                        continue;
                    }
                    //否则判断是否需要入队
                    if(grid[newX][newY] == 0){
                        lands.add(new Pos(newX,newY));
                        grid[newX][newY] = 1;
                        oceanCount--;
                    }
                }
            }
        }
        return res;
    }
    private class Pos{
        int row;
        int column;

        public Pos(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,0,0};
        int[] b = {0,0,0};
        int[] c = {0,0,0};
        int[][] d = {a,b,c};
        MapAnalyze test = new MapAnalyze();
        System.out.println(test.maxDistance(d));
    }
}
