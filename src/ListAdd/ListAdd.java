package ListAdd;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class ListAdd {
    //ListNode的定义
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }

        /**
         * 为了测试引入一个构造函数，以数组为参数构建链表
         */
        public ListNode(int[] arr) {
            if (arr.length == 0) {
                this.val = 0;
                this.next = null;
            }
            //把该节点赋值为数组第一位
            this.val = arr[0];
            ListNode tempNode = this;
            for (int i = 1; i < arr.length; i++) {
                //新建一个节点并赋值next
                ListNode aNode = new ListNode(arr[i]);
                aNode.next = tempNode.next;
                //连接上链表
                tempNode.next = aNode;
                //切换至下一个节点继续赋值
                tempNode = aNode;
            }
        }
    }

    /**
     * @param l1
     * @param l2
     * @return ListNode
     * @description 核心算法函数
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //将原链表中每个节点的值提出来并插入新的链表
        //每次往头部插相当于反转链表
        ListNode l1Rever = l1;
        ListNode l2Rever = l2;
        //链表中的单元一个一个相加，并设置flag，为1则表示进位
        int flag = 0;
        //记录结果,res.next为结果
        ListNode res = new ListNode(0);
        //aRes代替res沿着链表进行往下增加
        ListNode aRes = res;
        while (!(l1Rever == null || l2Rever == null)) {
            int temp = l1Rever.val + l2Rever.val + flag;
            //大于等于10则进位
            if (temp >= 10) {
                aRes.next = new ListNode(temp % 10);
                flag = 1;
            } else {
                aRes.next = new ListNode(temp);
                flag = 0;
            }
            //沿着链表走一格
            aRes = aRes.next;
            //设置两个标志，分别记录两个链表是否为空
            boolean f1 = false;
            boolean f2 = false;
            //判断是否有下一步
            if (l1Rever.next != null) {
                l1Rever = l1Rever.next;
                f1 = false;
            } else {
                l1Rever.val = 0;
                f1 = true;
            }
            //对l2Rever
            if (l2Rever.next != null) {
                l2Rever = l2Rever.next;
                f2 = false;
            } else {
                l2Rever.val = 0;
                f2 = true;
            }
            //判断是否已经全部走到结尾
            //是的话，考虑最后进位1
            if (f1 && f2) {
                if (flag == 1) {
                    aRes.next = new ListNode(1);
                }
                break;
            }
        }
        return res.next;
    }

    /**
     * @param node
     * @description 单链表反转函数，但是多余，因为刚开始思路错了
     */
    public ListNode insertHead(ListNode node) {
        //用一个新链表来记录反转结果，带头
        ListNode head = new ListNode(0);
        head.next = new ListNode(node.val);
        //迭代检查，直到末尾，每次插入到头部
        while (node.next != null) {
            node = node.next;
            ListNode aNode = new ListNode(node.val);
            //每次插入头部，相当于逆序反转
            aNode.next = head.next;
            head.next = aNode;
        }
        return head.next;
    }

    /**
     * @description 为测试而构建的遍历函数，以便看到结果
     */
    public void traverse(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    /**
     * 测试函数
     */
    public void test() {
        int[] a = {9};
        ListNode test1 = new ListNode(a);
        int[] b = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        ListNode test2 = new ListNode(b);

        traverse(addTwoNumbers(test1, test2));
    }

    /**
     * @description 主函数
     */
    public static void main(String[] args) {
        ListAdd t = new ListAdd();
        t.test();
    }
}

