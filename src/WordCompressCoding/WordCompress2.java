package WordCompressCoding;

import java.util.ArrayList;

/**
 * 使用前缀树的方式实现单词压缩编码
 */
public class WordCompress2 {
    public int minimumLengthEncoding(String[] words) {
        //逐个建立前缀树
        Node root  = new Node();
        for (String a : words){
            buildNode(root,a);
        }
        return leafLen(0,root);
    }
    /**
     * 前缀树节点
     */
    public class Node{
        //指针数组，指向叶子节点
       ArrayList<Node> children = new ArrayList<>();
       //节点本身的值
        char val;

        public Node(char val) {
            this.val = val;
        }

        public Node() {
        }

        /**
         * 搜索子节点是否存在某个字符
         */
        public Node search(char s){
            for (Node node : children){
                if(node.val == s){
                    return node;
                }
            }
            return null;
        }
    }
    //建立前缀树方法
    private void buildNode(Node node,String s){
        //基准条件
        if(s.length() == 0){
            return;
        }
        //先找孩子节点中有没有最后一个字符
        char last = s.charAt(s.length()-1);
        //标志位判断找到与否
        boolean f = false;
        String sub = s.substring(0,s.length() -1);
        //寻找包含该字符的节点
        if(node.children.size() > 0) {
            for (Node a : node.children) {
                if (a.val == last) {
                    buildNode(a, sub);
                    f = true;
                }
            }
        }
        //没找到
        if(!f){
            Node newNode = new Node(last);
            node.children.add(newNode);
            buildNode(newNode,sub);
        }
    }
    //返回所有叶子节点
    public int leafLen(int depth,Node node){
        //基准条件
        int count = 0;
        if(node.children.size() == 0){
            return depth+1;
        }
        //递归
        for (Node a : node.children){
           count += leafLen(depth+1,a);
        }
        return count;
    }

//    /**
//     * 调试方法，打印
//     */
//    public void printTree(Node a,int d){
//        System.out.println("第"+d+"层"+a.val);
//        for (Node b: a.children){
//            printTree(b,d+1);
//        }
//    }
    public static void main(String[] args) {
        WordCompress2 test = new WordCompress2();
        String[] a = {"me","time"};
        int res = test.minimumLengthEncoding(a);
        System.out.println(res);
    }
}
