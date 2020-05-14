package CourseTable;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 拓补排序决定先选什么课程
 * 用邻接表法进行表示
 * 数组里面只放度数
 */
public class CourseStudy {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //建一个数组放置度数
        int[] degree = new int[numCourses];
        LinkedList<Integer>[] list = new LinkedList[numCourses];
       for (int i = 0;i < list.length;i++){
           list[i] = new LinkedList<>();
       }

        //遍历输入，遇到在第二列入度加一
        //遇到在第一列加入链表中
        for (int i = 0;i < prerequisites.length;i++){
            //hash表法找位置
           degree[prerequisites[i][1]]++;
           //添加邻接表
            list[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        //System.out.println(list[0].size()+"    "+list[1].size());
        //遍历数组，每次找入度为0，找不到返回false
        boolean f = true;
        boolean flag = false;
        while (f){
            for (int i = 0;i < numCourses;i++){
                //找入度为0的课程
                if(degree[i] == 0){
                    flag = true;
                    //找到将degree减为-1表示已经学习了
                    degree[i] = -1;
                    //同时还要以入度为该课程的所有linklist度数减一
                    for (int j = 0;j < list[i].size();j++){
                       int tmp =  list[i].get(j);
                       degree[tmp]--;
                      // list[i].remove(j);
                    }
                }
            }
            if(!flag){
                f = false;
                break;
            }
            flag = false;
        }
        for (int i = 0;i < degree.length;i++){
            if(degree[i] != -1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CourseStudy test = new CourseStudy();
        int[][] a = new int[1][2];
        a[0][0] = 1; a[0][1] = 0;
        //a[1][0] = 0; a[1][1] = 1;
        System.out.println(test.canFinish(2,a));
    }
}
