package One1_10.JosephusProblem;

import java.util.Arrays;

/**
 * 问题解决类
 */
public class JoeProblem {
    //记录挨着出来的顺序列表
    int[] seq;
    //记录最终赢家
    int winner;
    //有多少人
    int N;
    //每次传递多少个
    int M;
    /**
     * 类：
     * 环形链表
     * 双向链表
     */
    private static class Circle{
        /**
         * 维护一个节点类
         */
        private static class Node{
            //节点值,表示第几号人
            public int num;
            //节点指针，指向下一个节点
            public Node next;
            //节点指针，指向上一个节点
            public Node prev;
            //构造函数
            public Node(){
            }
            //带参构造函数
            public Node(int num){
                this.num = num;
            }
        }
        //构造函数，传入长度：N
        public Circle(int N){
            //从一号开始
            head  = new Node(1);
            size++;
            position = head;
            //添加至有n个人
            for(int i = 2;i <=N;i++){
                addNode(i);
                size++;
            }
            //形成双链表
            buildLink();
        }
        //记录长度
        public int size;
        //节点定位指针,尾
        Node position;
        //节点最前指针，头
        Node head;
        /**
         * 添加节点
         */
        public void addNode(int num){
            //新的节点
            Node newNode = new Node(num);
            //形成双向链表
            newNode.prev = position;
            position.next = newNode;
            position = newNode;
        }
        /**
         * 形成双向链表
         */
        public void buildLink(){
            position.next = head;
            head.prev = position;
            position = head;
        }
        /**
         * 移出节点，第M位节点（定位）
         */
        public int removeNode(int M){
            //如果没有元素了
            if(size == 0){
                return 0;
            }
            //找到要移除的节点
            for(int i = 0;i < M;i++){
                position = position.next;
            }
            //特殊情况，找出赢家
            if(size == 1){
                size--;
                return position.num;

            }
            //删除节点
            position.prev.next = position.next;
            position.next.prev = position.prev;
            int res = position.num;
            position = position.next;
            size--;
            return res;
        }
    }
    /**
     * 构造函数，传递m和n
     */
    public JoeProblem(int M,int N){
        this.M = M;
        this.N = N;
        this.seq = new int[N-1];
        Circle circleLink = new Circle(N);
        //循环消除人
        for(int i = N;i > 0;i--){
            if(i!=1)
            this.seq[N-i] = circleLink.removeNode(M);
            else
                this.winner =circleLink.removeNode(M);
        }

    }
    /**
     * 返回和存储结果函数
     */
    public int getWinner(){
        return winner;
    }
    /**
     * 返回序列
     */
    public int[] getSeq(){
        return seq;
    }
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        JoeProblem test = new JoeProblem(5,5);
        System.out.println(Arrays.toString(test.getSeq())+"    赢家是"+test.getWinner());
    }

}
