package Two11_14.SeeBinaryTreeFromRight;

import java.util.*;

public class BinaryView {
    /**
     *主实现类
     * 想法：使用从右到左的层次遍历，每个深度的放入一个队列，取出第一个记录再记录之后的节点
     */
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        //两个队列互相倒节点
        Queue<TreeNode>queue1 = new LinkedList<>();
        Queue<TreeNode>queue2 = new LinkedList<>();
        //队列1放入根节点
        queue1.add(root);
        //记录倒的方向
        //true为从1到2
        boolean flag = true;
        while (!queue1.isEmpty()||!queue2.isEmpty()){
            if(flag){
                res.add(queue1.peek().val);
                //全部倒入另外一个队列中去
                while (!queue1.isEmpty()){
                    TreeNode a = queue1.remove();
                    if(a.right!=null){
                        queue2.add(a.right);
                    }
                    if(a.left!=null){
                        queue2.add(a.left);
                    }
                }
            }else {
                res.add(queue2.peek().val);
                while (!queue2.isEmpty()){
                    TreeNode b = queue2.remove();
                    if(b.right!=null){
                        queue1.add(b.right);
                    }
                    if(b.left!=null){
                        queue1.add(b.left);
                    }
                }
            }
            flag = !flag;
        }
        return res;
    }
    /**
     * 节点类定义
     */
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    /**
     * 测试
     */
    public static void main(String[] args) {
        TreeNode one = new BinaryView().new TreeNode(1);
        TreeNode two = new BinaryView().new TreeNode(2);
        TreeNode three = new BinaryView().new TreeNode(3);
        TreeNode four = new BinaryView().new TreeNode(4);
        TreeNode five = new BinaryView().new TreeNode(5);
        TreeNode six = new BinaryView().new TreeNode(6);
        one.left = two;one.right = three;
        two.right = five;
        three.right = four;
        List<Integer> test = new BinaryView().rightSideView(one);
        Integer[] res =new Integer[test.size()];
        test.toArray(res);
        System.out.println(Arrays.toString(res));
    }
}
