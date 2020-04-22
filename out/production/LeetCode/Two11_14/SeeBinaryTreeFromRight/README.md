#### [二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/)

给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

#### 思路：
##### 1，广度优先搜索算法：
从每一层的左边开始向右边遍历，将最后一个节点值加入进结果中。可以用一次循环前的size()
来记录一层有多少个元素，这样就避免了使用两个队列
##### 2，深度优先搜索算法：
向下传递深度进行先根节点，再右节点最后左节点的方式递归。用res.size()来记录下一个需要的深度。
当深度等于下一个需要的深度时，把节点值加入结果列表中
